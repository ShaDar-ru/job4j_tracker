package ru.job4j.map;

import java.util.Map;
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
    public Student findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst()
                .orElse(null);
    }

    /**
     * Поиск по аккаунту и имени предемета.
     * При отустсвии в базе возвращает null
     *
     * @param account аккунт по которому ведется поиск
     * @param name    имя предмета
     * @return Subject or null
     */
    public Subject findBySubjectName(String account, String name) {
        Student st = findByAccount(account);
        if (st != null) {
            return students.get(st)
                    .stream()
                    .filter(s -> s.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        }
        return null;
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
        Student student = college.findByAccount("000001");
        System.out.println("Найденный студент: " + student);
        Subject english = college.findBySubjectName("000001", "English");
        System.out.println("Оценка по найденному предмету: " + english.getScore());
    }
}
