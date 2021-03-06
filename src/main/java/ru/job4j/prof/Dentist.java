package ru.job4j.prof;

import java.util.Date;

public class Dentist extends Doctor {
    private int salary;
    private String[] timetable;

    public Dentist(String name,
                   String education,
                   int patients,
                   String speciality,
                   int salary,
                   String[] timetable
    ) {
        super(name, education, patients, speciality);
        this.salary = salary;
        this.timetable = timetable;
    }

    public int getSalary() {
        return salary;
    }

    public String[] getTimetable() {
        return timetable;
    }
}
