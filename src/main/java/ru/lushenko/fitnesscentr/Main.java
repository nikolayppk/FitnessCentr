package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.CheckBuyAction;
import ru.lushenko.fitnesscentr.action.SelectBuyAction;
import ru.lushenko.fitnesscentr.action.SubscriptionAction;
import ru.lushenko.fitnesscentr.console.BreakAction;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;
import ru.lushenko.fitnesscentr.console.Menu;
import ru.lushenko.fitnesscentr.console.PrintAction;
import ru.lushenko.fitnesscentr.domain.*;

import java.io.File;
import java.util.Arrays;

public class Main {
    private final File file = new File("listBuyId.txt");
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    private final Repository<String, Buy> buyRepository = new BuyRepository(file);

    public void run() {
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        while (true) {
            new Menu(
                    new ConsoleDialog(),
                    "Выберите действие:", Arrays.asList(
                    new PrintAction("", ""),
                    new SubscriptionAction("1 - Показать список абонементов", typeSubscriptionRepository),
                    new SelectBuyAction("2 - Купить абонемент", "Выберите абонемент:", typeSubscriptionRepository, buyRepository),
                    new CheckBuyAction("3 - Проверка абонемента", "Введите ID покупки:", buyRepository),
                    new BreakAction("4 - Выход")
                    )
            ).run();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
