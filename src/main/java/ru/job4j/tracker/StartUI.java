package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
             if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name : ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
                          }  else if (select == 1) {
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter new name : ");
                String name = scanner.nextLine();
                System.out.print("Enter id for new name : ");
                int id = Integer.valueOf(scanner.nextLine());
                Item input = new Item();
                input.setName(name);
                 if (tracker.replace(id,input)) {
                     System.out.println("Replaced correctly");
                 } else {
                     System.out.println("Replaced incorrectly");
                 }
             } else if (select == 3) {
                 System.out.println("=== Delete Item ====");
                 System.out.print("Enter id for delete : ");
                 int id = Integer.valueOf(scanner.nextLine());
                 if (tracker.delete(id)) {
                     System.out.println("Deleted correctly");
                 } else {
                     System.out.println("Deleted incorrectly");
                 }

             } else if (select == 4) {
                 System.out.println("=== Find Item by id ====");
                 System.out.print("Enter id to find : ");
                 int id = Integer.valueOf(scanner.nextLine());
                 Item item = tracker.findById(id);
                 if (item != null) {
                     System.out.println(item);
                 } else {
                     System.out.println("Заявки с таким id не найдены");
                 }
             } else if (select == 5) {
                 System.out.println("=== Find Item by name ====");
                 System.out.print("Enter name to find : ");
                 String name = scanner.nextLine();
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
             }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);



    }
}
