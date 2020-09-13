package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class TrackerSingleTest {
    @Test
    public void whenTrackerSingleEnum() {
        TrackerSingleEnum tracker = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker3 = TrackerSingleEnum.INSTANCE;
        Item item = new Item();
        item.setName("test1");
        tracker.getInstance().add(item);
        Item item2 = new Item();
        item2.setName("test2");
        tracker2.getInstance().add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker3.getInstance().add(item3);
        assertThat(tracker.getInstance().findAll(), is (new Item[]{item , item2, item3}));

    }
    @Test
    public void whenTrackerSingleTwo () {
        TrackerSingleTwo tracker = TrackerSingleTwo.getInstance();
        TrackerSingleTwo tracker2 = TrackerSingleTwo.getInstance();
        TrackerSingleTwo tracker3 = TrackerSingleTwo.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("test2");
        tracker2.getInstanceOne().add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker3.getInstanceOne().add(item3);
        assertThat(tracker.getInstanceOne().findAll(), is (new Item[]{item , item2, item3}));

    }
    @Test
    public void whenTrackerSingleThree () {
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
        TrackerSingleThree tracker2 = TrackerSingleThree.getInstance();
        TrackerSingleThree tracker3 = TrackerSingleThree.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("test2");
        tracker2.getInstanceOne().add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker3.getInstanceOne().add(item3);
        assertThat(tracker.getInstanceOne().findAll(), is (new Item[]{item , item2, item3}));

    }
    @Test
    public void whenTrackerSingleFour () {
        TrackerSingleFour tracker = TrackerSingleFour.getInstance();
        TrackerSingleFour tracker2 = TrackerSingleFour.getInstance();
        TrackerSingleFour tracker3 = TrackerSingleFour.getInstance();
        Item item = new Item();
        item.setName("test1");
        tracker.getInstanceOne().add(item);
        Item item2 = new Item();
        item2.setName("test2");
        tracker2.getInstanceOne().add(item2);
        Item item3 = new Item();
        item3.setName("test3");
        tracker3.getInstanceOne().add(item3);
        assertThat(tracker.getInstanceOne().findAll(), is (new Item[]{item , item2, item3}));

    }
}