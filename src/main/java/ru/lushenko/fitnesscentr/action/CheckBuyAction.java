package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;

public class CheckBuyAction implements Action {

    private Repository<String, Buy> buyRepository;

    public CheckBuyAction(Repository<String, Buy> repository) {
        this.buyRepository = repository;
    }

    @Override
    public void run(Dialog dialog) {
        String id = dialog.ask("Введите ID покупки:");
        checkBuy(id, dialog);
    }

    /***
     * Метод для проверки покупки
     * @param id - id покупки по которой ищем запись
     */
    private void checkBuy(String id, Dialog dialog) {
        if (buyRepository.get(id) != null)
            dialog.showMessage("Ваш абонемент - " + buyRepository.get(id).getBuyName());
        else dialog.showMessage("По данному ID покупка не найдена");
    }
}
