package ch5.ex2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch5.ex2.services", "ch5.ex2.repositories"})
public class ProjectConfiguration {
}
