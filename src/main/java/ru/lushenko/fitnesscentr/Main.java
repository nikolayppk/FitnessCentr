package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.CheckBuyAction;
import ru.lushenko.fitnesscentr.action.BuyAction;
import ru.lushenko.fitnesscentr.action.ShowSubscriptionAction;
import ru.lushenko.fitnesscentr.console.*;
import ru.lushenko.fitnesscentr.domain.*;

import java.util.Arrays;

public class Main {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    private final Repository<String, Buy> buyRepository = new BuyRepository("listBuyId.txt");
    private Dialog consoleDialog = new ConsoleDialog();

    public void run() {
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        new Menu("Выберите действие:",
                Arrays.asList(
                        new DefaultMenuAction("Показать все абонементы", new ShowSubscriptionAction(typeSubscriptionRepository)),
                        new DefaultMenuAction("Купить абонемент",
                                new Menu("Выберите абонемент:",Arrays.asList(
                                        new DefaultMenuAction(typeSubscriptionRepository.get("1").getName(), new BuyAction(typeSubscriptionRepository.get("1"), buyRepository)),
                                        new DefaultMenuAction(typeSubscriptionRepository.get("2").getName(), new BuyAction(typeSubscriptionRepository.get("2"), buyRepository)),
                                        new DefaultMenuAction(typeSubscriptionRepository.get("3").getName(), new BuyAction(typeSubscriptionRepository.get("3"), buyRepository)),
                                        new DefaultMenuAction("Назад", new BreakAction())))),
                new DefaultMenuAction("Проверить абонемент", new CheckBuyAction(buyRepository)),
                new DefaultMenuAction("Выход", new BreakAction())
                )).run(consoleDialog);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
