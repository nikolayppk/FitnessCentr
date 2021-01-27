package ru.lushenko.fitnesscentr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subscription {
    Subscription(String name, int price, List<String> listService){
        this.listService = listService;
        this.name = name;
        this.price = price;
    }
    static int idSubscription;
    private String name;
    private int price;
    private List<String> listService;
    private int id;

    public String getName(){
        return this.name;
    }
    public static int getId(){
        return idSubscription;
    }

    /*Отображение подробной информации абонемента*/
    public void showDescriptionSubscription(){
        System.out.println(this.name + listService + " - " + this.price + " руб");
    }
    /*Отображение наименований абонемента*/
    public void showNameSubscription(int i){
        System.out.println("["+i+"] " + this.name);
    }

    /*Покупка абонемента*/
    public void buySubscription(String name){
        Map<String, Integer> buyID = new HashMap<>();
        buyID.put(name, 11);
    }

}
