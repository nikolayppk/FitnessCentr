package ru.lushenko.fitnesscentr.domain;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyRepository implements Repository<String, Buy>{

    private final File file;

    public BuyRepository(File file) {
        this.file = file;
    }
    private final Map<String, Buy> items = new HashMap<>();

    @Override
    public Buy get(String s) {

        return null;
    }

    @Override
    public void add(Buy item) {
        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(item.getId() + "\n" + item.getBuyName() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Buy> getAll() {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            // первая строчка ID покупки
            String idBuy = reader.readLine();
            // вторая строчка наименование покупки
            String nameBuy = reader.readLine();
            boolean checkStatus = false;
            while (nameBuy != null) {
                Buy buy = new Buy(nameBuy, idBuy);
                this.items.put(buy.getId(), buy);
                idBuy = reader.readLine();
                nameBuy = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(this.items.values());
    }
}
