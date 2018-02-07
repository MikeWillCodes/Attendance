package com.company;

import java.util.*;

public class Main {

    public static final int FINAL_SIZE = 10;

    public static void main(String[] args) {
        //Driver
        greeting();

        ArrayList<Integer> absences = new ArrayList<>();
        initialize(FINAL_SIZE, absences);

        attendanceTracker();
        System.out.println("The elements are: " + absences);


        perfectAttendance(absences);
        int count = perfectAttendance(absences);
        System.out.println(count + " student(s) had perfect attendance");

        calculateAverage(absences);
        double avg = calculateAverage(absences);
        System.out.println("The average of absences is: " + avg);

        System.out.println("Which student has ( ) number of absences?");
        System.out.println("Enter a number");
        userInput(absences);

        int nums = greaterThanY(absences,3,5);
        System.out.println("Numbers greater than Y add 5: " + nums);

        int dups = uniqueSet(absences);
        System.out.println("There are " +dups+" duplicate absences");

        ArrayList<Integer> shuffle = libShuffle(absences);
        System.out.println("The shuffle: " + shuffle );

        userDefinedShuffle(FINAL_SIZE, absences);

        ArrayList<Integer> sort = libSort(absences);
        System.out.println("The sort: " + sort);

    }

    public static void greeting (){
        System.out.println(" \n Hello \n");
    }

    public static void attendanceTracker (){
        Scanner scan = new Scanner(System.in);
        String user = scan.next();
        System.out.println(" \nHello " + user.toUpperCase());
    }

    public static ArrayList<Integer> initialize (int size, ArrayList<Integer> absences){
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(11);
            absences.add(num);
        }
        return absences;
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
    public static double calculateAverage (ArrayList<Integer> absences){
       int sum = calculateSum(absences);
       double avg = 0;
        for (int i = 0; i < absences.size(); i++) {
            avg = (double) sum / absences.size();
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
                System.out.print("");

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

    public static int uniqueSet (ArrayList<Integer> absences){
        Set<Integer> abs = new HashSet<>();
        for (int i = 0; i < absences.size(); i++) {
            abs.add(absences.get(i));
        }
        int count = absences.size() - abs.size();
        return count;
    }

    public static ArrayList<Integer> libShuffle(ArrayList<Integer> absences){
            Collections.shuffle(absences);
            return absences;
    }

    public static void userDefinedShuffle( int size, ArrayList<Integer> absences){
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int shuffle = rand.nextInt(absences.size());
            int temp = absences.get(shuffle);
            absences.set(shuffle, absences.get(i));
            absences.set(absences.get(i), temp);
        }
    }

    public static ArrayList<Integer> libSort(ArrayList<Integer> absences){
            Collections.sort(absences);
            return absences;
    }
}
