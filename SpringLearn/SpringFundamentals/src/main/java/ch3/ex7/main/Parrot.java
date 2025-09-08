package ch3.ex7.main;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Parrot {
    private String name;

    public Parrot() {
        System.out.println("Parrot created");
    }

    @Override
    public String toString() {
        return "Parrot : " + name;
    }
}
