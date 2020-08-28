package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String name = input.askStr("Enter new name : ");
        int id = Integer.valueOf(input.askStr("Enter id for new name : "));
        Item inputEdit = new Item();
        inputEdit.setName(name);
        if (tracker.replace(id,inputEdit)) {
            System.out.println("Replaced correctly");
        } else {
            System.out.println("Replaced incorrectly");
        }
        return true;
    }
}