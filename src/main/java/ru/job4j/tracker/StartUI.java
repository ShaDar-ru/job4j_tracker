package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            String str = input.askStr("Выберите действие: ");
            int select = Integer.valueOf(str);
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.showAllItems(tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemById(input, tracker);
                    break;
                case 5:
                    StartUI.findItemByName(input, tracker);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String nameNewItem = input.askStr("Введите имя новой заявки: ");
        Item newItem = new Item(nameNewItem);
        tracker.add(newItem);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allItems = tracker.findAll();
        for (int i = 0; i < allItems.length; i++) {
            System.out.println(allItems[i].toString());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String changedId = input.askStr("Введите номер изменяемой заявки: ");
        int replaceId = Integer.valueOf(changedId);
        String nameRepItem = input.askStr("Введите имя новой заявки: ");
        Item replacedItem = new Item(nameRepItem);
        if (tracker.replace(replaceId, replacedItem)) {
            System.out.println("Replace success");
        } else {
            System.out.println("Replace error");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String searchIdStrDel = input.askStr("Введите номер удаляемой заявки: ");
        int deleteId = Integer.valueOf(searchIdStrDel);
        if (tracker.delete(deleteId)) {
            System.out.println("Delete success");
        } else {
            System.out.println("Delete error");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        String searchIdStr = input.askStr("Введите номер искомой заявки: ");
        int searchId = Integer.valueOf(searchIdStr);
        Item searchedItemById = tracker.findById(searchId);
        if (searchedItemById != null) {
            System.out.println(searchedItemById.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Name ====");
        String searchName = input.askStr("Введите имя искомой заявки: ");
        Item[] searchedItemsByName = tracker.findByName(searchName);
        if (searchedItemsByName.length > 0) {
            for (Item it : searchedItemsByName) {
                System.out.println(it.toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println(
                "0. Add new Item" + System.lineSeparator() +
                        "1. Show all items" + System.lineSeparator() +
                        "2. Edit item" + System.lineSeparator() +
                        "3. Delete item" + System.lineSeparator() +
                        "4. Find item by Id" + System.lineSeparator() +
                        "5. Find items by Name" + System.lineSeparator() +
                        "6. Exit Program"
        );
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
