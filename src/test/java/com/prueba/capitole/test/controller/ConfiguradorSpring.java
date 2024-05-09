package com.prueba.capitole.test.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.prueba.capitole.service", "com.prueba.capitole.repository"})
public class ConfiguradorSpring {
  
}