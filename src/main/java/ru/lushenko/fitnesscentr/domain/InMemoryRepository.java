package ru.lushenko.fitnesscentr.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Identificator> implements Repository<String, T>{

    private final Map<String, T> items = new HashMap<>();

    @Override
    public T get(String id) {
        return this.items.get(id);
    }

    @Override
    public void add(T item) {
this.items.put(item.getId(), item);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList(this.items.values());
    }
}
