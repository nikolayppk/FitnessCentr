package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;


public class SubscriptionAction implements Action {

    private String title;
    private Repository<String, TypeSubscription> repository;


    public SubscriptionAction(String title, Repository<String, TypeSubscription> repository) {
        this.repository = repository;
        this.title = title;
    }

    @Override
    public void run() {
        for (TypeSubscription typeSubscription : this.repository.getAll())
            System.out.println(typeSubscription.getDescription());
        System.out.println();
    }

    public SubscriptionAction(Repository<String, TypeSubscription> repository) {
        this.repository = repository;
    }

    @Override
    public String title() {
        return title;
    }
}
