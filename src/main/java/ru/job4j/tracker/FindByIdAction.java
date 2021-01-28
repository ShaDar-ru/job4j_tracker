package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "=== Find Item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int searchId = input.askInt("Введите номер искомой заявки: ");
        Item searchedItemById = tracker.findById(searchId);
        if (searchedItemById != null) {
            System.out.println(searchedItemById.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
