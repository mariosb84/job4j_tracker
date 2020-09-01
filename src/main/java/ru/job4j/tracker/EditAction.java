package ru.job4j.tracker;

public class EditAction implements UserAction {
    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit Item ====");
        String name = input.askStr("Enter new name : ");
        int id = Integer.valueOf(input.askStr("Enter id for new name : "));
        Item inputEdit = new Item();
        inputEdit.setName(name);
        if (tracker.replace(id,inputEdit)) {
            out.println("Replaced correctly");
        } else {
            out.println("Replaced incorrectly");
        }
        return true;
    }
}