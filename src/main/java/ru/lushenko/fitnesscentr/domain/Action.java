package ru.lushenko.fitnesscentr.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
}
