package ch5.ex6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch5.ex6.services", "ch5.ex6.repositories"})
public class ProjectConfiguration {
}
