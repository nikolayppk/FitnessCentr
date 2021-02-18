package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;


public class ShowSubscriptionAction implements Action {

    private Repository<String, TypeSubscription> repository;


    public ShowSubscriptionAction(Repository<String, TypeSubscription> repository) {
        this.repository = repository;
    }

    @Override
    public void run(Dialog dialog) {
        for (TypeSubscription typeSubscription : this.repository.getAll())
            dialog.showMessage(typeSubscription.getDescription());
    }

}
