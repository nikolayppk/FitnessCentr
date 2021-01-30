package ru.lushenko.fitnesscentr.domain;


import java.util.Arrays;

public class HardCodeFillSubscription {
    FitnessService swimming = new FitnessService("Бассейн");
    FitnessService gym = new FitnessService("Тренажерный зал");
    FitnessService run = new FitnessService("Легкоатлетический манеж");
    FitnessService groupsTraining = new FitnessService("Групповые тренировки");
    FitnessService personalTraining = new FitnessService("Индивидуальные тренировки");

    public void fill(Repository<String, TypeSubscription> repository){
        repository.add(new TypeSubscription("1", "Премиум", 50000, Arrays.asList(swimming, gym, run, groupsTraining, personalTraining)));
        repository.add(new TypeSubscription("2", "Стандарт", 30000, Arrays.asList(swimming, gym, run, groupsTraining)));
        repository.add(new TypeSubscription("3", "Оптимум", 10000, Arrays.asList(gym, run, groupsTraining)));
    }


}
