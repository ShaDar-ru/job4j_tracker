package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    @Test
    public void whenCollectClassA() {
        Student a = new Student(30, "Surname1");
        Student b = new Student(40, "Surname2");
        Student c = new Student(50, "Surname3");
        Student d = new Student(60, "Surname4");
        Student e = new Student(70, "Surname5");
        List<Student> students = List.of(a, b, c, d, e);
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 70;
        Map<String, Student> result = sc.collect(students, pr);
        Map<String, Student> expect = new HashMap<>();
        expect.put(e.getSurname(), e);
        assertThat(result, is(expect));
    }

    @Test
    public void whenCollectClassB() {
        Student a = new Student(30, "Surname1");
        Student b = new Student(40, "Surname2");
        Student c = new Student(50, "Surname3");
        Student d = new Student(60, "Surname4");
        Student e = new Student(70, "Surname5");
        List<Student> students = List.of(a, b, c, d, e);
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 70 && student.getScore() >= 50;
        Map<String, Student> result = sc.collect(students, pr);
        Map<String, Student> expect = new HashMap<>();
        expect.put(c.getSurname(), c);
        expect.put(d.getSurname(), d);
        assertThat(result, is(expect));
    }

    @Test
    public void whenCollectClassV() {
        Student a = new Student(30, "Surname1");
        Student b = new Student(40, "Surname2");
        Student c = new Student(50, "Surname3");
        Student d = new Student(60, "Surname4");
        Student e = new Student(70, "Surname5");
        List<Student> students = List.of(a, a, b, c, d, e);
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 50;
        Map<String, Student> result = sc.collect(students, pr);
        Map<String, Student> expect = new HashMap<>();
        expect.put(a.getSurname(), a);
        expect.put(b.getSurname(), b);
        assertThat(result, is(expect));
    }
}