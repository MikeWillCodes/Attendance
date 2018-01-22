package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Driver
        greeting();

        ArrayList<Integer> absences = new ArrayList<>();

        attendanceTracker(absences);
        System.out.println("The elements are: " + absences);

        perfectAttendance(absences);
        int count = perfectAttendance(absences);
        System.out.println(count + " student(s) had perfect attendance");

        calculateAverage(absences);
        int avg = calculateAverage(absences);
        System.out.println("The average of absences is: " + avg);

        System.out.println("Which student has ( ) number of absences?");
        System.out.println("Enter a number");
        userInput(absences);

        int nums = greaterThanY(absences,3,5);
        System.out.println("Numbers greater than Y add 5: " + nums);

        count = unique(absences);
        System.out.println("Number of unique absences: " + count);


    }

    public static void greeting (){
        System.out.println(" \n Hello \n");
    }

    public static void attendanceTracker ( ArrayList<Integer> absences){
        Scanner scan = new Scanner(System.in);
        String user = scan.next();
        System.out.println(" \n Hello " + user.toUpperCase());
        Random rand = new Random();
        for (int i = 0; i < user.length(); i++) {
            int num = rand.nextInt(11);
            absences.add(num);
        }
    }
    // count how many students had perfect attendance
    public static int perfectAttendance (ArrayList<Integer> absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
                count = count + 1;
            }
        }
        return count;
    }
    public static int calculateSum(ArrayList<Integer> absences){
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = sum + absences.get(i);
        }
        return sum;
    }

    // calculate the average
    public static int calculateAverage (ArrayList<Integer> absences){
       int sum = calculateSum(absences);
       int avg = 0;
        for (int i = 0; i < absences.size(); i++) {
            avg = sum / absences.size();
        }
        return avg;
    }

    // which student had x number of absences
    public static int userInput (ArrayList<Integer> absences){
        Scanner scan2 = new Scanner(System.in);
        int input = scan2.nextInt();
        for (int i = 0; i < absences.size(); i++) {
            if (input == absences.get(i)) {
                System.out.println("Index(es) [" + i + "] has that number of absences");
            }
            else
                System.out.println(" ");

        }
        return input;
    }

    public static int greaterThanY (ArrayList<Integer> absences, int x, int y){
        int nums = 0;
        for (int i = 0; i < absences.size(); i++) {
            if(absences.get(i) > y) {
                nums = absences.get(i) + x;
                if (nums > 15)
                    nums = 15;
            }


        }
        return nums;
    }


    public static int unique (ArrayList<Integer> absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == i) {
                count++;
            }
        }
        return count;
    }
}
