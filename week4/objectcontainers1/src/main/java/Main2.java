package main.java;

import main.java.containers.Person;

import java.util.Comparator;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) {
//        comparator compares first on name and after on age and comparable the opposite
        Comparator<Person> personComparator = Comparator
                .comparing(Person::getName)
                .thenComparingInt(Person::getAge);

        TreeSet<Person> personTreeSet = new TreeSet<>(); // new TreeSet<>(personComparator);

        Person person1 = new Person("John2", 40);
        Person person2 = new Person("John", 50);
        Person person3 = new Person("John3", 30);

        personTreeSet.add(person1);
        personTreeSet.add(person2);
        personTreeSet.add(person3);

        for (Person person : personTreeSet) {
            System.out.println(person);
        }
    }





}
