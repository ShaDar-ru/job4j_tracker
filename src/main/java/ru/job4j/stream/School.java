package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    public Map<String, Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toMap(
                        e -> e.getSurname(),
                        e -> e,
                        (a, b) -> a.equals(b) ? a : b
                ));
    }
}
