package ru.job4j.tracker;

import java.util.Arrays;

public final class Tracker {

    private static Tracker instance = null;

    private final Item[] items = new Item[100];

    private int ids = 1;
    private int size = 0;

    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = this.indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] itemsWithName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[i].getName().equals(key)) {
                itemsWithName[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(itemsWithName, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int a = -1;
        if (this.findById(id) != null) {
            a = this.indexOf(id);
        }
        if (a != -1) {
            item.setId(id);
            items[a] = item;
        }
        return a != -1;
    }

    public boolean delete(int id) {
        int a = -1;
        if (this.findById(id) != null) {
            a = this.indexOf(id);
        }
        if (a != -1) {
            System.arraycopy(
                    items,
                    a + 1,
                    items,
                    a,
                    size - a);
            items[size - 1] = null;
            size--;
        }
        return a != -1;
    }
}