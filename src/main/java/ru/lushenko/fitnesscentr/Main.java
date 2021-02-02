package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.domain.*;

import java.io.*;

public class Main {
    /*Файл для записи покупок*/
    static File file = new File("listBuyId.txt");
    /*Инициализируем переменные*/
    static Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    static Repository<String, Buy> buyRepository = new BuyRepository(file);
    static HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    static Menu mainMenu = new Menu();
    static Menu subMenu = new Menu();

    public static void main(String[] args) {
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
}
