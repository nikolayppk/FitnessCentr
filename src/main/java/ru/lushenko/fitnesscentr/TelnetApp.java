package ru.lushenko.fitnesscentr;

import ru.lushenko.fitnesscentr.action.RunApp;
import ru.lushenko.fitnesscentr.console.ConsoleDialog;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TelnetApp {

    public void run(RunApp app) {
        try (ServerSocket server = new ServerSocket(8022)) {
            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println(socket.getRemoteSocketAddress());
                    app.run(new ConsoleDialog(socket.getInputStream(), socket.getOutputStream()));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        new TelnetApp().run(new RunApp());
    }


}
