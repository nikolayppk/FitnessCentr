package ru.lushenko.fitnesscentr.domain;

import java.util.List;

public interface Repository<ID, T> {

    T get(ID id);
    void add(T item);
    List<T> getAll();

}

