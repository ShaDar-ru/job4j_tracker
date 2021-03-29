package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class DeleteActionTest {
    @Before
    public void clear() {
        Tracker tracker = Tracker.getInstance();
        ArrayList<Item> all = (ArrayList<Item>) tracker.findAll();
        for (Item it : all) {
            tracker.delete(it.getId());
        }
    }

    @Test
    public void execute() {
        Output out = new ConsoleOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Deleted item"));
        String[] answers = {Integer.toString(item.getId())};
        Input input = new StubInput(answers);
        DeleteAction delete = new DeleteAction(out);
        delete.execute(input, tracker);
        ArrayList<Item> items = (ArrayList<Item>) tracker.findAll();
        for (Item it : items) {
            assertThat(it, is(nullValue()));
        }
    }
}