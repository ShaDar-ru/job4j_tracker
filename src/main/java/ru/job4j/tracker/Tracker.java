package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public final class Tracker {

    private static Tracker instance = null;

    private final List<Item> items = new ArrayList<>();

    private int ids = 1;

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = this.indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> itemsWithName = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                itemsWithName.add(item);
            }
        }
        return itemsWithName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int a = this.indexOf(id);
        if (a != -1) {
            item.setId(id);
            items.set(a, item);
        }
        return a != -1;
    }

    public boolean delete(int id) {
        int a = this.indexOf(id);
        if (a != -1) {
            items.remove(a);
        }
        return a != -1;
    }
}