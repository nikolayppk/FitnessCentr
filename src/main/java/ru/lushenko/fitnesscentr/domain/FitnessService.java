package ru.lushenko.fitnesscentr.domain;

public class FitnessService {

    public FitnessService(String name) { this.name = name; }

    private String name;

    public String getName(){
       return this.name;
    }

}
