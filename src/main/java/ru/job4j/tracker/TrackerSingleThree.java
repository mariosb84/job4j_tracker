package ru.job4j.tracker;

import ru.job4j.tracker.Item;
public class TrackerSingleThree {
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return INSTANCE;
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
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
        Item item = new Item();
        item.setName("Item1");
        tracker.add(item);
        System.out.println(tracker.findById(item));

        TrackerSingleThree tracker2 = TrackerSingleThree.getInstance();
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.add(item2);
        System.out.println(tracker2.findById(item2));
    }


}
