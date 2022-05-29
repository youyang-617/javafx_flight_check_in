package com.example.demo1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * @author Junfeng Jin
 * @version 1.0
 * This is the class for checking the validation of the input.
 */
public class InputCheck {
    /**
     * Check the validation of the input of orderNumber
     * @param orderNumber The order number that needs to be checked
     * @return boolean: whether it is valid
     */
    public static boolean checkOrderNumber(String orderNumber) {

        Pattern pattern = Pattern.compile("\\d{6}"); //The order number can only have 6 numbers
        return pattern.matcher(orderNumber).matches();

    }
    /**
     * Check the validation of the input of input customer's name
     * @param customerName The Customer's name that needs to be checked
     * @return boolean: whether it is valid
     */
    public static boolean checkCustomerName(String customerName) {
        Pattern pattern = Pattern.compile("[A-Z]([a-z])+"); // Example Liu
        return pattern.matcher(customerName).matches();
    }

    /**
     * Check the validation of the input of input customer's id number
     * @param IDNumber The ID number that needs to be checked
     * @return boolean: whether it is valid
     */
    public static boolean checkIDNumber(String IDNumber) {
        Pattern pattern = Pattern.compile("\\d{13}"); //Chinese ID number, length is 18,which contains 17 digits and the 18th can be digits or character 'X' or 'x'
        return pattern.matcher(IDNumber).matches();
    }
    /**
     * Check the validation of the input of input customer's order number
     * @param creditcardNum The order number that needs to be checked
     * @return boolean: whether it is valid
     */
    public static boolean checkCreditCardNumber(String orderNumber) {

        Pattern pattern = Pattern.compile("\\d{16}"); //The order number can only have 6 numbers
        return pattern.matcher(orderNumber).matches();

    }
    /**
     * Check the validation of the input of input customer's password
     * @param password The password that needs to be checked
     * @return boolean: whether it is valid
     */
    public static boolean checkCreditCardPassword(String orderNumber) {

        Pattern pattern = Pattern.compile("\\d{6}"); //The order number can only have 6 numbers
        return pattern.matcher(orderNumber).matches();

    }

}
