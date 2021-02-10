package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int replaceId = input.askInt("Введите номер изменяемой заявки: ");
        String nameRepItem = input.askStr("Введите имя новой заявки: ");
        Item replacedItem = new Item(nameRepItem);
        if (tracker.replace(replaceId, replacedItem)) {
            System.out.println("Replace success");
        } else {
            System.out.println("Replace error");
        }
        return true;
    }
}
