package ru.job4j.tracker;

import ru.job4j.tracker.Item;
public class TrackerSingleFour {
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    private TrackerSingleFour() {
    }

    public static TrackerSingleFour getInstance() {
        return Holder.INSTANCE;
    }

    public Item add(Item model) {
        this.item = model;
        return this.tracker.add(model);
    }
    public Item findById(Item model) {
        this.item = model;
        return this.tracker.findById(model.getId());
    }

    private static final class Holder {
        private static final TrackerSingleFour INSTANCE = new TrackerSingleFour();
    }

    public static void main(String[] args) {
        TrackerSingleFour tracker = TrackerSingleFour.getInstance();
        Item item = new Item();
        item.setName("Item1");
        tracker.add(item);
        System.out.println(tracker.findById(item));

        TrackerSingleFour tracker2 = TrackerSingleFour.getInstance();
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.add(item2);
        System.out.println(tracker2.findById(item2));
    }
}
