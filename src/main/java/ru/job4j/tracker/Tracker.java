package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    //private final Item[] items = new Item[100];                                                       replace to List
    List<Item> items = new ArrayList<Item>();
    private int ids = 1;
   // private int size = 0;                                                                 //            replace to List

    public Item add(Item item) {
        item.setId(ids++);
        //items[size++] = item;                                                                         replace to List
        //items.set(size++, item);                                                                      replace to List
        //items.add(size++, item);                                                                  //    replace to List
        items.add(item);
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
        int index = indexOf(id);                                                                   //   replace to List
        /* Если индекс найден возвращаем item, иначе null */
       // return index != -1 ? items[index] : null;                                                     replace to List
      //  return index != -1 ? items.get(index - 1) : null;
      // int index = findPosList(id);
       return index != -1 ? items.get(index) : null;
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
   // public Item[] findAll() {                                                                         replace to List      List<Item> items = new ArrayList<Item>();
        public List<Item>  findAll() {
       // return Arrays.copyOf(items, size);                                                            replace to List
        return List.copyOf(items);
    }
   // public Item[] findByName(String key) {                                                            replace to List
        public List<Item>  findByName(String key) {
       // Item[] itemWithKey = new Item[items.length];                                                  replace to List
       // Item[] itemWithKey = new Item[items.size()];                                                  replace to List
            List<Item> itemWithKey = new ArrayList<Item>();
        //int size = 0;                                                                                 replace to List
            //for (int i = 0; i < this.size; i++) {                                                     replace to List
        for (Item item : items) {
           // Item item = items[i];                                                                     replace to List
           // Item item = items.get(i);                                                                 replace to List
            if (item.getName().equals(key)) {
               // itemWithKey[size] = item;                                                              replace to List
                itemWithKey.add(item);
               // size++;                                                                                replace to List
            }
        }
        return List.copyOf(itemWithKey);
    }
    private int indexOf(int id) {
        int rsl = -1;
        //for (int index = 0; index < size; index++) {                                                  replace to List
        for (int index = 0; index < items.size(); index++) {
            //if (items[index].getId() == id) {                                                         replace to List
                    if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public boolean replace(int id, Item item) {
        boolean replaced = false;
        int index = indexOf(id);                                                                 //     replace to List
        //int index = findPosList(id);
        if (index != -1) {
       // items[index] = item;                                                                          replace to List
            items.set(index, item);
        item.setId(id);
            replaced = true;
        }
        return replaced;
    }
    public boolean delete(int id) {
        boolean deleted = false;
        int index = indexOf(id);                                                                    //  replace to List
       // int index = findPosList(id);
        if (index != -1) {
             //System.arraycopy(items,index + 1, items, index, size - index);                           replace to List
             // System.arraycopy(items,index + 1, items, index, size - index);                          replace to List
            //items[size - 1] = null;                                                                   replace to List
            // items.set(size - 1, null);                                                               replace to List
           // size--;
            items.remove(index);
            deleted = true;
        }
        return deleted;
    }
    private int findPosList(int id) {                                                           // dont use
        int index = indexOf(id);
        int positionList = -1;
        if (index != -1) {
            for (Item item : items) {
                positionList++;
                if (item.getId() == (index)) {
                    break;
                }
            }
        }
        return positionList;
    }

   /* public static void main(String[] args) {                                                    // dont use
        Item item = new Item();
        Tracker tracker = new Tracker();
        tracker.add(item);
        item.setName("1");
        System.out.println(tracker.indexOf(1));
    }*/



}