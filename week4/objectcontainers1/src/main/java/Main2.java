package main.java;

import main.java.containers.Address;
import main.java.containers.Hobby;
import main.java.containers.Person;

import java.util.*;

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

        hobby1.addLocationToPractice(address3);
        hobby1.addLocationToPractice(address2);
        hobby1.addLocationToPractice(address6);
        hobby2.addLocationToPractice(address2);
        hobby2.addLocationToPractice(address6);
        hobby2.addLocationToPractice(address4);
        hobby3.addLocationToPractice(address1);
        hobby3.addLocationToPractice(address5);

        System.out.println();
        person1.addHobby(hobby1);
        person2.addHobby(hobby2);
        person2.addHobby(hobby3);

        System.out.println();
        for (Person person : personTreeSet) {
            System.out.println("Person name is " + person.getName() + " and is " + person.getAge() + " years old.");
        }

        Map<Person, List<Hobby>> mapPersonHobbies = new HashMap<>();
        mapPersonHobbies.put(person1, person1.getHobbies());
        mapPersonHobbies.put(person2, person2.getHobbies());
        mapPersonHobbies.put(person3, person3.getHobbies());

        System.out.println();
        for (Map.Entry<Person, List<Hobby>> entry : mapPersonHobbies.entrySet()) {
            System.out.println(entry.getKey() + " has the following hobbies: " + entry.getValue());
        }
    }


}
