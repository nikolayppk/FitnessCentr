package ru.lushenko.fitnesscentr.domain;

import java.io.File;

public class Run {
    Menu mainMenu = new Menu();
    /*Файл для записи покупок*/
    static File file = new File("listBuyId.txt");
    /*Инициализируем переменные*/
    static Repository<String, TypeSubscription> typeSubscriptionRepository = new InMemoryRepository<>();
    static Repository<String, Buy> buyRepository = new BuyRepository(file);
    static HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    /*Создаем и выводим главное меню*/
    public void showMenu(){
        mainMenu.setTitle("Выберите действие:");
        mainMenu.addItem("1", "Показать список абонементов");
        mainMenu.addItem("2", "Купить абонемент");
        mainMenu.addItem("3", "Проверка абонемента");
        mainMenu.addItem("4", "Выход");
        mainMenu.printMenu();
    }

}
