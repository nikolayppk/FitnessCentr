package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.*;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;

import java.util.ArrayList;
import java.util.List;

public class SelectBuyAction implements Action {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository;
    private final Repository<String, Buy> buyRepository;

    public SelectBuyAction(Repository<String, TypeSubscription> typeSubscriptionRepository, Repository<String, Buy> buyRepository) {
        this.typeSubscriptionRepository = typeSubscriptionRepository;
        this.buyRepository = buyRepository;
    }

    @Override
    public void run(Dialog dialog) {
        new Menu ("Выбирите абонемент", getListDefaultMenuAction()).run(dialog);
    }

    public List<MenuAction> getListDefaultMenuAction() {
        List<MenuAction> defaultMenuActionList = new ArrayList<>();
        for (TypeSubscription subscription : this.typeSubscriptionRepository.getAll())
            defaultMenuActionList.add(new DefaultMenuAction(subscription.getName(), new BuyAction(subscription, this.buyRepository)));
        return defaultMenuActionList;
    }
}
