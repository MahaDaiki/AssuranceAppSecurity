package org.example.assuranceapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.assuranceapp", "org.example.assuranceapp.service.serviceImplementation"})
public class AppConfig {
}
