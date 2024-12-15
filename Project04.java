import java.util.Scanner;

public class Project04 {
    public static boolean repeatAllowed = false;
    public static boolean orderMatter = false;
    public static Scanner keyboard = new Scanner(System.in);
    public static long n;
    public static long r;

    public static void main(String[] args) {

        n = setIntegers("Value of n? (n ∈ Z): ", 0, Integer.MAX_VALUE);
        r = setIntegers("Value of r? (0 < r <= n): ", 0, n);
        orderMatter = setBoolean("Does order matter? (Yy/Nn)", "YyNn");
        repeatAllowed = setBoolean("Is repetition allowed? (Yy/Nn)", "YyNn");

        System.out.println("User inputs are:");
        System.out.println("n = " + n);
        System.out.println("r = " + r);
        System.out.println("repetition allowed = " + repeatAllowed);
        System.out.println("order matter = " + orderMatter);

        System.out.println(calculate(repeatAllowed, orderMatter, n, r));

    }

    //Finds all the Permutations and combonations with if tree
    public static String calculate(boolean repeatAllowed, boolean orderMatter, long n, long r) {
        long result = 0;
        String resultMSG = "Number of ";
        try {
            if (orderMatter) {
                // Permutations
                resultMSG += "Permutations: ";
                if (repeatAllowed) {
                    // n^r
                    result = (long) Math.pow(n, r);
                    resultMSG += result;
                } else {
                    // n!/(n-r)!
                    result = (factorial(n) / factorial(n - r));
                    resultMSG += result;
                }
            } else {
                // Combos
                resultMSG += "Combinations: ";
                if (repeatAllowed) {
                    // (n+r+1)!/r!(n-1)!
                    result = (factorial(n + r - 1)) / (factorial(r) * factorial(n - 1));
                    resultMSG += result;
                } else {
                    // n!/r!(n-r)!
                    result = (factorial(n) / (factorial(r) * factorial((n - r))));
                    resultMSG += result;
                }
            }
        } catch (ArithmeticException big) {
            System.out.println(
                    " n or r might be to big cuz the factorial of one of them is bigger then a long can handle. Exiting");
            System.exit(0);

        }
        return resultMSG;
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

    //Collects users data form console
    public static boolean setBoolean(String prompt, String validChars) {
        String temp;
        boolean result = true;
        boolean isNotValid = true;

        // Gets input form console
        do {
            System.out.print(prompt);
            temp = keyboard.nextLine();
            try {
                // cks input if (Yy/Nn)
                isNotValid = validChars.indexOf(temp.charAt(0)) == -1;
                if (isNotValid) {
                    System.out.println("ERROR: please enter one of the following valid characters: " + validChars);
                } else {
                    System.out.println("Understood");
                }

            } catch (StringIndexOutOfBoundsException sOutOfBounds) {
                System.out.println("ERROR: input type does not match");
            }
        } while (isNotValid);

        // If Yy set returns true, if Nn set return to false
        if (temp.contains("Y") || temp.contains("y")) {
            result = true;
        } else if (temp.contains("N") || temp.contains("n")) {
            result = false;
        }

        return result;
    }

    //Math for factorial
    public static long factorial(long n) {
        long result = 1;

        for (long i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

}
