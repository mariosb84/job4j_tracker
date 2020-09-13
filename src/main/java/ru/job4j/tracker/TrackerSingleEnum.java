package ru.job4j.tracker;

import ru.job4j.tracker.Item;
public enum TrackerSingleEnum {
    INSTANCE;// здесь мы указываем перечисления.
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    // Конструкторы и методы.
    public Item add(Item model) {
        this.item = model;
       return this.tracker.add(model);
    }
    public Item findById(Item model) {
        this.item = model;
        return this.tracker.findById(model.getId());
    }

    public static void main(String[] args) {
        TrackerSingleEnum trackerSingleEnum = TrackerSingleEnum.INSTANCE;
        Item item = new Item();
        item.setName("Item1");
        trackerSingleEnum.add(item);
        System.out.println(trackerSingleEnum.findById(item));

        TrackerSingleEnum trackerSingleEnum2 = TrackerSingleEnum.INSTANCE;
        Item item2 = new Item();
        item2.setName("Item2");
        trackerSingleEnum2.add(item2);
        System.out.println(trackerSingleEnum2.findById(item2));

    }


}
