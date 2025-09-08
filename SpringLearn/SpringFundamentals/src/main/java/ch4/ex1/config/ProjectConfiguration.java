package ch4.ex1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch4.ex1.proxies", "ch4.ex1.repositories", "ch4.ex1.services"})
public class ProjectConfiguration {
}
