package ru.lushenko.fitnesscentr.domain;

import java.util.Random;

public class Action {

    /***
     * Метод отображает отображает подробную информацию имеющихся абонементов
     * @param repository - список абонементов*/
    public static void showAllSubscription(Repository<String, TypeSubscription> repository){
        for (TypeSubscription typeSubscription : repository.getAll())
            typeSubscription.printDescriptorSubscription();
    }

    /***
     * Метод для выбора абонемента при покупке
     * @param repository - список абонементов*/
    public static void selectSubscriptionForBuy(Repository<String,TypeSubscription> repository){
        for (TypeSubscription typeSubscription : repository.getAll()) {
            System.out.println("[" + typeSubscription.getId() + "] " + typeSubscription.getName());
        }
        int a = repository.getAll().size() + 1;
        System.out.println("[" + a + "] Назад" );
    }

    /***
     * Метод для проверки ID покупки
     * @param id - ID покупки
     * @param repository - репозиторий с покупками
     */
    public static void checkBuyID(String id, Repository<String, Buy> repository) {
        boolean checkStatus = false;
        for (Buy buy : repository.getAll()){
            if (buy.getId().equals(id)){
                //Считываем наименование абонемента по найденному ID
                System.out.println("Ваш абонемент " + buy.getBuyName());
                checkStatus = true;
                break;
            }
        }
        if (checkStatus == false){
            System.out.println("По данному ID покупка не найдена");
        }
    }

    /*Генерируем ID покупки*/
    public static String generationRandomId(int length) {
        String mCHAR = "0123456789";
        int strLength = length;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }
}
