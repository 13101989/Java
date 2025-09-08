package ch2.ex3.main;

import ch2.ex3.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot1 = new Parrot();
        parrot1.setName("Parrot One");

        Parrot parrot2 = new Parrot();
        parrot2.setName("Parrot Two");

        Supplier<Parrot> supplier1 = () -> parrot1;
        Supplier<Parrot> supplier2 = () -> parrot2;

        context.registerBean("parrot", Parrot.class, supplier1);
        context.registerBean("parrot2", Parrot.class, supplier2, bc -> bc.setPrimary(true));

        Parrot p = context.getBean(Parrot.class);
        Parrot p1 = context.getBean("parrot", Parrot.class);
        Parrot p2 = context.getBean("parrot2", Parrot.class);

        System.out.println("Primary Parrot: " + p.getName());
        System.out.println("Parrot bean: " + p1.getName());
        System.out.println("Parrot2 bean: " + p2.getName());

    }
}