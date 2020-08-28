package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Find Item by name ====");
        String name = input.askStr("Enter name to find : ");
        Item[] items = tracker.findByName(name);
        if ((items.length > 0)) {
            for (Item item1 : items) {
                System.out.println(item1);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}