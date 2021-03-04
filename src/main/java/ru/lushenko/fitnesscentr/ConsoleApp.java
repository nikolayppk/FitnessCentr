package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.RunApp;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;

public class ConsoleApp {
    public static void main(String[] args) {
        new RunApp().run(new ConsoleDialog());
    }
}
