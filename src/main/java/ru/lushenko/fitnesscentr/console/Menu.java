package ru.lushenko.fitnesscentr.console;

import java.util.List;

public class Menu implements Action {

    private final Dialog dialog;
    private final List<DefaultMenuAction> menuActions;

    public Menu(Dialog dialog, List<DefaultMenuAction> menuActions) {
        this.dialog = dialog;
        this.menuActions = menuActions;
    }

    @Override
    public void run() {
        while (true) {
            String answer = this.dialog.ask(question());
            int number = Integer.parseInt(answer);
            this.menuActions.get(number - 1).run();
        }
    }

    private String question() {
        String viewMenu = menuActions.get(0).position() + " - " + menuActions.get(0).title();
        for (int i = 1; i < menuActions.size(); i++) {
            viewMenu = viewMenu + "\n" + menuActions.get(i).position() + " - " + menuActions.get(i).title();
        }
        return viewMenu;
    }
}
