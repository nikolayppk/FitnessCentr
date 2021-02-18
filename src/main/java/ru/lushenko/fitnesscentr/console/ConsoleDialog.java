package ru.lushenko.fitnesscentr.console;

import java.io.*;

public class ConsoleDialog implements Dialog {

    @Override
    public String ask(String question) {
        try {
            System.out.println(question);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void showMessage(String text) {
        System.out.println(text);
    }

    public void exit() {
        System.exit(0);
    }
}
