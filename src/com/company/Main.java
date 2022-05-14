package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String path = sc.nextLine();
//        int maxNumber = sc.nextInt();
        String path = "C:\\Users\\Артур\\Desktop\\test";
        int maxNumber = 500;
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path + "\\data.csv"));
            File file = new File(path + "\\data1.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\data1.csv"));
            int a = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                System.out.println(values[0] + " " + values[1] + " " + values[2] + " " + values[3] + " " + values[4] + " " + values[5] + " " + values[6]);
                if (a == 0) {
                    bw.write(values[0] + ";" + values[1] + ";" + values[2] + ";" + values[3] + ";" + values[4] + ";" + values[5] + ";" + values[6] + "\n");
                }
                if (a > 0) {
                    if (Integer.parseInt(values[2]) > maxNumber || (Integer.parseInt(values[3]) + Integer.parseInt(values[4])) > maxNumber || (Integer.parseInt(values[5]) + Integer.parseInt(values[6])) > maxNumber) {
                        bw.write(values[0] + ";" + values[1] + ";" + values[2] + ";" + values[3] + ";" + values[4] + ";" + values[5] + ";" + values[6] + "\n");
                    }
                }
                a++;
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
