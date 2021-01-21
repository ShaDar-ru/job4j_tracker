package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
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
        int a = indexOf(id);
        if (a == -1) {
            return false;
        }
        item.setId(id);
        items[a] = item;
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(
                items,
                index + 1,
                items,
                size - 1,
                size - index);
        items[size-1]=null;
        size--;
        return true;
    }

    public static void print(Item[] items){
        for(Item item : items){
            System.out.println(item.getId()+" "+item.getName());
        }
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        print(tracker.items);
        Item bug2 = new Item();
        bug2.setName("Bugged bug");
        tracker.add(bug2);
        print(tracker.items);
        int id = bug.getId();
        tracker.delete(id);
        id = bug2.getId();
        print(tracker.items);
    }
}