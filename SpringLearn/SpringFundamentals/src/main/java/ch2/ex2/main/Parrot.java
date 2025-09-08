package ch2.ex2.main;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Getter
@Setter
@Component
public class Parrot {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Initial Parrot Name";
    }
}
