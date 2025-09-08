package ch3.ex4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "ch3.ex4.main")
public class ProjectConfig {
}
