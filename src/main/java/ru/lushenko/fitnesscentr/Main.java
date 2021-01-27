package ru.lushenko.fitnesscentr;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*Типы сервисов*/
    static String service1 = Services.SWIMMING;
    static String service2 = Services.GYM;
    static String service3 = Services.RUN;
    static String service4 = Services.GROUP_PROGRAMS;
    static String service5 = Services.GROUP_PROGRAMS;
    /*Типы абонементов*/
    static String nameSubscription1 = TypeSubscription.VIP;
    static String nameSubscription2 = TypeSubscription.STANDARD;
    static String nameSubscription3 = TypeSubscription.OPTIMUM;
    /*Создаем списки сервисов в соответствии с типом абонемента*/
    static List<String> servicesVIP = Arrays.asList(service1, service2, service3, service4, service5);
    static List<String> servicesStandard = Arrays.asList(service1, service2, service3, service4);
    static List<String> servicesOptimum = Arrays.asList(service2, service3, service4);
    /*Создаем map для работы с созданными абонементами*/
    static Map<Integer, Subscription> mapSubscription = new HashMap<>();
    /*Файл для записи покупок*/
    static File file = new File("listBuyId.txt");

    public static void main(String[] args) throws IOException {

        /*Создаем абонементы и добавляем их в общий список в соответствии с позицией*/
        addSubscriptionInMenu(mapSubscription,1, nameSubscription1, 50000, servicesVIP);
        addSubscriptionInMenu(mapSubscription,2, nameSubscription2, 20000, servicesStandard);
        addSubscriptionInMenu(mapSubscription,3, nameSubscription3, 10000, servicesOptimum);
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
    public static void showAllSubscription(Map<Integer, Subscription> mapSubscription){
        for (int i = 1; i <= mapSubscription.size(); i++)
            mapSubscription.get(i).showDescriptionSubscription();
    }

    /***
     * Метод для выбора абонемента при покупке
     * @param mapSubscription - список абонементов*/
    public static void selectSubscriptionForBuy(Map<Integer, Subscription> mapSubscription){
        for (int i = 1; i <= mapSubscription.size(); i++) {
            System.out.println("[" + i + "] " + mapSubscription.get(i).getName());
        }
        int a = mapSubscription.size()+1;
        System.out.println("[" + a + "] Назад" );
    }
    /*Метод для добавления нового абонемента в общий список*/
    public static void addSubscriptionInMenu(Map<Integer, Subscription> map, int position, String nameSubscription, int priceSubscription, List<String> listService){
        Subscription subscription = new Subscription(nameSubscription, priceSubscription, listService);
        map.put(position, subscription);
    }

    /***
     * Метод для выполнения покупки
     * @param mapSubscription - список абонементов
     * @param file - файл в который выполняем запись ID купленного абонемента*/
    public static void buySubscription(Map<Integer, Subscription> mapSubscription, File file) throws IOException {
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
                        writeToFile(file, buy.getBuyId(), buy.getBuyName());
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

    /***
     * Метод выполняет запись в текстовый файл в формате "id имя"
     * @param file - текстовый файл в который выполняем запись
     * @param id - id новой покупки
     * @param name - наименование типа абонемента
     * */
    public static void writeToFile(File file, String id, String name) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        writer.write(id + "\n" + name + "\n");
        writer.close();
    }
}
