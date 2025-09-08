package ch5.ex7.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"ch5.ex7.services", "ch5.ex7.repositories", "ch5.ex7.processors"})
public class ProjectConfiguration {
}
