package com.company;

import java.util.*;

public class Main {

    public static final int MAX_SIZE = 20;
    public static final int FE_NUM = 7;

    public static void main(String[] args) {

        greeting();

        ArrayList<Integer> absences = new ArrayList<>();
        initialize(MAX_SIZE, absences);

        attendanceTracker();
        System.out.println("The elements are: " + absences);


        perfectAttendance(absences);
        int count = perfectAttendance(absences);
        System.out.println(count + " student(s) had perfect attendance");

        calculateAverage(absences);
        double avg = calculateAverage(absences);
        System.out.println("The average of absences is: " + avg);

        ArrayList<Integer> index = indexMatch(absences, 3);
        System.out.println("These indexes [ " + index + " ] have x number of absences");

        double fewerThanThree = fewerThan(absences, 3);
        System.out.println("The percentage of students who had less than 3 absences but also had perfect attendance: " + fewerThanThree);

        greaterThanY(absences, 3, 5);

        int dups = uniqueSet(absences);
        System.out.println("There are " + dups + " duplicate absences");

        ArrayList<Integer> shuffle = libShuffle(absences);
        System.out.println("The shuffle: " + shuffle);

        userDefinedShuffle(MAX_SIZE, absences);
        userDefinedSort(absences);
        ArrayList<Integer> sort = libSort(absences);
        System.out.println("The sort: " + sort);


        ArrayList<String> names = initializeNames();
        System.out.println("The names are: " + names);

        names = shuffle(names);
        System.out.println("Shuffled names: " + names);

        ArrayList<String> anotherArray = anotherArray(MAX_SIZE, names);
        System.out.println("List of dups: " + anotherArray);

        boolean check = checker(anotherArray, names);
        System.out.println(check);

        ArrayList<String> perfAttend = perfectAttendance(absences, anotherArray);
        System.out.println("Students with perfect attendance: " + perfAttend);

        ArrayList<Integer> abFE = absencesFE(absences, FE_NUM);
        System.out.println("The indexes of students wo fe'd: " + abFE);

        avg = feAverage(absences, FE_NUM);
        System.out.println("The average of students who FE'd " + avg);

        avg = didNotFEAvg(absences, FE_NUM);
        System.out.println("The average of students who did not FE " + avg);

        ArrayList<String> failedOut = namesFE(absences, anotherArray);
        System.out.println("Students who failed out: " + failedOut);

       Map eachAbsenceMap = eachAbsence(absences);
       System.out.println("Each absence map: " + eachAbsenceMap);

//        int count = numOfCourses("Mike", anotherArray);
//        System.out.println("Courses: " + count);

    }

    public static Map eachAbsence (ArrayList<Integer> absences) {
        // How many of each absence?
        Map<Integer, Integer> eachAbsenceMap = new HashMap<>();
        for (int key : absences) {
            if (!eachAbsenceMap.containsKey(key)) {
                eachAbsenceMap.put(key, 1);
            } else {
                int value = eachAbsenceMap.get(key) + 1;
                eachAbsenceMap.put(key, value);
            }
        }
        return eachAbsenceMap;
    }

    public static void greeting() {
        System.out.println(" \n Hello \n");
    }

    public static void attendanceTracker() {
        Scanner scan = new Scanner(System.in);
        String user = scan.next();
        System.out.println(" \nHello " + user.toUpperCase());
    }

