package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;

public class CheckBuyAction implements Action {

    private String question;
    private Repository<String, Buy> repository;
    private ConsoleDialog consoleDialog;


    public CheckBuyAction(String question, Repository<String, Buy> repository, ConsoleDialog consoleDialog) {
        this.question = question;
        this.repository = repository;
        this.consoleDialog = consoleDialog;
    }

    @Override
    public void run() {
        checkBuy();
        consoleDialog.printText("*********************************");
    }

    /***
     * Метод для проверки ID покупки
     */
    private void checkBuy() {
        String id = consoleDialog.ask(question);
        boolean checkStatus = false;
        for (Buy buy : repository.getAll()) {
            if (buy.getId().equals(id)) {
                //Считываем наименование абонемента по найденному ID
                consoleDialog.printText("Ваш абонемент - " + buy.getBuyName());
                checkStatus = true;
                break;
            }
        }
        if (checkStatus == false) {
            consoleDialog.printText("По данному ID покупка не найдена");
        }
    }
}
