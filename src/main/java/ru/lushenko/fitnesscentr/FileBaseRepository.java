package ru.lushenko.fitnesscentr;

import java.util.List;

public interface FileBaseRepository <ID, T>{
    T get(ID id);
    void add(T item);
    List getAll();
}
