package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String timecreate = item.getCreated().format(formatter);
        System.out.println(timecreate);

        Tracker tracker = new Tracker();
        tracker.add(item);

        System.out.println(tracker.findById(item.getId()));
        //Для проверки:
        System.out.println(tracker.findById(item.getId()).getId());
    }
}
