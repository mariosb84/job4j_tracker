package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /*public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }*/
    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }
    /*public Item[] findAll() {
Item[] itemWithoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemWithoutNull[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemWithoutNull, size);
    }*/
    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }
    public Item[] findByName(String key) {
        Item[] itemWithKey = new Item[items.length];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                itemWithKey[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(itemWithKey, size);
    }
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    /*public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
       if (index != -1) {
           items[index] = item;
           item.setId(item.getId());
           result = true;
       }
    return result;
    }*/
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean replaced = false;
        for (Item item1 : this.items) {
            if (item1 != null && item1.getId() == index) {
                 item1 = null;
                item.setId(index);
                replaced = true;
                break;
            }
        }

        return replaced;
    }

}