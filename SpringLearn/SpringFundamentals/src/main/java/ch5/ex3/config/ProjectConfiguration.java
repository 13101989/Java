package ch5.ex3.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch5.ex3.services"})
public class ProjectConfiguration {
}
