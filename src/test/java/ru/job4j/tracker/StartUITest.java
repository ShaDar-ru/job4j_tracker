package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void init() {
    }

    @Test
    public void whenCreateItem() {
        String[] answers = {"Fix PC", "bug1", "bug2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < answers.length; i++) {
            StartUI.createItem(input, tracker);
            Item created = tracker.findAll()[i];
            Item expected = new Item(answers[i]);
            assertThat(created.getName(), is(expected.getName()));
        }
    }

    @Test
    public void showAllItems() {
        String[] answers = {"bug", "fix", "bug2", "fix"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        Item[] expected = new Item[answers.length];
        for (int i = 0; i < answers.length; i++) {
            StartUI.createItem(input, tracker);
            Item exp = new Item(i + 1, answers[i]);
            expected[i] = exp;
        }
        Item[] created = tracker.findAll();
        for (int i = 0; i < answers.length; i++) {
            assertThat(created[i].toString(), is(expected[i].toString()));
        }
    }

    @Test
    public void replaceItem() {
        String[] questions = {"bug", "bug1", "bug2"};
        Input input = new StubInput(questions);
        Tracker tracker = new Tracker();
        for (int i = 0; i < questions.length; i++) {
            StartUI.createItem(input, tracker);
        }
        Item[] expected = tracker.findAll();
        expected[1] = new Item(2, "fix");
        String[] answrs = {"2", "fix"};
        Input answ = new StubInput(answrs);
        StartUI.replaceItem(answ, tracker);
        Item[] created = tracker.findAll();
        for (int i = 0; i < questions.length; i++) {
            assertThat(created[i].getName(), is(expected[i].getName()));
        }
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void deleteItem2() {
        String[] answers = {"bug", "bug2", "bug3"};
        Input inp = new StubInput(answers);
        Tracker tracker = new Tracker();
        for (int i = 0; i < answers.length; i++) {
            StartUI.createItem(inp, tracker);
        }
        Input delInp = new StubInput(new String[]{"2"});
        StartUI.deleteItem(delInp, tracker);
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < tracker.findAll().length; i++) {
            Item exp = new Item(i + 1, answers[i]);
            if (exp.getId() != 2) {
                assertThat(rsl[i].getName(), is(exp.getName()));
            }
        }
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Элемент, который будет удален");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item[] items = tracker.findAll();
        for (Item it:items) {
            assertThat(it, is(nullValue()));
        }
    }

    @Test
    public void findItemById() {
    }

    @Test
    public void findItemByName() {
    }
}