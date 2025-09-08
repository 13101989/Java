package ch3.ex4.main;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Person {
    private String name = "Ella";

    @Autowired
    private Parrot parrot;

}
