package ch3.ex5.main;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Person {
    private final Parrot parrot;
    private String name = "Ella";

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
    }

}
