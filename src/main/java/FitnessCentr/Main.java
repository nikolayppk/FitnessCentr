package FitnessCentr;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    /*Типы сервисов*/
    static String service1 = "Бассейн";
    static String service2 = "Тренажерный зал";
    static String service3 = "Легкоатлетический зал";
    static String service4 = "Групповые программы";
    static String service5 = "Персональные тренировки";
    /*Типы абонементов*/
    static String nameMembership1 = "VIP";
    static String nameMembership2 = "Standart";
    static String nameMembership3 = "Optimum";
    /*Создаем списки сервисов в соответствии с типом абонемента*/
    static List<String> servicesVIP = Arrays.asList(service1, service2, service3, service4, service5);
    static List<String> servicesStandart = Arrays.asList(service1, service2, service3, service4);
    static List<String> servicesOptimum = Arrays.asList(service2, service3, service4);
    static Map<Integer, Membership> mapMembership = new HashMap<>();
    /*Файл для записи покупок*/
    static File file = new File("listBuyId.txt");

    public static void main(String[] args) throws IOException {

        /*Создаем абонементы и добавляем их в общий список в соответствии с позицией*/
        addMembershipInMenu(mapMembership,1, nameMembership1, 50000, servicesVIP);
        addMembershipInMenu(mapMembership,2, nameMembership2, 20000, servicesStandart);
        addMembershipInMenu(mapMembership,3, nameMembership3, 10000, servicesOptimum);
        /*Вывод главного меню*/
        showMainMenu();
        /*Ввод с клавиатуры для навигации в главном меню*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position = reader.readLine();
        /*Цикл для работы в главном меню*/
        while ( !position.equals(4)) {
            boolean repeat = true;
            switch (position) {
                case "1": showAllMembership(mapMembership);
                    break;
                case "2":
                    System.out.println("Выбирите абонемент:");
                    selectMembershipForBuy(mapMembership);
                    buyMembership(mapMembership);
                    break;
                case "3":
                    System.out.println("Введите ID абонемента:");
                    checkBuyID();
                    break;
                case "4": repeat = false;
                    break;
                default:
                    System.out.println("Введенное значение отсутствует в списке. Введите корректное значение.");
            }
            if (repeat == true) {
                System.out.println();
                showMainMenu();
                position = reader.readLine();
            }
            else break;
        }
    }
    /*Отображение главного меню*/
    public static void showMainMenu(){
        System.out.println("Выбирите действие:");
        System.out.println("[1] Показать список абонементов\n[2] Купить абонемент\n[3] Проверка абонемента\n[4] Выход");
    }
    /*Метод для отображение всех абонементов и сервисов*/
    public static void showAllMembership(Map<Integer, Membership> mapMembership){
        for (int i = 1; i <= mapMembership.size(); i++)
            mapMembership.get(i).showDescriotionMembership();
    }
    /*Метод для выбора абонемента при покупке*/
    public static void selectMembershipForBuy(Map<Integer, Membership> mapMembership){
        for (int i = 1; i <= mapMembership.size(); i++) {
            System.out.println("[" + i + "] " + mapMembership.get(i).getName());
        }
        int a = mapMembership.size()+1;
        System.out.println("[" + a + "] Назад" );
    }
    /*Метод для добавления нового абонемента в общий список*/
    public static void addMembershipInMenu(Map<Integer, Membership> map, int position, String nameMembership, int priceMembership, List<String> listService){
        Membership membership = new Membership(nameMembership, priceMembership, listService);
        map.put(position, membership);
    }
    /*Метод для выполнения покупки*/
    public static void buyMembership(Map<Integer, Membership> mapMembership) throws IOException {
        //Вводим позицию абонемента, который хотим купить
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String position = reader.readLine();
        int positionBuy = Integer.parseInt(position);
        boolean doneBuy = false;

        try {
            if (positionBuy == mapMembership.size() + 1)
                System.out.println("Покупка не выбрана");
            else {
                for (int i = 1; i <= mapMembership.size(); i++) {
                    if (i == positionBuy) {
                        Buy buy = new Buy(mapMembership.get(i).getName());
                        /*Выполняем запись покупки*/
                        FileWriter writer = new FileWriter(file, true);
                        writer.write(buy.getBuyID() + "\n" + buy.getBuyName() + "\n");
                        writer.close();
                        /*Отображение ID покупки*/
                        System.out.println("Вы выбрали абонемент " + mapMembership.get(i).getName() + ", ID покупки: " + buy.getBuyID());
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
    /*Метод для проверки ID покупки*/
    public static void checkBuyID() throws IOException {
        //Вводим id который хотим проверить
        BufferedReader vvodId = new BufferedReader(new InputStreamReader(System.in));
        String id = vvodId.readLine();
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
}
