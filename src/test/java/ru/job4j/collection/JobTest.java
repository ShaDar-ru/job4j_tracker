package ru.job4j.collection;

import org.junit.Test;
import ru.job4j.collection.jobcomparators.JobCompByName;
import ru.job4j.collection.jobcomparators.JobCompByPriority;
import ru.job4j.collection.jobcomparators.JobDescByName;
import ru.job4j.collection.jobcomparators.JobDescByPriority;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobCompByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("One", 0),
                new Job("One", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompByNameAndDescPriorityThenOneLess() {
        Comparator<Job> cmpNameDescPriority = new JobCompByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameDescPriority.compare(
                new Job("One1", 1),
                new Job("One2", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompByNameAndDescPriorityThenTwoLess() {
        Comparator<Job> cmpNameDescPriority = new JobCompByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameDescPriority.compare(
                new Job("One", 1),
                new Job("One", 2)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenDescByNameAndCompPriority() {
        Comparator<Job> cmpNameDescPriority = new JobCompByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNameDescPriority.compare(
                new Job("One1", 1),
                new Job("One2", 2)
        );
        assertThat(rsl, lessThan(0));
    }
}