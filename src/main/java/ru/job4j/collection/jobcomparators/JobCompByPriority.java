package ru.job4j.collection.jobcomparators;

import ru.job4j.collection.Job;

import java.util.Comparator;

public class JobCompByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
