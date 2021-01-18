package FitnessCentr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Membership {
    Membership (String name, int price, List<String> listService){
        this.listService = listService;
        this.name = name;
        this.price = price;
    }
    static int idMembership;
    private String name;
    private int price;
    private List<String> listService;
    private int id;

    public String getName(){
        return this.name;
    }
    public static int getId(){
        return idMembership;
    }

    /*Отображение подробной информации абонемента*/
    public void showDescriotionMembership(){
        System.out.println(this.name + listService + " - " + this.price + " руб");
    }
    /*Отображение наименований абонемента*/
    public void showNameMembership(int i){
        System.out.println("["+i+"] " + this.name);
    }

    /*Покупка абонемента*/
    public void buyMembership(String name){
        Map<String, Integer> buyID = new HashMap<>();
        buyID.put(name, 11);
    }

}
