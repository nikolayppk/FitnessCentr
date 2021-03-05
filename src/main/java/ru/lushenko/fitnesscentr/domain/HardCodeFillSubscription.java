package ru.lushenko.fitnesscentr.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HardCodeFillSubscription {
    private List<TypeSubscription> listSubscription = new ArrayList<>();
    FitnessService swimming = new FitnessService("Бассейн");
    FitnessService gym = new FitnessService("Тренажерный зал");
    FitnessService run = new FitnessService("Легкоатлетический манеж");
    FitnessService groupsTraining = new FitnessService("Групповые тренировки");
    FitnessService personalTraining = new FitnessService("Индивидуальные тренировки");

    public List<TypeSubscription> getListSubscription() {
        listSubscription.add(new TypeSubscription("1", "Премиум", 50000, Arrays.asList(swimming, gym, run, groupsTraining, personalTraining)));
        listSubscription.add(new TypeSubscription("2", "Стандарт", 30000, Arrays.asList(swimming, gym, run, groupsTraining)));
        listSubscription.add(new TypeSubscription("3", "Оптимум", 10000, Arrays.asList(gym, run, groupsTraining)));
        return listSubscription;
    }
}
