package ru.lushenko.fitnesscentr.console;

public class PrintAction implements Action{

    private final String title;
    private final String text;

    public PrintAction(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public void run() {
        System.out.println(text);
    }

    @Override
    public String title() {
        return title;
    }
}
