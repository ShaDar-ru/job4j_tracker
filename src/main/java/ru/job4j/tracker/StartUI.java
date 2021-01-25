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
                    System.out.println("=== Create a new Item ====");
                    String nameNewItem = input.askStr("Введите имя новой заявки: ");
                    Item newItem = new Item(nameNewItem);
                    tracker.add(newItem);
                    break;
                case 1:
                    System.out.println("=== Show all items ====");
                    Item[] allItems = tracker.findAll();
                    for (int i = 0; i < allItems.length; i++) {
                        System.out.println(allItems[i].toString());
                    }
                    break;
                case 2:
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
                    break;
                case 3:
                    System.out.println("=== Delete Item ====");
                    String searchIdStrDel = input.askStr("Введите номер удаляемой заявки: ");
                    int deleteId = Integer.valueOf(searchIdStrDel);
                    if (tracker.delete(deleteId)) {
                        System.out.println("Delete success");
                    } else {
                        System.out.println("Delete error");
                    }
                    break;
                case 4:
                    System.out.println("=== Find Item by Id ====");
                    String searchIdStr = input.askStr("Введите номер искомой заявки: ");
                    int searchId = Integer.valueOf(searchIdStr);
                    Item searchedItemById = tracker.findById(searchId);
                    if (searchedItemById != null) {
                        System.out.println(searchedItemById.toString());
                    } else {
                        System.out.println("Заявка с таким id не найдена");
                    }
                    break;
                case 5:
                    System.out.println("=== Find Item by Name ====");
                    String searchName = input.askStr("Введите имя искомой заявки: ");
                    Item[] searchedItemsByName = tracker.findByName(searchName);
                    if (searchedItemsByName.length>0) {
                        for (Item it : searchedItemsByName) {
                            System.out.println(it.toString());
                        }
                    } else {
                        System.out.println("Заявки с таким именем не найдены");
                    }
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    break;
            }
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
