package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShowAllActionTest {
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
        String[] answers = {
                "Тест добавления итема.1",
                "Тест добавления итема.2",
                "Тест добавления итема.3"
        };
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        CreateAction create = new CreateAction(out);
        create.execute(input, tracker);
        create.execute(input, tracker);
        create.execute(input, tracker);
        List<Item> items = tracker.findAll();
        for (int i = 0; i < items.size(); i++) {
            assertThat(items.get(i).getName(), is("Тест добавления итема." + (i + 1)));
        }
    }
}