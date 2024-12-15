import java.util.Scanner;

public class Project06 {
    public static final String MSG = "Doing Coumpter Project 4 in Chapter 6: \n  Given an equation x1 + x2 +· · ·+xn = C, where C is a\r\n" + 
                "  constant, and x1, x2, . . . , xn are nonnegative integers, list\r\n" + 
                "  all the solutions.\n";
    public static Scanner keyboard = new Scanner(System.in);
    public static long n;
    public static long c;

    public static void main(String[] args) {

        System.out.println(MSG);
        n = setIntegers("Value of n? (n ∈ Z+): ", 1, Integer.MAX_VALUE);
        c = setIntegers("Value of C? (C > 0): ", 0, Integer.MAX_VALUE);

    }



    // Collects users data form console
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
