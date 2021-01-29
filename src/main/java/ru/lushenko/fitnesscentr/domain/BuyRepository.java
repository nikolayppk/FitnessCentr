package ru.lushenko.fitnesscentr.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BuyRepository implements Repository<String, Buy>{

    private final File file;

    public BuyRepository(File file) {
        this.file = file;
    }

    @Override
    public Buy get(String s) {
        return null;
    }

    @Override
    public void add(Buy item) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(item.getBuyId() + "\n" + item.getBuyName() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buy> getAll() {
        return null;
    }
}
