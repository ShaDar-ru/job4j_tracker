package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> tasks = List.of(
                new Task("1", "First desk"),
                new Task("2", "Second desk"),
                new Task("1", "First desk")
        );
        Set<String> expected = new HashSet(List.of("1", "2"));
        assertThat(FullSearch.extrectNumber(tasks), is(expected));
    }

}