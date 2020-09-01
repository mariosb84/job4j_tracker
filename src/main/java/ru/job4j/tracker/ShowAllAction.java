package ru.job4j.tracker;

public class
ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
        Item[] item = tracker.findAll();
        if (item.length > 0) {
            for (Item item1 : item) {
                out.println(item1);
            }
        } else {
            out.println("The request array is empty");
        }
        return true;
    }
}