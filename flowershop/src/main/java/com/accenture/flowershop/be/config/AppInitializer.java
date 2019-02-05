package com.accenture.flowershop.be.config;

import java.util.EnumSet;
import javax.naming.Context;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import com.accenture.flowershop.be.access.ContextStartedListener;
import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.filter.DelegatingFilterProxy;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {
        WebApplicationContext applicationContext = createServletApplicationContext();

        container.addListener(new ContextLoaderListener(applicationContext));
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", DispatcherServlet.class);
        dispatcher.setInitParameter("contextConfigLocation", "");
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("springSecurityFilterChain");
	delegatingFilterProxy.setTargetFilterLifecycle(true);
        
        FilterRegistration securityFilterReg = container.addFilter("springSecurityFilterChain", delegatingFilterProxy);
        securityFilterReg.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext webAppContext
                = new AnnotationConfigWebApplicationContext();
        webAppContext.register(JpaConfig.class);
        webAppContext.register(SecurityConfig.class);
        webAppContext.register(WebAppConfig.class);
        return webAppContext;
    }
}
