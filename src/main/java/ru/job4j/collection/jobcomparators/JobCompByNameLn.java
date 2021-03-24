package ru.job4j.collection.jobcomparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobCompByNameLn implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getName().length(), o2.getName().length());
    }
}
