/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.flowershop.be.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@Import({JpaConfig.class, SecurityConfig.class, WebAppConfig.class, JmsConfig.class})
@PropertySources(@PropertySource(value = "classpath:configuration.properties"))
@EnableAspectJAutoProxy
public class BootConfig {
    
}
