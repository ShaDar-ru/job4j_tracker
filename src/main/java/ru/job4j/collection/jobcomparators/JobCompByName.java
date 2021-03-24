package ru.job4j.collection.jobcomparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobCompByName implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
