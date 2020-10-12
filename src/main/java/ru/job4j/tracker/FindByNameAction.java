package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find items by name.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find Item by name ====");
        String name = input.askStr("Enter name to find : ");
       // Item[] items = tracker.findByName(name);                                                      replace to List
        List<Item> items = tracker.findByName(name);
       // if ((items.length > 0)) {                                                                     replace to List
            if ((items.size() > 0)) {
            for (Item item1 : items) {
                out.println(item1);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}