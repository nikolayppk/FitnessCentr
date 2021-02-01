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

    public static void main(String[] args) throws IOException {
        /*Заполняем типы абонементов*/
        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        /*Вывод главного меню*/
        showMainMenu();
        /*Ввод с клавиатуры для навигации в главном меню*/
        String position = getPrintInput();
        /*Цикл для работы в главном меню*/
        while ( !position.equals(4)) {
            boolean repeat = true;
            switch (position) {
                case "1": Action.showAllSubscription(typeSubscriptionRepository);
                    break;
                case "2":
                    System.out.println("Выбирите абонемент:");
                    Action.selectSubscriptionForBuy(typeSubscriptionRepository);
                    buySubscription(typeSubscriptionRepository);
                    break;
                case "3":
                    System.out.println("Введите ID абонемента:");
                    Action.checkBuyID(getPrintInput(), buyRepository);
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
     * Метод для выполнения покупки
     * @param repository - список абонементов
     */
    public static void buySubscription(Repository<String, TypeSubscription> repository) {
        //Вводим позицию абонемента, который хотим купить
        String position = getPrintInput();
        boolean doneBuy = false;
        for (TypeSubscription typeSubscription : repository.getAll()) {
            int kol = repository.getAll().size() + 1;
            String numberForExit = "" + kol;
            if (position.equals(numberForExit)){
                doneBuy = true;
                break;
            }
            else if (typeSubscription.getId().equals(position)) {
                Buy buy = new Buy(typeSubscription.getName(), Action.generationRandomId(5));
                /*Выполняем запись покупки*/
                buyRepository.add(buy);
                /*Отображение ID покупки*/
                System.out.println("Вы выбрали абонемент " + typeSubscription.getName() + ", ID покупки: " + buy.getId());
                doneBuy = true;
                break;
            }
        }
        if (doneBuy == false)
            System.out.println("Введенное значение отсутствует в списке. Введите корректное значение.");
    }

    /*Метод возвращает введенный текст*/
    public static String getPrintInput() {
        String valuePrint = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return valuePrint = reader.readLine();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
