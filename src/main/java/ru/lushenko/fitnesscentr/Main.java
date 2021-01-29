package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.domain.*;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*Инициализируем переменные*/
    static Repository<String, TypeSubscription> repository = new InMemoryRepository<>();
    static HardCodeFillSubscription hardCodeFillSubscription = new HardCodeFillSubscription();
    /*Создаем map для работы с созданными абонементами*/
    static Map<Integer, TypeSubscription> mapSubscription = new HashMap<>();
    /*Файл для записи покупок*/
    static File file = new File("listBuyId.txt");
    static Repository<String, Buy> buyRepository = new BuyRepository(file);

    public static void main(String[] args) throws IOException {
        /*Заполняем типы абонементов*/
        hardCodeFillSubscription.fill(repository);
        /*Добавляем существующие абонементы в меню*/
        addSubscriptionInMenu(mapSubscription);
        /*Вывод главного меню*/
        showMainMenu();
        /*Ввод с клавиатуры для навигации в главном меню*/
        String position = getPrintInput();
        /*Цикл для работы в главном меню*/
        while ( !position.equals(4)) {
            boolean repeat = true;
            switch (position) {
                case "1": showAllSubscription(mapSubscription);
                    break;
                case "2":
                    System.out.println("Выбирите абонемент:");
                    selectSubscriptionForBuy(mapSubscription);
                    buySubscription(mapSubscription, file);
                    break;
                case "3":
                    System.out.println("Введите ID абонемента:");
                    checkBuyID(getPrintInput(), file);
                    break;
                case "4": repeat = false;
                    break;
                default:
                    System.out.println("Введенное значение отсутствует в списке. Введите корректное значение.");
            }
            if (repeat == true) {
                System.out.println();
                showMainMenu();
                position = getPrintInput();
            }
            else break;
        }
    }
    /*Отображение главного меню*/
    public static void showMainMenu(){
        System.out.println("Выбирите действие:");
        System.out.println("[1] Показать список абонементов\n[2] Купить абонемент\n[3] Проверка абонемента\n[4] Выход");
    }

    /***
     * Метод отображает отображает подробную информацию имеющихся вбонементов
     * @param mapSubscription - список абонементов*/
    public static void showAllSubscription(Map<Integer, TypeSubscription> mapSubscription){
        for (int i = 1; i <= mapSubscription.size(); i++)
            mapSubscription.get(i).printNameServices();
    }

    /***
     * Метод для выбора абонемента при покупке
     * @param mapSubscription - список абонементов*/
    public static void selectSubscriptionForBuy(Map<Integer, TypeSubscription> mapSubscription){
        for (int i = 1; i <= mapSubscription.size(); i++) {
            System.out.println("[" + i + "] " + mapSubscription.get(i).getName());
        }
        int a = mapSubscription.size()+1;
        System.out.println("[" + a + "] Назад" );
    }
    /*Метод для добавления нового абонемента в общий список*/
    public static void addSubscriptionInMenu(Map<Integer, TypeSubscription> map){
        int i = 1;
        for (TypeSubscription typeSubscription : repository.getAll()) {
            map.put(i, typeSubscription);
            i++;
        }
    }

    /***
     * Метод для выполнения покупки
     * @param mapSubscription - список абонементов
     * @param file - файл в который выполняем запись ID купленного абонемента*/
    public static void buySubscription(Map<Integer, TypeSubscription> mapSubscription, File file) throws IOException {
        //Вводим позицию абонемента, который хотим купить
        String position = getPrintInput();
        int positionBuy = Integer.parseInt(position);
        boolean doneBuy = false;
        try {
            if (positionBuy == mapSubscription.size() + 1)
                System.out.println("Покупка не выбрана");
            else {
                for (int i = 1; i <= mapSubscription.size(); i++) {
                    if (i == positionBuy) {
                        Buy buy = new Buy(mapSubscription.get(i).getName());
                        /*Выполняем запись покупки*/
                        buyRepository.add(buy);
//                        writeToFile(file, buy.getBuyId(), buy.getBuyName());
                        /*Отображение ID покупки*/
                        System.out.println("Вы выбрали абонемент " + mapSubscription.get(i).getName() + ", ID покупки: " + buy.getBuyId());
                        doneBuy = true;
                        break;
                    }
                }
                if (doneBuy == false)
                    System.out.println("Введенное значение отсутствует в списке. Введите корректное значение.");
            }
        }
        catch (Exception e){
            System.out.println("Ошибка: Введенное значение отсутствует в списке. Введите корректное значение.");
        }
    }

    /***
     * Метод для проверки ID покупки
     * @param id - ID покупки
     * @param file - текстовый файл в котором выполняем поиск
     */
    public static void checkBuyID(String id, File file) throws IOException {
        //Выполняем чтение файла с сохраненными id
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        // считаем сначала первую строку
        String line = reader.readLine();
        boolean checkStatus = false;
        while (line != null) {
            if (line.equals(id)){
                //Считываем наименование абонемента по найденному ID
                line = reader.readLine();
                System.out.println("Ваш абонемент " + line);
                checkStatus = true;
                break;}
            // считываем остальные строки в цикле
            line = reader.readLine();
        }
        if (checkStatus == false){
            System.out.println("По данному ID покупка не найдена");
        }
    }

    /*Метод возвращает введенный текст*/
    public static String getPrintInput() throws IOException {
        String valuePrint = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return valuePrint = reader.readLine();
    }
}
