package ru.lushenko.fitnesscentr.console;

public class PrintAction implements Action {

    private final String text;
    private ConsoleDialog consoleDialog;

    public PrintAction(String text, ConsoleDialog consoleDialog) {
        this.text = text;
        this.consoleDialog = consoleDialog;
    }

    public PrintAction(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        consoleDialog.printText(text);
    }

}
