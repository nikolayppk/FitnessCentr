package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.DefaultMenuAction;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.console.Menu;
import ru.lushenko.fitnesscentr.domain.*;

import java.util.Arrays;

public class RunApp implements Action {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final Repository<String, Buy> buyRepository = new BuyRepository("listBuyId.txt");
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription(typeSubscriptionRepository);

    public void run(Dialog dialog) {
        new Menu("Выберите действие:",
                Arrays.asList(
                        new DefaultMenuAction("Показать все абонементы", new ShowSubscriptionAction(typeSubscriptionRepository)),
                        new DefaultMenuAction("Купить абонемент", new SelectBuyAction(typeSubscriptionRepository, buyRepository)),
                        new DefaultMenuAction("Проверить абонемент", new CheckBuyAction(buyRepository))
                )).run(dialog);
    }
}
