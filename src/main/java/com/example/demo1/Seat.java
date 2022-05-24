package com.example.demo1;

import java.io.*;
import java.util.ArrayList;

public class Seat {
    /**
     * @author Junfeng Jin
     * @version 1.0
     * This is the class for selecting the seats.
     */
    private int row = 35, column = 6;
    private String flightNum;
    private String path;
    /**
     * This is the constructor
     */
    public Seat(String flightNum) {
        this.flightNum = flightNum;
        this.path = "src/main/resources/flightSeat/" + flightNum + ".txt";
    }

    /**
     * Find all the seats' status
     * @return Find the availability of each seat
     */
    public int[][] findSeatState() {
        int[][] state = new int[row][column];

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            int i, j = 0;

            while ((line = bufferedReader.readLine()) != null) {

                for (i = 0; i < column; i++) {
                    state[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                }

                j++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return state;

    }
    /**
     * Select the available seat
     */
    public void update(int[][] state) {
        try {
            File file = new File(path);
            file.createNewFile();
            try (FileWriter fileWriter = new FileWriter(file);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
            ) {
                for (int i = 0; i < row; i++) {
                    String content = "";
                    for (int j = 0; j < column; j++) {
                        content += state[i][j];
                    }
                    bufferedWriter.write(content + "\r\n");


                }


                bufferedWriter.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
    * Select the available seat
    */
    public void update(String selectedSeat) {
        int len = selectedSeat.length();
        String row;
        char column;
        column = selectedSeat.charAt(0);
        if (len == 2) {
            row = ""+selectedSeat.charAt(1);

        } else {
            row = String.valueOf(selectedSeat.charAt(1)) + String.valueOf(selectedSeat.charAt(2));
        }
        int row_num = Integer.parseInt(row)-1;
        int column_num=0;

        column_num = parseSeat(column);


        int[][] seat = this.findSeatState();
        seat[row_num][column_num] = 1;
        update(seat);
    }
    /**
     * Find all the remaining seats
     * @return Arraylist of remaining seats
     */
    public ArrayList<String> findRemainSeats() {
        int[][] state = new int[row][column];
        ArrayList available = new ArrayList<String>();


        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            int i, j = 0;

            while ((line = bufferedReader.readLine()) != null) {

                for (i = 0; i < column; i++) {
                    state[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if (state[j][i] == 0) {
                        String temp = parseSeat_reverse(i) + (j+1);
                        available.add(temp);
                    }
                }

                j++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return available;
    }

    /**
     * Find all the Large seats
     * @return Arraylist of Large seats
     */
    public ArrayList<String> findLargeSeats() {
        int[][] state = new int[row][column];
        ArrayList available = new ArrayList<String>();


        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            int i, j = 0;
            int line_count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (line_count >= 2) {
                    break;
                }
                line_count++;
                for (i = 0; i < column; i++) {
                    state[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if (state[j][i] == 0) {
                        String temp = parseSeat_reverse(i) + (j+1);
                        available.add(temp);
                    }
                }

                j++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return available;
    }

    /**
     * Find all the normal seats
     * @return Arraylist of normal seats
     */
    public ArrayList<String> findNormalSeats() {
        int[][] state = new int[row][column];
        ArrayList available = new ArrayList<String>();


        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line;
            int i = 0, j = 2;
            int line_count = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (line_count < 2) {
                    line_count++;
                    continue;
                }

                for (i = 0; i < column; i++) {
                    state[j][i] = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if (state[j][i] == 0) {
                        String temp = parseSeat_reverse(i) + (j+1);
                        available.add(temp);
                    }
                }

                j++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return available;
    }
    public int parseSeat(Character column) {
        return switch (column) {
            case 'A' -> 0;
            case 'B' -> 1;
            case 'C' -> 2;
            case 'D' -> 3;
            case 'E' -> 4;
            case 'F' -> 5;
            default -> 0;
        };
    }

    public String parseSeat_reverse (int i) {
        return switch (i) {
            case 0 -> "A";
            case 1 -> "B";
            case 2 -> "C";
            case 3 -> "J";
            case 4 -> "K";
            case 5 -> "L";
            default -> "";
        };
    }
}
