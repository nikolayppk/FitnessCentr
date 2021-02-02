package ru.lushenko.fitnesscentr.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {

    private String title;

    private Map<String, String> items = new HashMap<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAllItems() {
        return new ArrayList(items.values());
    }

    public void addItem(String position, String name){
        items.put(position, name);
    }

    public void showMenu(){
        System.out.println(getTitle());
        for (Map.Entry<String, String> map : items.entrySet()) {
            System.out.println(map.getKey() + " - " + map.getValue());
        }
    }
    public void printNameItem(String positionItem) {
        System.out.println(items.get(positionItem));
    }
}
