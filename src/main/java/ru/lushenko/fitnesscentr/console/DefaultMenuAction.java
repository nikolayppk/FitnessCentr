package ru.lushenko.fitnesscentr.console;

public class DefaultMenuAction implements MenuAction {

    private final String title;
    private final Action action;
    private final int position;

    public DefaultMenuAction(String title, int position, Action action) {
        this.title = title;
        this.position = position;
        this.action = action;
    }

    @Override
    public void run() {
        this.action.run();
    }

    public int position() {
        return position;
    }

    @Override
    public String title() {
        return this.title;
    }
}
