package ru.job4j.tracker;
import java.util.Arrays;

public enum TrackerSingleEnum {
    INSTANCE;// здесь мы указываем перечисления.
    private  Item item = new Item();
    private Tracker tracker = new Tracker();
    // Конструкторы и методы.
    public Tracker getInstance() {
        return tracker;
    }
    public static void main(String[] args) {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        Item item = new Item();
        item.setName("Item");
        tracker.getInstance().add(item);
        Item item2 = new Item();
        item2.setName("Item2");
        tracker2.getInstance().add(item2);
        System.out.println(tracker.getInstance().findById(item.getId()));
        System.out.println(Arrays.toString(tracker.getInstance().findAll()));





    }


}
