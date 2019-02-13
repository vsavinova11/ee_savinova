package com.accenture.flowershop.be.config;

import com.accenture.flowershop.be.entity.user.Client;
import com.accenture.flowershop.be.business.FlowerStockWebService;
import com.accenture.flowershop.fe.dto.DiscountRequest;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;
import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.bus.spring.SpringBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.accenture.flowershop")
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);

        return resolver;
    }

    @Bean
    public Jaxb2Marshaller marshaller() throws JAXBException {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Client.class, DiscountRequest.class);
        Map<String,Object> props = new HashMap<>();
        props.put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setMarshallerProperties(props);
        return marshaller;
    }
    
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return new SpringBus();
    }
    
    @Bean
    @Autowired 
    public Endpoint endpoint(FlowerStockWebService ws)
    {
        EndpointImpl endpoint = new EndpointImpl(springBus(), ws);
        endpoint.publish("/flowers");
        return endpoint;
    }

}
