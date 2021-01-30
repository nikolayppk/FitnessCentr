package ru.lushenko.fitnesscentr.domain;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private String name;
    private String position;
    private String title;
    private Map<String, String> map =new HashMap<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public void addItem(String position, String name){
        map.put(position, name);
    }

    public void printMenu() {
        System.out.println(title);
        for (Map.Entry<String, String> entry : map.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
    }

    public void addAction(){
        Action action = new Action();
    }

}
