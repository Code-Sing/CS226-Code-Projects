import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Project05 {
    public static Scanner keyboard = new Scanner(System.in);
    public static long n;
    public static List<String> bitStrings = new ArrayList<>();

    public static void main(String[] args) {

        n = setIntegers("Value of n? (n ∈ Z+): ", 1, Integer.MAX_VALUE);
        System.out.println("User inputs are:");
        System.out.println("n = " + n);
        findBitStrings(n, "", bitStrings);
        System.out.println("All possible bit strings without 2 consecutive 0:");
        System.out.println(bitStrings);
    }

    //finds all the bit strings without 2 consecutive 0
    public static void findBitStrings(long n, String workingString, List<String> bitStrings) {
        // Stops recurrsion when the lenght of the String being built is n lenght
        if (workingString.length() == n) {
            bitStrings.add(workingString);

        } else {
            // if the string ends with 0 only add 1 and keep going
            if (workingString.endsWith("0")) {
                findBitStrings(n, workingString + "1", bitStrings);
                // If the string ends with 1 then add 1 and go down that branch, then add 0 and
                // go down that branch
            } else {
                findBitStrings(n, workingString + "1", bitStrings);
                findBitStrings(n, workingString + "0", bitStrings);
            }
        }

    }

    //Collects users data form console 
    public static long setIntegers(String prompt, long lower, long upper) {
        String temp;
        long result;
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
                System.out.println("Error: integer input is required");
            }

        } while (isNotValid);

        return result;
    }
}
