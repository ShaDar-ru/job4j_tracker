package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Replaced item"));

        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", "1", replacedName, "1"}
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
        Tracker tracker = new Tracker();

        Item item = tracker.add(new Item("Deleted item"));

        Input in = new StubInput(
                new String[]{"0", "1", "1"}
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
    public void wheDeleted() {
        Input in = new StubInput(new String[]{"0", "1", "1"});
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("It will be deleted"));
        UserAction[] usAct = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Delete Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        "Delete success" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Delete Item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find me!"));
        Item item2 = tracker.add(new Item("And me too!"));
        UserAction[] usAct = {
                new ShowAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        tracker.findById(item2.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Show all items" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
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
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find me!"));
        UserAction[] usAct = {
                new FindByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find Item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find Item by Id" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
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
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Find me!"));
        UserAction[] usAct = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, usAct);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Find Item by Name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        tracker.findById(item.getId()) + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. Find Item by Name" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator()
        ));
    }


    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] { "-2", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        System.out.println(out.toString());
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
        ));
    }
}