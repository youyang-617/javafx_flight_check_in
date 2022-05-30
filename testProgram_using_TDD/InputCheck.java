import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class InputCheck {


    public static boolean checkOrderNumber(String orderNumber) {

        Pattern pattern = Pattern.compile("\\d{6}"); //The order number can only have 6 numbers
        return pattern.matcher(orderNumber).matches();

    }



    public static boolean checkCustomerName(String customerName) {
        Pattern pattern = Pattern.compile("[A-Z]([a-z])+"); // Example Liu
        return pattern.matcher(customerName).matches();
    }

    public static boolean checkIDNumber(String IDNumber) {
        Pattern pattern = Pattern.compile("\\d{13}"); //Chinese ID number, length is 18,which contains 17 digits and the 18th can be digits or character 'X' or 'x'
        return pattern.matcher(IDNumber).matches();
    }


    public static boolean checkCreditCardNumber(String creditcardNum) {

        Pattern pattern = Pattern.compile("\\d{16}"); //The order number can only have 6 numbers
        return pattern.matcher(creditcardNum).matches();

    }

    public static boolean checkCreditCardPassword(String password) {

        Pattern pattern = Pattern.compile("\\d{6}"); //The order number can only have 6 numbers
        return pattern.matcher(password).matches();

    }

}
