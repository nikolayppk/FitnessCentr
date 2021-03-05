package ru.lushenko.fitnesscentr.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Identification> implements Repository<String, T> {

    private final Map<String, T> items = new HashMap<>();

    public InMemoryRepository() {
    }
    public InMemoryRepository(List<TypeSubscription> typeSubscriptions) {
        for (TypeSubscription typeSubscription : typeSubscriptions)
        items.put(typeSubscription.getId(), (T) typeSubscription);
    }

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
