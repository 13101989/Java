package main.java.containers;

import java.util.Objects;

public class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(name, person.name) && age == person.age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person person){
        int ageComparison = Integer.compare(age, person.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        return name.compareTo(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                "}";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

