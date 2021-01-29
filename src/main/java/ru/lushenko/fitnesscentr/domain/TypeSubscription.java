package ru.lushenko.fitnesscentr.domain;

import java.util.ArrayList;
import java.util.List;

public class TypeSubscription implements Identificator{

    public String getId() {
        return id;
    }

    private String id;
    private String name;
    private int price;
    private List<FitnessService> services;

    public int getPrice() {
        return price;
    }

    public TypeSubscription(String id, String name, int price, List<FitnessService> services) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.services = services;

    }

    public List<FitnessService> getServices() {
        return services;
    }

    public void printNameServices(){
        List<String> list = new ArrayList<>();
        for (FitnessService service: services)
           list.add(service.getName());
        System.out.println(name + ": " + list);

    }

    public String getName() {
        return name;
    }
}
