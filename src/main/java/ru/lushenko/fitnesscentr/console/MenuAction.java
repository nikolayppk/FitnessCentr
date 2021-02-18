package ru.lushenko.fitnesscentr.console;

public interface MenuAction extends Action{

    void run(Dialog dialog);

    String title();
}
