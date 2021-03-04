package ru.lushenko.fitnesscentr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.lushenko.fitnesscentr.action.RunApp;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;

public class SpringConsoleApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RunApp runApp = context.getBean("runApp", RunApp.class);
        ConsoleDialog consoleDialog = context.getBean("consoleDialog", ConsoleDialog.class);

        runApp.run(consoleDialog);
    }
}
