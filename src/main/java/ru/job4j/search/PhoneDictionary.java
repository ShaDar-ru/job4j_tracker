package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> haveName = (p) -> p.getName().contains(key);
        Predicate<Person> havePhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> haveAddress = (p) -> p.getAddress().contains(key);
        Predicate<Person> haveSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> combine = haveName.or(havePhone).or(haveAddress).or(haveSurname);
        var result = new ArrayList<Person>();
        for (var p : persons) {
            if (combine.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

}