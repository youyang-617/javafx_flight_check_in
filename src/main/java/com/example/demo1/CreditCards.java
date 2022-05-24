package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreditCards {

    public static boolean checkCreditCards(String cardNum, String password) {
        String path = "src/main/resources/com/example/demo1/creditcard/credit card.txt";

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(" ");
                if (account[0].equals(cardNum)) {
                    if (account[1].equals(password)) return true;
                    else return false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }
}
