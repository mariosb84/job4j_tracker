package ru.job4j.tracker;

import java.util.Arrays;

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

    public Tracker getInstanceOne() {
        return tracker;
    }

    public static void main(String[] args) {
        TrackerSingleTwo tracker = TrackerSingleTwo.getInstance();
        TrackerSingleTwo tracker2 = TrackerSingleTwo.getInstance();
        Item item = new Item();
        item.setName("Item");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.getInstanceOne().add(item2);
        System.out.println(tracker.getInstanceOne().findById(item.getId()));
        //System.out.println(Arrays.toString(tracker.getInstanceOne().findAll()));               Переделать под лист !!!
        System.out.println(tracker.getInstanceOne().findAll());

    }
}
