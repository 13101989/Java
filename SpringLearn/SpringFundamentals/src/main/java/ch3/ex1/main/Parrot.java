package ch3.ex1.main;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Parrot {
    private String name;

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
