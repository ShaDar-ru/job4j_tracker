package ru.job4j.tracker;

public class FindByNameAction implements UserAction{
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find Item by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String searchName = input.askStr("Введите имя искомой заявки: ");
        Item[] searchedItemsByName = tracker.findByName(searchName);
        if (searchedItemsByName.length > 0) {
            for (Item it : searchedItemsByName) {
                out.println(it.toString());
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
