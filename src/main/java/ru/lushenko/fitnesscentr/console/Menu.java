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
            if (number == menuActions.size() + 1) {
                break;
            } else menuActions.get(number - 1).run(dialog);
        }
    }

    private String question() {
        StringBuilder menuItem = new StringBuilder();
        for (int i = 0; i < menuActions.size(); i++) {
            menuItem.append((i + 1)).append("-").append(menuActions.get(i).title()).append("\n");
        }
        return menuItem.append(menuActions.size() + 1).append("-").append("Выход").toString();
    }
}
