package ru.lushenko.fitnesscentr.console;

public class BreakAction implements Action {

    private ConsoleDialog consoleDialog;

    public BreakAction(ConsoleDialog consoleDialog) {
        this.consoleDialog = consoleDialog;
    }

    @Override
    public void run() {
        consoleDialog.exit();
    }
}
