package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int deleteId = input.askInt("Введите номер удаляемой заявки: ");
        if (tracker.delete(deleteId)) {
            System.out.println("Delete success");
        } else {
            System.out.println("Delete error");
        }
        return true;
    }
}
