package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    /**
     * Поиск по аккаунту. При отсуствии возвращает null
     *
     * @param account - аккаунт для поиска
     * @return Student or null
     */
    public Optional<Student> findByAccount(String account) {
        return Optional.ofNullable(students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst()
                .orElse(null));
    }

    /**
     * Поиск по аккаунту и имени предемета.
     * При отустсвии в базе возвращает null
     *
     * @param account аккунт по которому ведется поиск
     * @param name    имя предмета
     * @return Subject or null
     */
    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> studOpt = findByAccount(account);
        if (studOpt.isPresent()) {
            return Optional.ofNullable(students.get(studOpt.get())
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null));
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Map<Student, Set<Subject>> students = Map.of(
                new Student("Student", "000001", "201-18-15"),
                Set.of(
                        new Subject("Math", 70),
                        new Subject("English", 85)
                )
        );
        College college = new College(students);
        Optional<Student> studOpt = college.findByAccount("000001");
        studOpt.ifPresent(student -> System.out.println("Найденный студент: " + student));
        Optional<Subject> subjOpt = college.findBySubjectName("000001", "English");
        subjOpt.ifPresent(subj -> System.out.println(
                "Оценка по найденному предмету: " + subjOpt.get().getScore()
            )
        );

    }
}
