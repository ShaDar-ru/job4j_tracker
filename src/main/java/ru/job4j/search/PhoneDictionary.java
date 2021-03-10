package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person p : persons) {
            if (p.getName().equals(key)
                    || p.getPhone().equals(key)
                    || p.getAddress().equals(key)
                    || p.getSurname().equals(key)) {
                result.add(p);
            }
        }
        return result;
    }

}