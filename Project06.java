import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Project06 {
    public static final String MSG = "Im doing Computer porject 3 chapter 6: Given a sequence of positive integers, find the longest increasing\r\n"
            + //
            "and the longest decreasing subsequence of the\r\n" + //
            "sequence.";
    public static Scanner keyboard = new Scanner(System.in);
    public static int inputNum;
    public static ArrayList<Integer> digitList = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> listOfPossibleLongestDecreasing = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> listOfPossibleLongestIncreasing = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println(MSG);
        inputNum = setIntegers("Enter a string of positive Integers. (no spaces): ", 1, Integer.MAX_VALUE);
        digitList = makeIntSet(inputNum);
        longestDecreasing(digitList);
        longestIncreasing(digitList);
        System.out.println("All possible longest decreasing subsequence: ");
        printLongest(findMax(listOfPossibleLongestDecreasing), listOfPossibleLongestDecreasing);
        System.out.println("All possible longest Increasing subsequence: ");
        printLongest(findMax(listOfPossibleLongestIncreasing), listOfPossibleLongestIncreasing);

    }

    // Collects users data form console
    public static int setIntegers(String prompt, long lower, long upper) {
        String temp;
        int result;
        boolean isNotValid;
        isNotValid = true;
        result = 0;

        do {
            System.out.print(prompt);
            temp = keyboard.nextLine();

            try {
                result = Integer.parseInt(temp);
                isNotValid = (result < lower) || (result > upper);

                if (isNotValid) {
                    System.out.println("ERROR: please enter value between " + lower + " - " + upper);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Error: integer input is required and less then 2147483648 (int max value)");
            }

        } while (isNotValid);

        return result;
    }

    // Makes the integer input into an arraylist
    public static ArrayList<Integer> makeIntSet(int inputNum) {
        ArrayList<Integer> digitList = new ArrayList<>();

        while (inputNum > 0) {
            int digit = inputNum % 10;
            digitList.add(0, digit);
            inputNum /= 10;
        }
        return digitList;
    }

    // Adds each number to a list then compares the next number in sequence and if
    // it is bigger adds it to the list. creates a new list for every possible sequence.
    public static void longestDecreasing(ArrayList<Integer> digitList) {
        ArrayList<Integer> tiralLongest = new ArrayList<>();

        // loop through each number
        for (int i = 0; i < digitList.size(); i++) {
            tiralLongest.add(digitList.get(i));
            // if the next number is bigger add to list and check next number
            for (int j = i; j < (digitList.size()) - 1; j++) {
                if (digitList.get(j) > digitList.get(j + 1)) {
                    tiralLongest.add(digitList.get(j + 1));
                    // if next number is smaller break loop
                } else {
                    break;
                }
            }

            // Deep copy list
            ArrayList<Integer> tempLongest = new ArrayList<>(tiralLongest);
            // add deep copy to list of lists
            listOfPossibleLongestDecreasing.add(tempLongest);
            // clear the looping list
            tiralLongest.clear();
        }

        // System.out.println(listOfPossibleLongestDecreasing);
    }

    // Adds each number to a list then compares the next number in sequence and if
    // it is smaller adds it to the list. creates a new list for every possible sequence.
    public static void longestIncreasing(ArrayList<Integer> digitList) {
        ArrayList<Integer> tiralLongest = new ArrayList<>();

        // loop through each number
        for (int i = 0; i < digitList.size(); i++) {
            tiralLongest.add(digitList.get(i));
            // if the next number is smaller add to list and check next number
            for (int j = i; j < (digitList.size() - 1); j++) {
                if (digitList.get(j) < digitList.get(j + 1)) {
                    tiralLongest.add(digitList.get(j + 1));
                    // if next number is bigger break loop
                } else {
                    break;
                }
            }

            // Deep copy list
            ArrayList<Integer> tempLongest = new ArrayList<>(tiralLongest);
            // add deep copy to list of lists
            listOfPossibleLongestIncreasing.add(tempLongest);
            // clear the looping list
            tiralLongest.clear();
        }

        //  System.out.println(listOfPossibleLongestIncreasing);
    }

    // Finds the longest List of the possible solutions lists
    public static int findMax(ArrayList<ArrayList<Integer>> list) {
        int tempMax = 0;
        for (int i = 0; i < list.size(); i++) {
            if (tempMax <= list.get(i).size()) {
                tempMax = list.get(i).size();
            }
        }
        return tempMax;
    }

    // Prints the longest sequence in the list of lists
    public static void printLongest(int maxLengthList, ArrayList<ArrayList<Integer>> list) {
        String solutions = "";

        System.out.println("max lenght " + maxLengthList);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() == maxLengthList) {
                solutions += list.get(i);
            }
        }
        System.out.println(solutions);
    }

}
