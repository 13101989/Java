package com.example.spring_ch11_OpenFeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.example.spring_ch11_OpenFeign.proxies")
public class ProjectConfig {
}
