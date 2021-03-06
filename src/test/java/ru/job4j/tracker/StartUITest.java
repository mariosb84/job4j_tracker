package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;


public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
       // Input input = new StubInput(answers);                                                         replace to List
        Input input = new StubInput(Arrays.asList(answers));
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
      //  Item created = tracker.findAll()[0];                                                          replace to List
        Item created = tracker.findAll().get(0);
        Item expected = new Item();
        expected.setName("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        String[] answers = {
                "replaced item",
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
        };
       // StartUI.editItem(new StubInput(answers), tracker);                                            replace to List
        StartUI.editItem(new StubInput(Arrays.asList(answers)), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
        };
       // StartUI.deleteItem(new StubInput(answers), tracker);                                          replace to List
        StartUI.deleteItem(new StubInput(Arrays.asList(answers)), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }


    }