    public static ArrayList<Integer> initialize(int size, ArrayList<Integer> absences) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int num = rand.nextInt(11);
            absences.add(num);
        }
        return absences;
    }

    // count how many students had perfect attendance
    public static int perfectAttendance(ArrayList<Integer> absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) == 0) {
                count = count + 1;
            }
        }
        return count;
    }

    public static int calculateSum(ArrayList<Integer> absences) {
        int sum = 0;
        for (int i = 0; i < absences.size(); i++) {
            sum = sum + absences.get(i);
        }
        return sum;
    }

    // calculate the average
    public static double calculateAverage(ArrayList<Integer> absences) {
        int sum = calculateSum(absences);
        double avg = 0;
        for (int i = 0; i < absences.size(); i++) {
            avg = (double) sum / absences.size();
        }
        return avg;
    }

    // which student had x number of absences
    public static ArrayList<Integer> indexMatch(ArrayList<Integer> absences, int num) {
        ArrayList<Integer> index = new ArrayList<>();
        for (int i = 0; i < absences.size(); i++) {
            if (num == absences.get(i)) {
                num = i;
                index.add(num);
            }
        }
        return index;
    }

    //What is the average of students who had fewer than 3 absences also had perfect attendance
    public static double fewerThan(ArrayList<Integer> absences, int num) {
        int perfect = perfectAttendance(absences);
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < num)
                count++;
        }
        return (double) perfect / count;
    }

    public static void greaterThanY(ArrayList<Integer> absences, int x, int y) {
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) > y) {
                int num = absences.get(i) + x;
                if (num > 15){
                    num = 15;
                }
                if (num < 0){
                    num = 0;
                }
                absences.set(i, num);
            }
        }
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
            absences.set(i, temp);
        }
    }

    public static void userDefinedSort ( ArrayList<Integer> absences){
        for (int i = 0; i < absences.size(); i++) {
            for (int j = 0; j < absences.size() ; j++) {
                if( absences.get(i) > absences.get(j)){
                    int temp = absences.get(i);
                    absences.set(i, absences.get(j));
                    absences.set(j, temp);
                }
            }
        }
    }

    public static ArrayList<Integer> libSort(ArrayList<Integer> absences){
        Collections.sort(absences);
        return absences;
    }


    public static ArrayList<Integer> absences(int size) {
        Random rand = new Random();
        ArrayList<Integer> absences = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            absences.add(rand.nextInt(10));
        }
        return absences;
    }

    public static boolean checker(ArrayList<String> anotherArray, ArrayList<String> names) {
        for (int i = 0; i < anotherArray.size(); i++) {
            if (anotherArray.contains(names.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<String> initializeNames() {
        // create and output an arrayList of 5 distinct names
        ArrayList<String> names = new ArrayList<>();
        names.add("Michael");
        names.add("Desmond");
        names.add("Mike");
        names.add("Prince");
        names.add("Vivian");
        return names;
    }

    public static ArrayList shuffle(ArrayList<String> names) {
        // shuffle the names using a user defined function
        Collections.shuffle(names);
        return names;
    }

    public static ArrayList<String> anotherArray(int size, ArrayList<String> names) {
        Random random = new Random();
        ArrayList<String> anotherListOfNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int pick = random.nextInt(names.size());
            anotherListOfNames.add(names.get(pick));
        }
        return anotherListOfNames;
    }

    public static ArrayList<String> perfectAttendance(ArrayList<Integer> absences, ArrayList<String> names) {
        ArrayList<String> namesWithPerfectAttendance = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (absences.get(i) == 0) {
                namesWithPerfectAttendance.add(names.get(i));
            }
        }
        return namesWithPerfectAttendance;
    }

    public static ArrayList<Integer> absencesFE(ArrayList<Integer> absences, int num){
        ArrayList<Integer> feIndexes = new ArrayList<>();
        for (int i = 0; i < absences.size() ; i++) {
            if (absences.get(i) > num){
                feIndexes.add(i);
            }
        }
        return feIndexes;
    }

    public static double feAverage (ArrayList<Integer> absences, int num){
        ArrayList<Integer> students = absencesFE(absences,num);
        double avg = (double) students.size() / absences.size();
        return avg;
    }

    public static ArrayList<Integer> didNotFE (ArrayList<Integer> absences, int num){
        ArrayList<Integer> kids = new ArrayList<>();
        for (int i = 0; i <absences.size() ; i++) {
            if (absences.get(i) < num){
                kids.add(i);
            }
        }
        return kids;
    }

    public static double didNotFEAvg (ArrayList<Integer> absences, int num){
        ArrayList<Integer> ppl = didNotFE(absences,num);
        double avg = (double) ppl.size() / absences.size();
        return avg;
    }

    public static ArrayList<String> namesFE(ArrayList<Integer> absences, ArrayList<String> names) {
        ArrayList<String> namesThatFe = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            if (absences.get(i) >= 6) {
                namesThatFe.add(names.get(i));
            }
        }
        return namesThatFe;
    }

//    public static int numOfCourses (String name, ArrayList<String> names){
//        int count = 0;
//        for (int i = 0; i < names.size(); i++) {
//            if (names.get(i) == name)
//            count++;
//        }
//        return count;
//    }

}

