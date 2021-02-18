package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;


public class PrintSubscriptionAction implements Action {

    private Repository<String, TypeSubscription> repository;
    private ConsoleDialog consoleDialog;


    public PrintSubscriptionAction(Repository<String, TypeSubscription> repository, ConsoleDialog consoleDialog) {
        this.repository = repository;
        this.consoleDialog = consoleDialog;
    }

    @Override
    public void run() {
        for (TypeSubscription typeSubscription : this.repository.getAll())
            consoleDialog.printText(typeSubscription.getDescription());
        consoleDialog.printText("**********************************");
    }

    public PrintSubscriptionAction(Repository<String, TypeSubscription> repository) {
        this.repository = repository;
    }

}
