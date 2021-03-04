package ru.lushenko.fitnesscentr.action;

import ru.lushenko.fitnesscentr.console.Action;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;
import ru.lushenko.fitnesscentr.domain.TypeSubscription;

import java.util.Random;

public class BuyAction implements Action {
    private final TypeSubscription typeSubscription;
    private Repository<String, Buy> buyRepository;

    public BuyAction(TypeSubscription typeSubscription, Repository<String, Buy> buyRepository) {
        this.buyRepository = buyRepository;
        this.typeSubscription = typeSubscription;
    }

    @Override
    public void run(Dialog dialog) {
        buySubscription(dialog);
    }

    private void buySubscription(Dialog dialog) {
        Buy buy = new Buy(typeSubscription.getName(), generationRandomId(5));
        buyRepository.add(buy);
        dialog.showMessage("Вы выбрали абонемент " + typeSubscription.getName() + ", ID покупки: " + buy.getId());
    }

    /*Генерируем ID покупки*/
    private String generationRandomId(int length) {
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
