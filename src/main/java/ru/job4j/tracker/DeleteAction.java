package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int deleteId = input.askInt("Введите номер удаляемой заявки: ");
        if (tracker.delete(deleteId)) {
            out.println("Delete success");
        } else {
            out.println("Delete error");
        }
        return true;
    }
}
