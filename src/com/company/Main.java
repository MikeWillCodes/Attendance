package com.company;

import java.util.*;

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
        double avg = calculateAverage(absences);
        System.out.println("The average of absences is: " + avg);

        System.out.println("Which student has ( ) number of absences?");
        System.out.println("Enter a number");
        userInput(absences);

        int nums = greaterThanY(absences,3,5);
        System.out.println("Numbers greater than Y add 5: " + nums);


        ArrayList<String> names = initializeNames();
        System.out.println("The names are: " + names);

        names = shuffle(names);
        System.out.println("Shuffled names: " + names);

        count = unique(absences);
        System.out.println("Number of unique absences: " + count);

        int dups = uniqueSet(absences);
        System.out.println("There are " +dups+" duplicate absences");

        ArrayList<String> anotherArray = anotherArray(20, names);
        System.out.println(anotherArray);

        checker(anotherArray);

        libShuffle(absences);
        libSort(absences);

    }
    public static boolean checker (ArrayList<String> array){
        for (int i = 0; i < array.size(); i++) {
            String name = array.get(i);
            if(array.equals(name)){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> initializeNames (){
        // create and output an arrayList of 5 distinct names
        ArrayList<String> names = new ArrayList<>();
        names.add("Michael");
        names.add("Desmond");
        names.add("Mike");
        names.add("Prince");
        names.add("Vivian");
        return names;
    }

    public static ArrayList shuffle (ArrayList<String> names){
        // shuffle the names using a user defined function
        Collections.shuffle(names);
        return names;
    }

    public static ArrayList<String> anotherArray (int size, ArrayList<String> names){
        Random random = new Random();
        ArrayList<String> anotherListOfNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
        int pick = random.nextInt(names.size());
        anotherListOfNames.add(names.get(pick));
        }
        return anotherListOfNames;
    }

    public static void greeting (){
        System.out.println(" \n Hello \n");
    }

    public static void attendanceTracker ( ArrayList<Integer> absences){
        Scanner scan = new Scanner(System.in);
        String user = scan.next();
        System.out.println(" \nHello " + user.toUpperCase());
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

    public static int unique (ArrayList<Integer> absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == i) {
                count++;
            }
        }
        return count;
    }

    public static int uniqueSet (ArrayList<Integer> absences){
        Set<Integer> abs = new HashSet<>();
        for (int i = 0; i < absences.size(); i++) {
            abs.add(absences.get(i));
        }
        int count = absences.size() - abs.size();
        return count;
    }

    public static void libShuffle(ArrayList<Integer> absences){
        for (int num : absences) {
            Collections.shuffle(absences);
        }
    }

    public static void libSort(ArrayList<Integer> absences){
        for (int num : absences) {
            Collections.sort(absences);
        }
    }
}
