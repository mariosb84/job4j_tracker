package ru.job4j.tracker;

public class
ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] item = tracker.findAll();
        if (item.length > 0) {
            for (Item item1 : item) {
                System.out.println(item1);
            }
        } else {
            System.out.println("The request array is empty");
        }
        return true;
    }
}