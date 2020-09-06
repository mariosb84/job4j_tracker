package ru.job4j.tracker;


public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

   /* public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));*/
   public void init(Input input, Tracker tracker, UserAction[] actions) {
       boolean run = true;
       while (run) {
           this.showMenu(actions);
           int select = input.askInt("Select: ");
           if (select < 0 || select >= actions.length) {
               out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
               continue;
           }
           UserAction action = actions[select];
           run = action.execute(input, tracker);

             /*if (select == 0) {
                 StartUI.createItem(input, tracker);

                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name : ");
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                          }  else if (select == 1) {
                 StartUI.showAllItems(tracker);
            } else if (select == 2) {
                 StartUI.editItem(input, tracker);

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
             } else if (select == 3) {
                 StartUI.deleteItem(input, tracker);

                 System.out.println("=== Delete Item ====");
                 int id = Integer.valueOf(input.askStr("Enter id for delete : "));
                 if (tracker.delete(id)) {
                     System.out.println("Deleted correctly");
                 } else {
                     System.out.println("Deleted incorrectly");
                 }

             } else if (select == 4) {
                 StartUI.findByIdItem(input, tracker);

                 System.out.println("=== Find Item by id ====");
                 int id = Integer.valueOf(input.askStr("Enter id to find : "));
                 Item item = tracker.findById(id);
                 if (item != null) {
                     System.out.println(item);
                 } else {
                     System.out.println("Заявки с таким id не найдены");
                 }
             } else if (select == 5) {
                 StartUI.findByNameItem(input, tracker);

                 System.out.println("=== Find Item by name ====");
                 String name = input.askStr("Enter name to find : ");
                 Item[] items = tracker.findByName(name);
                 if ((items.length > 0)) {
                     System.out.println(Arrays.toString(tracker.findByName(name)));
                 } else {
                     System.out.println("Заявки с таким именем не найдены");
                 }
             } else if (select == 6) {
                 System.out.println("=== Exit menu ====");
                run = false;
            } else {
                 System.out.println("Select from 0 to 6 !!!");
             }*/
        }
    }

    /*private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }*/
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + "." + actions[index].name());
        }
    }
    /*public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }*/
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new AddAction(output),new ShowAllAction(output),new EditAction(output),
                new DeleteAction(output),new FindByIdAction(output),new FindByNameAction(output),
                new ExitAction(output)
                //new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }
    public static void showAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] item = tracker.findAll();
            for (Item item1 : item) {
                System.out.println(item1);
            }
        //System.out.println(Arrays.toString(tracker.findAll()));
    }
    public static void editItem(Input input, Tracker tracker) {
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
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        int id = Integer.valueOf(input.askStr("Enter id for delete : "));
        if (tracker.delete(id)) {
            System.out.println("Deleted correctly");
        } else {
            System.out.println("Deleted incorrectly");
        }
    }
    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id ====");
        int id = Integer.valueOf(input.askStr("Enter id to find : "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявки с таким id не найдены");
        }
    }
    public static void findByNameItem(Input input, Tracker tracker) {
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
    }

}
