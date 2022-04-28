package com.example.demo1;

import java.io.*;

/**
 * 保存了对乘客的操作包括对应客户信息搜索，修改餐食与座位号信息
 *csv中从左到右依次是：用户的名，用户的姓，id号，航班号，性别，booking number，座位号，餐食
 */
public class Customer {

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
    int line;//row number of customer info in csv
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
     * 这个方法是通过订单号或id number&last name查询旅客信息
     * 该方法可以将该旅客的所有信息全部缓存到对象中
     * @return 查找成功返回保存该客户信息的数组
     */
    public String[] search(){
        line = 0;
        String[] customerInformation = new String[0];
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int check = 0;//查询状态判断符，0是没搜到，1是搜完了没找到，2是找成功了
        while(check == 0){
            String oneLine = null;//初始化一个字符串存放每一行的信息
            try {
                oneLine = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(oneLine == null){
                check = 1;//找完了找不到
                System.out.println("Passenger not found");
            }else{
                customerInformation = oneLine.split(",");//把字符串通过逗号分开并检查是否为所查询信息
                if(customerInformation[5].equals(this.bookingNum)||(customerInformation[2].equals(this.idNum)&&customerInformation[1].equals(this.lastName))){
                    check = 2;
                    this.firstName = customerInformation[0];//将该用户数据存入对象
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
            return new String[]{"False"};
        }

    }
    /**
     * 参数：前端传入的餐食种类，以及利用search方法返回的乘客信息字符串数组（对象.search）
     * 该方法可以更改该旅客餐食信息
     * @return 餐食所需费用
     */
    public int ModifyMeal(String typeOfMeal,String[] customerInfo){
        //this.line=line;
        int extrafee=0;//extrafee for meal
        try {
            String tempFile = "temp.csv";
            //清空临时文件，免得往后写
            FileOperation.clearFile(tempFile);

            //打开要读取的file和要写入的temp
            File information = new File(filename);
            File temp = new File(tempFile);
            BufferedReader in = new BufferedReader(new FileReader(information));
            BufferedWriter in_w = new BufferedWriter(new FileWriter(temp));
            String str;
            //计数器，计算当前行数
            int countline=1;
            //方便你未来直接抽象出来修改其他的
            int meal = 7;
            while ((str = in.readLine()) != null) {
                //当找到所需修改的行
                if (countline == line) {
                    //string数组长度，方便遍历
                    int length =customerInfo.length;
                    //遍历数组来粘贴
                    for (int i=0;i<length;i++){
                        //当不是要修改的，直接粘贴
                        if (i!=meal){
                            in_w.write(customerInfo[i]);
                        }
                        //否则替换
                        else {
                            in_w.write(typeOfMeal);
                            if (typeOfMeal.equals("a")||typeOfMeal.equals("b")||typeOfMeal.equals("c")||typeOfMeal.equals("d"))
                            {
                                extrafee=0;
                            }
                            if (typeOfMeal.equals("e")||typeOfMeal.equals("f"))
                            {
                                extrafee=50;
                            }

                        }
                        //每个单词粘贴完后添加逗号
                        if(i!=length-1){
                            in_w.write(",");
                        }
                    }
                    //本行结束
                    in_w.write("\n");
                }
                //当不是要更改的行
                else {
                    in_w.write(str);
                    in_w.write("\n");
                }
                //下一行
                countline++;
            }
            in.close();
            in_w.close();
            FileOperation.clearFile(filename);

            FileOperation.copyFileUsingStream(temp, information);
        }
        catch (IOException e) {
            System.out.println("exception occurred"+ e);
        }

        return extrafee;

    }
    /**
     * 参数：前端传入的座位号，以及利用search方法返回的乘客信息字符串数组（对象.search）
     * 该方法可以更改该旅客座位信息
     */
    public void ModifySeatNum(String SeatNum,String[] customerInfo){
        //this.line=line;
        try {
            String tempFile = "temp.csv";
            //清空临时文件，免得往后写
            FileOperation.clearFile(tempFile);

            //打开要读取的file和要写入的temp
            File information = new File(filename);
            File temp = new File(tempFile);
            BufferedReader in = new BufferedReader(new FileReader(information));
            BufferedWriter in_w = new BufferedWriter(new FileWriter(temp));
            String str;
            //计数器，计算当前行数
            int countline=1;
            //方便你未来直接抽象出来修改其他的
            int seat = 6;//在文件中的位置
            while ((str = in.readLine()) != null) {
                //当找到所需修改的行
                if (countline == line) {
                    //string数组长度，方便遍历
                    int length =customerInfo.length;
                    //遍历数组来粘贴
                    for (int i=0;i<length;i++){
                        //当不是要修改的，直接粘贴
                        if (i!=seat){
                            in_w.write(customerInfo[i]);
                        }
                        //否则替换
                        else {
                            in_w.write(SeatNum);
                        }
                        //每个单词粘贴完后添加逗号
                        if(i!=length-1){
                            in_w.write(",");
                        }
                    }
                    //本行结束
                    in_w.write("\n");
                }
                //当不是要更改的行
                else {
                    in_w.write(str);
                    in_w.write("\n");
                }
                //下一行
                countline++;
            }
            in.close();
            in_w.close();
            FileOperation.clearFile(filename);

            FileOperation.copyFileUsingStream(temp, information);
        }
        catch (IOException e) {
            System.out.println("exception occurred"+ e);
        }

    }



}
