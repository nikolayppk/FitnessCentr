package ru.lushenko.fitnesscentr.console;

public class PrintAction implements Action{

    private final String title;
    private final String text;
    private final ConsoleDialog consoleDialog;

    public PrintAction(String title, String text, ConsoleDialog consoleDialog) {
        this.title = title;
        this.text = text;
        this.consoleDialog = consoleDialog;
    }

    @Override
    public void run() {
        consoleDialog.printText(text);
    }

    @Override
    public String title() {
        return title;
    }
}
