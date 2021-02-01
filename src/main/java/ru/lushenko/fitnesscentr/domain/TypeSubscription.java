package ru.lushenko.fitnesscentr.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TypeSubscription implements Identification {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeSubscription)) return false;
        TypeSubscription that = (TypeSubscription) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public List<FitnessService> getServices() {
        return services;
    }

    public void printDescriptorSubscription(){
        List<String> list = new ArrayList<>();
        for (FitnessService service: services)
           list.add(service.getName());
        System.out.println(name + ": " + list + " - " + price + " рублей");
    }

    public String getName() {
        return name;
    }
}
