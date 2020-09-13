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
        tracker.add(item);

        Item item2 = new Item();
        item2.setName("test2");
        tracker2.add(item2);

        Item item3 = new Item();
        item3.setName("test3");
        tracker3.add(item3);

        Item result = tracker.findById(item);
        Item result2 = tracker2.findById(item2);
        Item result3 = tracker3.findById(item3);
        assertThat((result.getName()  + result2.getName() + result3.getName()), allOf ((is(item.getName())) , (is(nullValue())), (is(nullValue()))));

    }
}