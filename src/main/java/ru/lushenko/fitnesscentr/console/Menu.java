package ru.lushenko.fitnesscentr.console;

import java.util.List;

public class Menu implements Action {

    private String title;
    private final List<MenuAction> menuActions;

    public Menu(String subTitle, List<MenuAction> menuActions) {
        this.title = subTitle;
        this.menuActions = menuActions;
    }

    @Override
    public void run(Dialog dialog) {
        int number = 1;
        while (number > 0 && number <= menuActions.size()) {
            dialog.showMessage(title);
            String answer = dialog.ask(question());
            number = Integer.parseInt(answer);
            if (number == menuActions.size()) {
                break;
            } else menuActions.get(number - 1).run(dialog);
        }
    }

    private String question() {
        String viewMenu = "1" + " - " + menuActions.get(0).title();
        for (int i = 1; i < menuActions.size(); i++) {
            viewMenu = viewMenu + "\n" + (i + 1) + " - " + menuActions.get(i).title();
        }
        return viewMenu;
    }
}
