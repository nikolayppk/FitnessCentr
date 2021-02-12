package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.CheckBuyAction;
import ru.lushenko.fitnesscentr.action.SelectBuyAction;
import ru.lushenko.fitnesscentr.action.SubscriptionAction;
import ru.lushenko.fitnesscentr.console.BreakAction;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;
import ru.lushenko.fitnesscentr.console.Menu;
import ru.lushenko.fitnesscentr.console.PrintAction;
import ru.lushenko.fitnesscentr.domain.*;

import java.util.Arrays;

public class Main {
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    private final Repository<String, Buy> buyRepository = new BuyRepository("listBuyId.txt");
    private final ConsoleDialog consoleDialog = new ConsoleDialog();

    //TODO перенести цикл в класс Menu
    public void run() {
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        while (true) {
            new Menu(
                    new ConsoleDialog(),
                    "Выберите действие:", Arrays.asList(
                    new PrintAction("", "", consoleDialog),
                    new SubscriptionAction("1 - Показать список абонементов", typeSubscriptionRepository, consoleDialog),
                    new SelectBuyAction("2 - Купить абонемент", "Выберите абонемент:", typeSubscriptionRepository, buyRepository, consoleDialog),
                    new CheckBuyAction("3 - Проверка абонемента", "Введите ID покупки:", buyRepository, consoleDialog),
                    new BreakAction("4 - Выход")
                    )
            ).run();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
