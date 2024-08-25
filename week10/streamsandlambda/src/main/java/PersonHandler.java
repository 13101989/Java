package main.java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonHandler {
    private List<Person> persons = new ArrayList<>();

    public void findAndWriteToFilePersonsBornInSpecificMonth(String csvToRead, int month, String fileToWrite) throws IOException {
        readAndParsePersonsFromCsvFile(csvToRead);

//        List<String> personsBornInSameMonth = new ArrayList<>();
//        for (Person person : persons) {
//            if (person.getDateOfBirth().getMonth().getValue() == month) {
//                personsBornInSameMonth.add(person.toString());
//            }
//        }
//        personsBornInSameMonth.sort(null);

        List<String> personsBornInSameMonth =
                persons.stream()
                        .filter(person -> person.getDateOfBirth().getMonth().getValue() == month)
                        .map(Person::toString)
                        .sorted()
                        .collect(Collectors.toList());

        if (!personsBornInSameMonth.isEmpty()) {
            System.out.println("Persons that are born in " + Month.of(month) + " ordered alphabetically:");
            for (String person : personsBornInSameMonth) {
                System.out.println(person);
            }
            String firstLine = "Persons that are born in " + Month.of(month) + " ordered alphabetically:";
            personsBornInSameMonth.add(0, firstLine);
        } else {
            String firstLine = "No person from list provided is born in the month of " + Month.of(month);
            System.out.println(firstLine);
            personsBornInSameMonth.add(firstLine);
        }

        writePersonsToFile(fileToWrite, personsBornInSameMonth);
    }

    private void readAndParsePersonsFromCsvFile(String csvToRead) throws IOException {
        String csvDelimiter = ",";
        Path file = Paths.get(csvToRead);

//        List<String> lines = Files.readAllLines(file);
//        lines.remove(0);
//
//        if (lines.isEmpty()) {
//            throw new IOException("CSV file doesn't contain any person!");
//        }
//
//        for (String line : lines) {
//            String[] personData = line.split(csvDelimiter);
//
//            String personFirstName = personData[1];
//            String personLastName = personData[2];
//
//            int personBirthYear = Integer.parseInt(personData[3]);
//            int personBirthMonth = Integer.parseInt(personData[4]);
//            int personBirthDay = Integer.parseInt(personData[5]);
//            LocalDate personBirthDate = LocalDate.of(personBirthYear, personBirthMonth, personBirthDay);
//
//            Person person = new Person(personFirstName, personLastName, personBirthDate);
//            persons.add(person);
//        }

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

    private void writePersonsToFile(String fileToWrite, List<String> personsBornInSameMonth) throws IOException {
        Path file = Paths.get(fileToWrite);
        Files.write(file, personsBornInSameMonth);
        System.out.println("Lines written to file: " + file.toAbsolutePath());
    }
}
