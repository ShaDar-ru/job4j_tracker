package ru.job4j.collection;

import ru.job4j.collection.jobcomparators.JobCompByName;
import ru.job4j.collection.jobcomparators.JobCompByNameLn;
import ru.job4j.collection.jobcomparators.JobCompByPriority;
import ru.job4j.collection.jobcomparators.JobDescByPriority;

import java.util.*;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobCompByPriority().thenComparing(new JobCompByName()));
        System.out.println(jobs);
        Collections.sort(jobs, new JobCompByName().thenComparing(new JobCompByPriority()));
        System.out.println(jobs);
        Comparator<Job> comb = new JobCompByNameLn()
                .thenComparing(new JobCompByName())
                .thenComparing(new JobCompByPriority());
        Collections.sort(jobs, comb);
        System.out.println(jobs);
        comb = new JobCompByPriority();
        Collections.sort(jobs, comb);
        System.out.println(jobs);
        Collections.sort(jobs, new JobDescByPriority());
        System.out.println(jobs);
    }
}
