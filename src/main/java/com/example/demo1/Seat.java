package com.example.demo1;

import java.io.*;
import java.util.ArrayList;

public class Seat {
    private int row = 35, column = 6;
    private String flightNum;
    private String path;

    public Seat(String flightNum) {
        this.flightNum = flightNum;
        this.path = "src/main/resources/flightSeat/" + flightNum + ".txt";
    }


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

        switch (column) {
            case 'A':
                column_num = 0;
                break;

            case 'B':
                column_num = 1;
                break;

            case 'C':
                column_num = 2;
                break;

            case 'D':
                column_num = 3;
                break;

            case 'E':
                column_num = 4;
                break;

            case 'F':
                column_num = 5;
                break;
        }


        int[][] seat = this.findSeatState();
        seat[row_num][column_num] = 1;
        update(seat);
    }

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
                        String temp = "";
                        switch (i) {
                            case 0:
                                temp = "A" + (j+1);
                                break;
                            case 1:
                                temp = "B" + (j+1);
                                break;
                            case 2:
                                temp = "C" + (j+1);
                                break;

                            case 3:
                                temp = "J" + (j+1);
                                break;
                            case 4:
                                temp = "K" + (j+1);
                                break;
                            case 5:
                                temp = "L" + (j+1);
                                break;
                        }
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
                        String temp = "";
                        switch (i) {
                            case 0:
                                temp = "A" + (j+1);
                                break;
                            case 1:
                                temp = "B" + (j+1);
                                break;
                            case 2:
                                temp = "C" + (j+1);
                                break;

                            case 3:
                                temp = "J" + (j+1);
                                break;
                            case 4:
                                temp = "K" + (j+1);
                                break;
                            case 5:
                                temp = "L" + (j+1);
                                break;
                        }
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
                        String temp = "";
                        switch (i) {
                            case 0:
                                temp = "A" + (j+1);
                                break;
                            case 1:
                                temp = "B" + (j+1);
                                break;
                            case 2:
                                temp = "C" + (j+1);
                                break;

                            case 3:
                                temp = "J" + (j+1);
                                break;
                            case 4:
                                temp = "K" + (j+1);
                                break;
                            case 5:
                                temp = "L" + (j+1);
                                break;
                        }
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
}
