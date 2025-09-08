package ch4.ex6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch4.ex6.proxies", "ch4.ex6.repositories", "ch4.ex6.services"})
public class ProjectConfiguration {
}
