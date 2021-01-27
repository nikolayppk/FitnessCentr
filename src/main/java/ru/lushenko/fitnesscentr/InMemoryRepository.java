package ru.lushenko.fitnesscentr;

import java.util.List;

public interface InMemoryRepository <ID, T> {

    T get(ID id);
    void add(T item);
    List getAll();
}

