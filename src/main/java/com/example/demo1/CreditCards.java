package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Check that the card number and password entered by the user are the same as those in the txt file
 */
public class CreditCards {

    /**
     * Controller of the check-in page
     * @param cardNum the credit card number
     * @param password the password of the card
     */
    public static boolean checkCreditCards(String cardNum, String password) {
        String path = "./files/credit card.txt";

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(" ");
                if (account[0].equals(cardNum)) {
                    if (account[1].equals(password)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }
}
