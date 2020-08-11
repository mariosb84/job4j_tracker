package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Cat");
        item.setId(99);
        Item itemTwo = new Item();
        itemTwo.setName("Dog");
        itemTwo.setId(25);
        System.out.println(item);
        System.out.println(itemTwo);
        System.out.println();
        Tracker tracker = new Tracker();
        System.out.println("Добавляем заявку методом \"add\"");
        tracker.add(item);
        tracker.add(itemTwo);
        System.out.println();
        System.out.println("Находим  методом \"findById\":");
        System.out.println();
        System.out.println(tracker.findById(item.getId()));
        System.out.println(tracker.findById(itemTwo.getId()));
        System.out.println("Находим  методом \"findByName\":");
        System.out.println();
        System.out.println(Arrays.toString(tracker.findByName("Cat")));
        System.out.println(Arrays.toString(tracker.findByName("Dog")));
        System.out.println("Выводим весь массив методом \"findAll\":");
        System.out.println();
        System.out.println(Arrays.toString(tracker.findAll()));

    }
}
