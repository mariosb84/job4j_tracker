package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete Item ====");
        int id = Integer.valueOf(input.askStr("Enter id for delete : "));
        if (tracker.delete(id)) {
            out.println("Deleted correctly");
        } else {
            out.println("Deleted incorrectly");
        }
        return true;
    }
}