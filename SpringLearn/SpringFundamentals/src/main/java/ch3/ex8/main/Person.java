package ch3.ex8.main;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class Person {
    private final Parrot parrot;
    private String name = "Ella";


//    public Person(Parrot parrot1) {
//        this.parrot = parrot1;
//    }

    public Person(@Qualifier("parrot2") Parrot parrot) {
        this.parrot = parrot;
    }

}
