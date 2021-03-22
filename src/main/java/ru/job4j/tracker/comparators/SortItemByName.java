package ru.job4j.tracker.comparators;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortItemByName implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
