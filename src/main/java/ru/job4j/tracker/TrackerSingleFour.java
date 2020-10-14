package ru.job4j.tracker;

import java.util.Arrays;

public class TrackerSingleFour {
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    private TrackerSingleFour() {
    }

    public static TrackerSingleFour getInstance() {
        return Holder.INSTANCE;
    }

    public Tracker getInstanceOne() {
        return tracker;
    }

    private static final class Holder {
        private static final TrackerSingleFour INSTANCE = new TrackerSingleFour();
    }

    public static void main(String[] args) {
        TrackerSingleFour tracker = TrackerSingleFour.getInstance();
        TrackerSingleFour tracker2 = TrackerSingleFour.getInstance();
        Item item = new Item();
        item.setName("Item");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.getInstanceOne().add(item2);
        System.out.println(tracker.getInstanceOne().findById(item.getId()));
        //System.out.println(Arrays.toString(tracker.getInstanceOne().findAll()));               Переделать под лист !!!
    }
}
