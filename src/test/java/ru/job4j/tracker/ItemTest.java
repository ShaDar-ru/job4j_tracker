package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.comparators.*;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void compareById() {
        Item a = new Item(12, "Item1");
        Item b = new Item(22, "Item2");
        List<Item> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Comparator<Item> comp = new ItemSortComparator.ItemSortById();
        Collections.sort(list, comp);
        assertThat(list.get(0), is(a));
    }

    @Test
    public void revertCompareById() {
        Item a = new Item(12, "Item1");
        Item b = new Item(22, "Item2");
        List<Item> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Comparator<Item> comp = new ItemSortComparator.RevertItemSortById();
        Collections.sort(list, comp);
        assertThat(list.get(0), is(b));
    }

    @Test
    public void compareByName() {
        Item a = new Item(12, "Item1");
        Item b = new Item(22, "Item2");
        List<Item> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Comparator<Item> comp = new ItemSortComparator.ItemSortByName();
        Collections.sort(list, comp);
        assertThat(list.get(0), is(a));
    }

    @Test
    public void revertCompareByName() {
        Item a = new Item(12, "Item1");
        Item b = new Item(22, "Item2");
        List<Item> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        Comparator<Item> comp = new ItemSortComparator.RevertItemSortByName();
        Collections.sort(list, comp);
        assertThat(list.get(0), is(b));
    }
}