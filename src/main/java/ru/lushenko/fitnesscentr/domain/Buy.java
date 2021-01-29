package ru.lushenko.fitnesscentr.domain;

import java.io.*;
import java.util.Random;

public class Buy {
    public Buy(String buyName) throws IOException {
        this.buyName = buyName;
        this.buyId = generationRandomId(5);
    }

    private String buyId;
    private String buyName;

    public String getBuyId() {
        return this.buyId;
    }
    public String getBuyName() {
        return this.buyName;
    }

    /*Генерируем ID покупки*/
    private String generationRandomId(int length) {
        String mCHAR = "0123456789";
        int strLenght = length;
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strLenght; i++) {
            int number = random.nextInt(mCHAR.length());
            char ch = mCHAR.charAt(number);
            builder.append(ch);
        }
        return builder.toString();
    }

}