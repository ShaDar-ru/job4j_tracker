package ru.job4j.tracker;

public class ShowAllAction implements UserAction{
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allItems = tracker.findAll();
        for (int i = 0; i < allItems.length; i++) {
            System.out.println(allItems[i].toString());
        }
        return true;
    }
}
