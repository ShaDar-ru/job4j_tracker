package ru.job4j.tracker;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class DeleteActionTest {

    @Test
    public void execute() {
        Output out = new ConsoleOutput();
        String[] answers = {"Тест удаления итема.", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        CreateAction create = new CreateAction(out);
        create.execute(input, tracker);
        DeleteAction delete = new DeleteAction(out);
        delete.execute(input, tracker);
        Item[] items = tracker.findAll();
        for (Item it:items) {
            assertThat(it, is(nullValue()));
        }
    }
}