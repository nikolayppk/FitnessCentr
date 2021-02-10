package ru.lushenko.fitnesscentr.console;

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
        return this.actions.stream().map(Action::title).collect(Collectors.joining("\n", title, ""));
    }
}
