package ru.lushenko.fitnesscentr.console;

public class BreakAction implements Action{

    private String title;

    @Override
    public void run() {
        System.exit(0);
    }

    public BreakAction(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }
}
