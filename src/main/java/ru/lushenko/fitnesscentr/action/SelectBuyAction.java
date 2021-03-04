package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.DefaultMenuAction;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.console.MenuAction;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;

import java.util.ArrayList;
import java.util.List;

public class SelectBuyAction implements MenuAction {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository;
    private final Repository<String, Buy> buyRepository;
    private List<MenuAction> defaultMenuList;

    public SelectBuyAction(Repository<String, TypeSubscription> typeSubscriptionRepository, Repository<String, Buy> buyRepository) {
        this.typeSubscriptionRepository = typeSubscriptionRepository;
        this.buyRepository = buyRepository;
    }

    public List<MenuAction> getDefaultMenuList() {
        defaultMenuList = new ArrayList<>();
        for (TypeSubscription subscription : typeSubscriptionRepository.getAll())
            defaultMenuList.add(new DefaultMenuAction(subscription.getName(), new BuyAction(subscription, buyRepository)));
        return defaultMenuList;
    }

    @Override
    public void run(Dialog dialog) {

    }

    @Override
    public String title() {
        return null;
    }
}
