package ru.lushenko.fitnesscentr.console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Menu implements Action {

    private final Dialog dialog;
    private final String title;
    private final List<Action> actions;


    public Menu(Dialog dialog, String title, List<Action> actions) {
        this.dialog = dialog;
        this.title = title;
        this.actions = actions;
    }

    @Override
    public void run() {
        String answer = this.dialog.ask(question());
        int number = Integer.parseInt(answer);
        this.actions.get(number).run();
    }

    @Override
    public String title() {
        return title;
    }


    private String question() {
        return this.actions.stream().map(Action::title).collect(Collectors.joining("\n", "Выбирите действие:\n", "\n"));
    }

    public static void main(String[] args) {
        new Menu(
                new ConsoleDialog(),
                "Выбирите действие:", Arrays.asList(
                new PrintAction("Показать список абонементов", "1"),
                new PrintAction("Купить абонемент", "2"),
                new PrintAction("Проверка абонемента", "3"),
                new PrintAction("Выход", "4"
                )
        )
        );

    }
}
