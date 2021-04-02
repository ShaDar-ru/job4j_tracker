package ru.job4j.tracker.comparators;

import ru.job4j.tracker.Item;

import java.util.Comparator;

/**
 * @author Alex Terentev (ShaDar-ru)
 * @version 1.0
 * @date 02.04.2021
 */
public abstract class ItemSortComparator implements Comparator<Item> {

    public abstract int compare(Item o1, Item o2);

    public static class ItemSortById extends ItemSortComparator {
        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }

    public static class ItemSortByName extends ItemSortComparator {
        @Override
        public int compare(Item o1, Item o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    public static class RevertItemSortById extends ItemSortComparator {
        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o2.getId(), o1.getId());
        }
    }

    public static class RevertItemSortByName extends ItemSortComparator {
        @Override
        public int compare(Item o1, Item o2) {
            return o2.getName().compareTo(o1.getName());
        }
    }
}