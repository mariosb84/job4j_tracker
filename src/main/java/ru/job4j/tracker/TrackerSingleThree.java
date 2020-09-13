package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleThree {
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return INSTANCE;
    }

    public Tracker getInstanceOne() {
        return tracker;
    }
    public static void main(String[] args) {
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
        TrackerSingleThree tracker2 = TrackerSingleThree.getInstance();
        Item item = new Item();
        item.setName("Item");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.getInstanceOne().add(item2);
        System.out.println(tracker.getInstanceOne().findById(item.getId()));
        System.out.println(Arrays.toString(tracker.getInstanceOne().findAll()));
    }


}
