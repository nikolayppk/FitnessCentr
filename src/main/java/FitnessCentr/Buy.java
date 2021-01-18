package FitnessCentr;

import java.io.*;
import java.util.Random;

public class Buy {
    Buy(String buyName) throws IOException {
        this.buyName = buyName;
        this.buyID = generationRandomId(5);

//        FileWriter writer = new FileWriter("notes3.txt", true);
//        writer.write(this.buyID + "\n");
//        writer.close();
    }

    private String buyID;
    private String buyName;


    public String getBuyID() {
        return this.buyID;
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