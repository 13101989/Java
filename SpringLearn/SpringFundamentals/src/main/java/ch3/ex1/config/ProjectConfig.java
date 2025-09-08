package ch3.ex1.config;

import ch3.ex1.main.Parrot;
import ch3.ex1.main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProjectConfig {
    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("Koko");
        return p;
    }

    @Bean
    public Person Person() {
        Person p = new Person();
        p.setName("Ella");
        return p;
    }
}
