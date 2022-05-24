package com.example.demo1;

import java.io.*;

/**
 * Saved the operation of passengers
 * including searching corresponding customer information
 * modifying meal and seat number information
 * In csv,from left to right： firstName,lastName,idNum,flightNum,gender,bookingNum,seatNum,typeOfMeal
 * carryOnPkgNum,checkInPkgNum,departure,destination,date,gate
 */
public class Customer extends FileOperation{

    int money=0;
    int extrafeeMeal=0;//Cost of meal
    int extrafeeSeat=0;//Cost of seat
    String firstName;
    String lastName;
    String idNum;
    String flightNum;
    char gender;
    String bookingNum;
    String seatNum;
    String typeOfMeal;//standard or halal
    String carryOnPkgNum;
    String checkInPkgNum;
    String departure;
    String destination;
    String date;
    String gate;
    //row number of customer info in csv
    int line;
    //location of customer info
    String filename = "src/main/resources/com/example/demo1/Customer_information.csv";

    public Customer(String bookingNum) {

        this.bookingNum = bookingNum;

    }

    public Customer(String lastName, String idNum) {
        this.lastName = lastName;
        this.idNum = idNum;
    }

    /**
     * This method is to query the passenger information through the order number or ID number &amp; last name
     * This method can cache all the information of the passenger into the object
     * @return If the search is successful, return the array that saves the customer information. If not, return "False"
     */
    public String[] search(){
        line = 0;
        String[] customerInformation = new String[0];
        String[] wrongCustomer = new String[]{"False"};
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //Query status identifier,0 is not found, 1 is not found after searching, and 2 is found successfully
        int check = 0;
        while(check == 0){
            String oneLine = null;
            try {
                oneLine = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(oneLine == null){
                //not found after searching
                check = 1;
                System.out.println("Passenger not found");
            }else{
                //Separate the strings by commas and check whether they are the information queried
                customerInformation = oneLine.split(",");
                if(customerInformation[5].equals(this.bookingNum)||(customerInformation[2].equals(this.idNum)&&customerInformation[1].equals(this.lastName))){
                    check = 2;
                    //Store the user data into the object
                    this.firstName = customerInformation[0];
                    this.lastName = customerInformation[1];
                    this.idNum = customerInformation[2];
                    this.flightNum = customerInformation[3];
                    this.gender = customerInformation[4].charAt(0);
                    this.bookingNum = customerInformation[5];
                    this.seatNum = customerInformation[6];
                    this.typeOfMeal = customerInformation[7];
                    this.carryOnPkgNum = customerInformation[8];
                    this.checkInPkgNum = customerInformation[9];
                    this.departure=customerInformation[10];
                    this.destination=customerInformation[11];
                    this.date=customerInformation[12];
                    this.gate=customerInformation[13];
                    System.out.println("This is "+this.lastName+" "+ this.firstName + ". S/He has "+this.carryOnPkgNum+" carry on package and "+this.checkInPkgNum+" check-in package.");//测试代码，真用的时候删了就行
                }
                line++;
            }

        }

        if(check==2) {
            return customerInformation;
        }
        else{
            return wrongCustomer;
        }

    }
    /**
     * This method can change the meal information of the passenger
     * @param typeOfMeal Types of meals imported from the front end
     * @param customerInfo Passenger information string array returned by search method
     */
    public void ModifyMeal(String typeOfMeal,String[] customerInfo){
        try {
            String tempFile = "src/main/resources/com/example/demo1/temp.csv";
            //Empty temporary files to avoid writing later
            clearFile(tempFile);

            //Open the file to read and the temp to write
            File information = new File(filename);
            File temp = new File(tempFile);
            BufferedReader in = new BufferedReader(new FileReader(information));
            BufferedWriter in_w = new BufferedWriter(new FileWriter(temp));
            String str;
            //Counter to calculate the current number of rows
            int countline=1;
            int meal = 7;
            while ((str = in.readLine()) != null) {
                //When the row to be modified is found
                if (countline == line) {
                    //String array length, easy to traverse
                    int length =customerInfo.length;
                    //Traverse the array to paste
                    for (int i=0;i<length;i++){
                        //When it is not to be modified, paste it directly
                        if (i!=meal){
                            in_w.write(customerInfo[i]);
                        }
                        //Otherwise replace
                        else {
                            in_w.write(typeOfMeal);


                        }
                        //Add a comma after pasting each word
                        if(i!=length-1){
                            in_w.write(",");
                        }
                    }
                    //End of the row
                    in_w.write("\n");
                }
                //When not the row to change
                else {
                    in_w.write(str);
                    in_w.write("\n");
                }
                //next row
                countline++;
            }
            in.close();
            in_w.close();
            clearFile(filename);

            copyFileUsingStream(temp, information);
        }
        catch (IOException e) {
            System.out.println("exception occurred"+ e);
        }

    }
    /**
     * This method can change the seat information of the passenger
     * @return Type of meal
     */
    public String getTypeOfMeal() {
        return typeOfMeal;
    }
    /**
     * This method can change the seat information of the passenger
     * @return Extrafee of meal
     */
    public int getExtrafeeMeal() {
        return extrafeeMeal;
    }
    /**
     * This method can change the seat information of the passenger
     * @return Extrafee of seat
     */
    public int getExtrafeeSeat() {
        return extrafeeSeat;
    }

    /**
     * This method can change the seat information of the passenger
     * @return Seat number
     */
    public String getSeatNum() {
        return seatNum;
    }

    /**
     * This method can change the seat information of the passenger
     * @param SeatNum Types of meals imported from the front end
     * @param customerInfo Passenger information string array returned by search method
     */
    public void ModifySeatNum(String SeatNum,String[] customerInfo){
        //this.line=line;
        try {
            String tempFile = "temp.csv";
            //Empty temporary files to avoid writing later
          clearFile(tempFile);

            //Open the file to read and the temp to write
            File information = new File(filename);
            File temp = new File(tempFile);
            BufferedReader in = new BufferedReader(new FileReader(information));
            BufferedWriter in_w = new BufferedWriter(new FileWriter(temp));
            String str;
            //Counter to calculate the current number of rows
            int countline=1;
            //Location in file
            int seat = 6;
            while ((str = in.readLine()) != null) {
                //When the row to be modified is found
                if (countline == line) {
                    //String array length, easy to traverse
                    int length =customerInfo.length;
                    //Traverse the array to paste
                    for (int i=0;i<length;i++){
                        //When it is not to be modified, paste it directly
                        if (i!=seat){
                            in_w.write(customerInfo[i]);
                        }
                        //Otherwise replace
                        else {
                            in_w.write(SeatNum);

                        }
                        //Add a comma after pasting each word
                        if(i!=length-1){
                            in_w.write(",");
                        }
                    }
                    //End of the row
                    in_w.write("\n");
                }
                //When not the row to change
                else {
                    in_w.write(str);
                    in_w.write("\n");
                }
                //next row
                countline++;
            }
            in.close();
            in_w.close();
            clearFile(filename);

            copyFileUsingStream(temp, information);
        }
        catch (IOException e) {
            System.out.println("exception occurred"+ e);
        }

    }
    /**
     * This method can calculate the cost of extra service for meal and seat
     * @return extra fee for this flight
     */
    public int getMoney() {
        if (typeOfMeal.equals("E")||typeOfMeal.equals("F"))
        {
            extrafeeMeal=50;
        }
        if (seatNum.equals("J1")||seatNum.equals("J2"))
        {
            extrafeeSeat=323;
        }

        money=extrafeeMeal+extrafeeSeat;
        System.out.println(money);
        return money;
    }



}
