package ch4.ex5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch4.ex5.proxies", "ch4.ex5.repositories", "ch4.ex5.services"})
public class ProjectConfiguration {
}
