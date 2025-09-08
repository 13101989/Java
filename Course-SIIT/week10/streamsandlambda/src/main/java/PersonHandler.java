package main.java;

import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static main.java.Person.PERSON_COMPARATOR;

@Getter
public class PersonHandler {
    private List<Person> persons = new ArrayList<>();

    public void findAndReturnPersonsBornInSpecificMonth(String csvToRead, int month, String fileToWrite) throws IOException {
        readAndParsePersonsFromCsvFile(csvToRead);

        List<String> personsBornInSameMonth =
                persons
                        .stream()
                        .filter(person -> person.getDateOfBirth().getMonth().getValue() == month)
                        .sorted(PERSON_COMPARATOR)
                        .map(Person::toString)
                        .collect(Collectors.toList());

        String firstLine = Stream.of(
                personsBornInSameMonth.isEmpty()
                        ? "No person from list provided is born in the month of " + Month.of(month)
                        : "Persons that are born in " + Month.of(month) + " ordered alphabetically:"
        ).findFirst().orElse("");

        personsBornInSameMonth.addFirst(firstLine);

        personsBornInSameMonth.forEach(System.out::println);

        writePersonsToFile(fileToWrite, personsBornInSameMonth);
    }

    public List<String> findAndReturnPersonsBornInSpecificMonth(List<String> csvToRead, int month) throws IOException {
        readAndParsePersonsFromCsvFile(csvToRead);

        List<String> personsBornInSameMonth =
                persons
                        .stream()
                        .filter(person -> person.getDateOfBirth().getMonth().getValue() == month)
                        .sorted(PERSON_COMPARATOR)
                        .map(Person::toString)
                        .collect(Collectors.toList());

        String firstLine = Stream.of(
                personsBornInSameMonth.isEmpty()
                        ? "No person from list provided is born in the month of " + Month.of(month)
                        : "Persons that are born in " + Month.of(month) + " ordered alphabetically:"
        ).findFirst().orElse("");

        personsBornInSameMonth.addFirst(firstLine);

        personsBornInSameMonth.forEach(System.out::println);

        return personsBornInSameMonth;
    }

    private void readAndParsePersonsFromCsvFile(String csvToRead) throws IOException {
        String csvDelimiter = ",";
        Path file = Paths.get(csvToRead);

        persons = Files.readAllLines(file)
                .stream()
                .skip(1)
                .map(line -> {
                    String[] personData = line.split(csvDelimiter);

                    String personFirstName = personData[1];
                    String personLastName = personData[2];

                    int personBirthYear = Integer.parseInt(personData[3]);
                    int personBirthMonth = Integer.parseInt(personData[4]);
                    int personBirthDay = Integer.parseInt(personData[5]);
                    LocalDate personBirthDate = LocalDate.of(personBirthYear, personBirthMonth, personBirthDay);

                    return new Person(personFirstName, personLastName, personBirthDate);
                })
                .collect(Collectors.toList());

        if (persons.isEmpty()) {
            throw new IOException("CSV file doesn't contain any person!");
        }
    }

    private void readAndParsePersonsFromCsvFile(List<String> csvToRead) throws IOException {
        String csvDelimiter = ",";

        persons = csvToRead
                .stream()
                .skip(1)
                .map(line -> {
                    String[] personData = line.split(csvDelimiter);

                    String personFirstName = personData[1];
                    String personLastName = personData[2];

                    int personBirthYear = Integer.parseInt(personData[3]);
                    int personBirthMonth = Integer.parseInt(personData[4]);
                    int personBirthDay = Integer.parseInt(personData[5]);
                    LocalDate personBirthDate = LocalDate.of(personBirthYear, personBirthMonth, personBirthDay);

                    return new Person(personFirstName, personLastName, personBirthDate);
                })
                .collect(Collectors.toList());

        if (persons.isEmpty()) {
            throw new IOException("CSV file doesn't contain any person!");
        }
    }

    private void writePersonsToFile(String fileToWrite, List<String> personsBornInSameMonth) throws IOException {
        Path file = Paths.get(fileToWrite);
        Files.write(file, personsBornInSameMonth);
        System.out.println("Lines written to file: " + file.toAbsolutePath());
    }
}
