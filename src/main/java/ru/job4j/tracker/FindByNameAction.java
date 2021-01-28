package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item by Name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String searchName = input.askStr("Введите имя искомой заявки: ");
        Item[] searchedItemsByName = tracker.findByName(searchName);
        if (searchedItemsByName.length > 0) {
            for (Item it : searchedItemsByName) {
                System.out.println(it.toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
