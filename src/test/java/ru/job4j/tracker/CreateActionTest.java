package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CreateActionTest {
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
        String[] answers = {"Тест добавления итема."};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        CreateAction create = new CreateAction(out);
        create.execute(input, tracker);
        assertThat(tracker.findAll().get(0).getName(), is("Тест добавления итема."));
    }
}