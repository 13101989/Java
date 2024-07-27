package main.java;

import main.java.containers.Address;
import main.java.containers.Hobby;
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

        Hobby hobby1 = new Hobby("video games", 2, "week");
        Hobby hobby2 = new Hobby("football", 1, "week");
        Hobby hobby3 = new Hobby("mountain walks", 1, "month");

        Address address1 = new Address("Romania", "Busteni", "aStreet");
        Address address2 = new Address("France", "Paris", "aStreet");
        Address address3 = new Address("Netherlands", "Amsterdam", "aStreet");
        Address address4 = new Address("USA", "Los Angeles", "aStreet");
        Address address5 = new Address("Switzerland", "Interlaken", "aStreet");
        Address address6 = new Address("United Kingdom", "London", "aStreet");

        hobby1.addLocation(address3);
        hobby1.addLocation(address2);
        hobby1.addLocation(address6);
        hobby2.addLocation(address2);
        hobby2.addLocation(address6);
        hobby2.addLocation(address4);
        hobby3.addLocation(address1);
        hobby3.addLocation(address5);

        person1.addHobby(hobby1);
        person2.addHobby(hobby2);
        person2.addHobby(hobby3);

        for (Person person : personTreeSet) {
            System.out.println(person.hobbies);
        }
    }


}
