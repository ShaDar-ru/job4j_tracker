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
        boolean rsl = a != -1;
        if (rsl) {
            item.setId(id);
            items[a] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(
                    items,
                    index + 1,
                    items,
                    index,
                    size - index);
            items[size - 1] = null;
            size--;
        }
        return index != -1;
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        Item bug2 = new Item();
        bug2.setName("Bugged bug");
        tracker.add(bug2);
        int id = bug.getId();
        int id2 = bug2.getId();
        //print(tracker.items);
        for (int i = 0; i < tracker.size; i++) {
            System.out.println(tracker.items[i].getId() + " " + tracker.items[i].getName());
        }
        System.out.println();
        tracker.add(bug);
        tracker.add(bug);
        tracker.add(bug);

        for (int i = 0; i < tracker.size; i++) {
            System.out.println(tracker.items[i].getId() + " " + tracker.items[i].getName());
        }
        /*
        System.out.println();
        tracker.delete(id);
        for(int i=0;i< tracker.size;i++){
            System.out.println(tracker.items[i].getId()+" "+tracker.items[i].getName());
        }
        System.out.println();
        tracker.delete(id2);
        for(int i=0;i< tracker.size;i++){
            System.out.println(tracker.items[i].getId()+" "+tracker.items[i].getName());
        }*/
    }
}