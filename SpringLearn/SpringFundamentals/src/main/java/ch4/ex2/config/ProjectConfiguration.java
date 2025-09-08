package ch4.ex2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch4.ex2.proxies", "ch4.ex2.repositories", "ch4.ex2.services"})
public class ProjectConfiguration {
}
