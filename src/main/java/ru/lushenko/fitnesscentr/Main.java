package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.CheckBuyAction;
import ru.lushenko.fitnesscentr.action.SelectBuyAction;
import ru.lushenko.fitnesscentr.action.PrintSubscriptionAction;
import ru.lushenko.fitnesscentr.console.Menu;
import ru.lushenko.fitnesscentr.console.*;
import ru.lushenko.fitnesscentr.domain.*;

import java.util.Arrays;

public class Main {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    private final Repository<String, Buy> buyRepository = new BuyRepository("listBuyId.txt");
    private final ConsoleDialog consoleDialog = new ConsoleDialog();

    public void run() {
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        new Menu("Выбирите действие: ",
                new ConsoleDialog(),
                Arrays.asList(
                        new DefaultMenuAction("Показать все абонементы", 1, new PrintSubscriptionAction(typeSubscriptionRepository, consoleDialog)),
                        new DefaultMenuAction("Купить абонемент", 2, new SelectBuyAction("Выберите абонемент:", typeSubscriptionRepository, buyRepository, consoleDialog)),
                        new DefaultMenuAction("Проверить абонемент", 3,new CheckBuyAction("Введите ID покупки:", buyRepository, consoleDialog)),
                        new DefaultMenuAction("Выход", 4, new BreakAction(consoleDialog))
                )
        ).run();
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
