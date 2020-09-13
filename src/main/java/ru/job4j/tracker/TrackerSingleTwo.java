package ru.job4j.tracker;

import ru.job4j.tracker.Item;
public class TrackerSingleTwo {
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    private static TrackerSingleTwo instance;

    private TrackerSingleTwo() {
    }

    public static TrackerSingleTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleTwo();
        }
        return instance;
    }

    public Item add(Item model) {
        this.item = model;
        return this.tracker.add(model);
    }
    public Item findById(Item model) {
        this.item = model;
        return this.tracker.findById(model.getId());
    }

    public static void main(String[] args) {
        TrackerSingleTwo trackerSingleTwo = TrackerSingleTwo.getInstance();
        Item item = new Item();
        item.setName("Item1");
        trackerSingleTwo.add(item);
        System.out.println(trackerSingleTwo.findById(item));

        TrackerSingleTwo trackerSingleTwo2 = TrackerSingleTwo.getInstance();
        Item item2 = new Item();
        item2.setName("Item2");
        trackerSingleTwo2.add(item2);
        System.out.println(trackerSingleTwo2.findById(item2));
    }
}
