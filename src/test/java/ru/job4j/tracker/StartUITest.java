package ru.job4j.tracker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final String nl = System.lineSeparator();

    @Before
    public void clear() {
        Tracker tracker = Tracker.getInstance();
        ArrayList<Item> all = (ArrayList<Item>) tracker.findAll();
        for (Item it : all) {
            tracker.delete(it.getId());
        }
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = Tracker.getInstance();

        Item item = tracker.add(new Item("Replaced item"));

        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = Tracker.getInstance();

        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /*
        assertThat(tracker.findById(item.getId()), is(nullValue()));

        Menu.
        0. Delete Item
        1. Exit
        Delete success
        Menu.
        0. Delete Item
        1. Exit
        */
    @Test
    public void whenDeleted() {
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("It will be deleted"));
        Input in = new StubInput(new String[]{"0", Integer.toString(item.getId()), "1"});
        Output out = new StubOutput();
        UserAction[] usAct = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + nl
                        + "0. Delete Item" + nl
                        + "1. Exit" + nl
                        + "Delete success" + nl
                        + "Menu." + nl
                        + "0. Delete Item" + nl
                        + "1. Exit" + nl
        ));
    }

    /*
        Menu.
        0. Show all items
        1. Exit
        Item { id = 1, name = 'Find me!', created = 30-января-суббота-2021 23:56:08}
        Item { id = 2, name = 'And me too!', created = 30-января-суббота-2021 23:56:08}
        Menu.
        0. Show all items
        1. Exit
     */
    @Test
    public void whenShowAll() {
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Find me!"));
        Item item2 = tracker.add(new Item("And me too!"));
        UserAction[] usAct = {
                new ShowAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + nl
                        + "0. Show all items" + nl
                        + "1. Exit" + nl
                        + tracker.findById(item.getId()) + nl
                        + tracker.findById(item2.getId()) + nl
                        + "Menu." + nl
                        + "0. Show all items" + nl
                        + "1. Exit" + nl
        ));
    }

    /*
        assertThat(tracker.findById(1).getName(), is("Find me!"));

        Menu.
        0. Find Item by Id
        1. Exit
        Item { id = 1, name = 'Find me!', created = 30-января-суббота-2021 23:47:23}
        Menu.
        0. Find Item by Id
        1. Exit
     */
    @Test
    public void whenFindById() {

        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Find me!"));
        Input in = new StubInput(
                new String[]{"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] usAct = {
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + nl
                        + "0. Find Item by Id" + nl
                        + "1. Exit" + nl
                        + tracker.findById(item.getId()) + nl
                        + "Menu." + nl
                        + "0. Find Item by Id" + nl
                        + "1. Exit" + nl
        ));
    }

    /*
        assertThat(tracker.findById(1).getName(), is("Find me!"));

        Menu.
        0. Find Item by Name
        1. Exit
        Item { id = 1, name = 'Find me!', created = 30-января-суббота-2021 23:47:23}
        Menu.
        0. Find Item by Name
        1. Exit
     */
    @Test
    public void whenFindByName() {
        Input in = new StubInput(
                new String[]{"0", "Find me!", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        Item item = tracker.add(new Item("Find me!"));
        UserAction[] usAct = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + nl
                        + "0. Find Item by Name" + nl
                        + "1. Exit" + nl
                        + tracker.findById(item.getId()) + nl
                        + "Menu." + nl
                        + "0. Find Item by Name" + nl
                        + "1. Exit" + nl
        ));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + nl
                        + "0. Exit" + nl
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        StubInput inStb = new StubInput(
                new String[]{"-2", "0"}
        );
        Input in = new ValidateInput(out, inStb);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        System.out.println(out.toString());
        assertThat(out.toString(), is(
                String.format(
                        "Menu." + nl
                                + "0. Exit" + nl
                                + "Wrong input, you can select: 0 .. 0" + nl
                                + "Menu." + nl
                                + "0. Exit" + nl
                )
        ));
    }
}