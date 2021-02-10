package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;

public class CheckBuyAction implements Action {

    private String title;
    private String question;
    private Repository<String, Buy> repository;


    public CheckBuyAction(String title, String question, Repository<String, Buy> repository) {
        this.title = title;
        this.question = question;
        this.repository = repository;
    }

    @Override
    public void run() {
        checkBuy();
        System.out.println("*********************************");
    }

    @Override
    public String title() {
        return title;
    }

    /***
     * Метод для проверки ID покупки
     */
    private void checkBuy() {
        String id = new ConsoleDialog().ask(question);
        boolean checkStatus = false;
        for (Buy buy : repository.getAll()) {
            if (buy.getId().equals(id)) {
                //Считываем наименование абонемента по найденному ID
                System.out.println("Ваш абонемент - " + buy.getBuyName());
                checkStatus = true;
                break;
            }
        }
        if (checkStatus == false) {
            System.out.println("По данному ID покупка не найдена");
        }
    }
}
