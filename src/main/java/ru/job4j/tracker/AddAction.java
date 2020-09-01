package ru.job4j.tracker;

public class AddAction implements UserAction {
    private final Output out;

    public AddAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Add new Item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
        return true;
    }
}