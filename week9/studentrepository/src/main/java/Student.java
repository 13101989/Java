package main.java;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Data
public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Map<String, Integer> calculateAge() {
        Map<String, Integer> ageMap = new HashMap<>();

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);
        ageMap.put("years", age.getYears());
        ageMap.put("months", age.getMonths());
        ageMap.put("days", age.getDays());
        return ageMap;
    }
}
