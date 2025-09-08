package ch4.ex4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch4.ex4.proxies", "ch4.ex4.repositories", "ch4.ex4.services"})
public class ProjectConfiguration {
}
