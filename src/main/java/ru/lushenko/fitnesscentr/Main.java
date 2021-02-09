package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.domain.*;

import java.io.*;

public class Main {
    /*Файл для записи покупок*/
    private final File file = new File("listBuyId.txt");
    /*Инициализируем переменные*/
    private final Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    private final Repository<String, Buy> buyRepository = new InMemoryRepository<>();
    //static Repository<String, Buy> buyRepository = new BuyRepository(file);
    private final HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    private final Menu mainMenu = new Menu();
    private final Menu subMenu = new Menu();

    public void run() {
        /*Создаем меню*/
        FillMainMenu.createMenu(mainMenu);
        FillMainMenu.createSubMenu(subMenu);
        /*Заполняем типы абонементов*/
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        /*Вывод главного меню*/
        mainMenu.showMenu();
        /*Ввод с клавиатуры для навигации в главном меню*/
        String position = Action.getPrintInput();
        /*Цикл для работы в главном меню*/
        while ( !position.equals(4)) {
            boolean repeat = true;
            switch (position) {
                case "1": Action.showAllSubscription(typeSubscriptionRepository);
                    break;
                case "2":
                    subMenu.printNameItem("2.1");
                    Action.selectSubscriptionForBuy(typeSubscriptionRepository);
                    Action.buySubscription(typeSubscriptionRepository, buyRepository);
                    break;
                case "3":
                    subMenu.printNameItem("3.1");
                    Action.checkBuyID(Action.getPrintInput(), buyRepository);
                    break;
                case "4": repeat = false;
                    break;
                default:
                    System.out.println("Введенное значение отсутствует в списке. Введите корректное значение.");
            }
            if (repeat == true) {
                System.out.println();
                mainMenu.showMenu();
                position = Action.getPrintInput();
            }
            else break;
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }
}
