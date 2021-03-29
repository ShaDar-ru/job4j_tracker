package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setGroup("2026Z");
        vasya.setName("Vasya");
        vasya.setSurname("Vasiliev");
        vasya.setPatronymic("Vasilievich");
        vasya.setDate(new Date());

        vasya.getInfo();
        System.out.println();
        //идентично
        System.out.println(vasya.getFio() + System.lineSeparator()
                + vasya.getGroup() + System.lineSeparator()
                + vasya.getDate()
        );
    }
}
