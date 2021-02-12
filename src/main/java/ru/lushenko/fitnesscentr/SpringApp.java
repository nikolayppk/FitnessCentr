package ru.lushenko.fitnesscentr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lushenko.fitnesscentr.console.Dialog;
import ru.lushenko.fitnesscentr.domain.Buy;
import ru.lushenko.fitnesscentr.domain.Repository;

public class SpringApp {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Repository <String, Buy> buyRepository = context.getBean("buyRepository", Repository.class);
        Dialog dialog = context.getBean("dialog", Dialog.class);
        dialog.ask("Как дела?");

    }
}
