package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = Integer.valueOf(input.askStr("Enter id for delete : "));
        if (tracker.delete(id)) {
            System.out.println("Deleted correctly");
        } else {
            System.out.println("Deleted incorrectly");
        }
        return true;
    }
}