package ru.lushenko.fitnesscentr.console;

public class DefaultMenuAction implements MenuAction {

    private final String title;
    private final Action action;

    public DefaultMenuAction(String title, Action action) {
        this.title = title;
        this.action = action;
    }

    @Override
    public void run() {
        this.action.run();
    }

    @Override
    public String title() {
        return this.title;
    }
}
