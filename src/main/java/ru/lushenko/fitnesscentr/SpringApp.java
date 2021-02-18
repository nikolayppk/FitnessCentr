package ru.lushenko.fitnesscentr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lushenko.fitnesscentr.console.Menu;
import ru.lushenko.fitnesscentr.domain.*;

public class SpringApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Repository<String, Buy> buyRepository = context.getBean("buyRepository", Repository.class);
        Repository<String, TypeSubscription> typeSubscriptionRepository = context.getBean("inMemoryRepository", Repository.class);
        HardCodeFillSubscription hardCodeFillSubscription = context.getBean("hardCodeFillSubscription", HardCodeFillSubscription.class);
        Menu menu = context.getBean("menu", Menu.class);

        hardCodeFillSubscription.fill(typeSubscriptionRepository);
        menu.run();
    }
}
