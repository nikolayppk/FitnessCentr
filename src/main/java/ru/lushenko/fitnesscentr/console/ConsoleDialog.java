package ru.lushenko.fitnesscentr.console;

import java.io.*;

public class ConsoleDialog implements Dialog {
    private final BufferedReader reader;
    private final Writer writer;

    public ConsoleDialog(BufferedReader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public ConsoleDialog(InputStream reader, OutputStream writer) {
        this(new BufferedReader(new InputStreamReader(reader)), new OutputStreamWriter(writer));
    }

    public ConsoleDialog() {
        this(System.in, System.out);
    }


    @Override
    public String ask(String question) {
        try {
            showMessage(question);
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showMessage(String text) {
        try {
            writer.write(text);
            writer.write('\n');
            writer.flush();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void exit() {
        System.exit(0);
    }
}
