package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ShowAllActionTest {

    @Test
    public void execute() {
        String[] answers = {"Тест добавления итема.1", "Тест добавления итема.2", "Тест добавления итема.3" };
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        CreateAction create = new CreateAction();
        create.execute(input, tracker);
        create.execute(input, tracker);
        create.execute(input, tracker);
        Item[] items = tracker.findAll();
        for (int i = 0; i<items.length;i++){
            assertThat(items[i].getName(),is("Тест добавления итема."+(i+1)));
        }
    }
}