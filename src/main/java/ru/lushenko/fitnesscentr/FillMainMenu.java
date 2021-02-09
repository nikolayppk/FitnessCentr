package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.domain.Menu;

public class FillMainMenu {

    static public void createMenu(Menu mainMenu) {
        mainMenu.setTitle("Выбирите действие:");
        mainMenu.addItem("1", "Показать список абонементов");
        mainMenu.addItem("2", "Купить абонемент");
        mainMenu.addItem("3", "Проверка абонемента");
        mainMenu.addItem("4", "Выход");
    }
    static public void createSubMenu(Menu subMenu){
        subMenu.addItem("2.1", "Выберите абонемент:");
        subMenu.addItem("3.1", "Введите ID абонемента:");
    }
}
