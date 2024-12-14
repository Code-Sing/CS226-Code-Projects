import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project02 {
    public static ArrayList<String> testA = new ArrayList<>();
    public static ArrayList<String> testB = new ArrayList<>();
    public static ArrayList<String> setA = new ArrayList<>();
    public static ArrayList<String> setB = new ArrayList<>();
    public static ArrayList<String> bigList = new ArrayList<>();
    public static ArrayList<String> smallList = new ArrayList<>();

    public static void main(String[] args) {

        try {
            File file = new File("/workspaces/CS226-Code-Projects/project02file.txt"); 
            Scanner scanner = new Scanner(file);

                String lineA = scanner.nextLine();
                System.out.println("1st set:" + lineA);
                
                for (char c : lineA.toCharArray()) {
                    setA.add(String.valueOf(c)); // Convert char to String and add to list
                }
                String lineB = scanner.nextLine();
                System.out.println("2nd set:" + lineB);

                for (char c : lineB.toCharArray()) {
                    setB.add(String.valueOf(c)); // Convert char to String and add to list

            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    
        testA.add("2");
        testA.add("3");
        testA.add("a");
        testA.add("a");
        testA.add("b");

        testB.add("1");
        testB.add("1");
        testB.add("2");
        testB.add("2");
        testB.add("3");
        testB.add("b");
        testB.add("c");

        setSizeFinder(setA, setB);
        // System.out.println("test sets");
        System.out.println("Union Set: " + setUnionOperation(bigList, smallList));
        System.out.println("Intersection Set: " + setIntersectionOperation(bigList,
        smallList));
        System.out.println("Product Set: " + setProductOperation(testA, testB));
        System.out.println("Symmetric DifferenceSet: " +
        setSymmetricDifferenceOperation(bigList, smallList));
        System.out.println(powerSet(testB));
        
    }

    // UNION
    public static ArrayList<String> setUnionOperation(ArrayList<String> bigList, ArrayList<String> smallList) {
        ArrayList<String> unoinSet = new ArrayList<>();
        // int bigListSize = Math.max(setA.size(),setB.size());

        // Adds any missing elements form the bigger set, skips duplicate elements
        for (int i = 0; i < bigList.size(); i++) {
            if (!unoinSet.contains(bigList.get(i))) {
                unoinSet.add(bigList.get(i));
            }
        }

        // Adds any missing elements form the smaller set, skips duplicate elements
        for (int i = 0; i < smallList.size(); i++) {
            if (!unoinSet.contains(smallList.get(i))) {
                unoinSet.add(smallList.get(i));
            }
        }

        // Sorts the list
        Collections.sort(unoinSet);

        return unoinSet;
    }

    // INTERSECTION
    public static ArrayList<String> setIntersectionOperation(ArrayList<String> bigList, ArrayList<String> smallList) {
        ArrayList<String> intersecttionSet = new ArrayList<>();

        // Compares every element of the smaller list to the bigger list to find all
        // elements that both list have
        for (int i = 0; i < smallList.size(); i++) {
            for (int j = 0; j < bigList.size(); j++) {
                // Checks for duplicate elements already in intersection list
                if (!intersecttionSet.contains(bigList.get(j))) {
                    // Compares elements if 0 adds to intersection list
                    if (bigList.get(j).compareTo(smallList.get(i)) == 0) {
                        intersecttionSet.add(bigList.get(j));
                    }
                }
            }
        }

        // Sorts the list
        Collections.sort(intersecttionSet);
        return intersecttionSet;
    }

    // PRODUCT
    public static ArrayList<String> setProductOperation(ArrayList<String> setA, ArrayList<String> setB) {
        ArrayList<String> productSet = new ArrayList<>();
        String newElement = "";

        // Concatenates a String with the product of ea element of ea list
        for (int i = 0; i < setB.size(); i++) {
            for (int j = 0; j < setA.size(); j++) {
                newElement = "(" + setA.get(j) + "," + setB.get(i) + ")";
                // checks for duplicate elements
                if (!productSet.contains(newElement)) {
                    productSet.add(newElement);
                }
            }
        }

        Collections.sort(productSet);

        return productSet;
    }

    // Symmetric difference
    public static ArrayList<String> setSymmetricDifferenceOperation(ArrayList<String> bigList,
            ArrayList<String> smallList) {
        ArrayList<String> symmetricDifferenceSet = new ArrayList<>();

        // Cks if elements in small list is in biglist and if not add to new set
        for (int i = 0; i < smallList.size(); i++) {
            // Checks for duplicate elements already in intersection list
            if (!symmetricDifferenceSet.contains(smallList.get(i))) {
                // Compares elements if 0 adds to intersection list
                if (!bigList.contains(smallList.get(i))) {
                    symmetricDifferenceSet.add(smallList.get(i));
                }
            }

        }
        // Cks if elements in bigger list is in samlllist and if not add to new set
        for (int i = 0; i < bigList.size(); i++) {
            // Checks for duplicate elements already in intersection list
            if (!symmetricDifferenceSet.contains(bigList.get(i))) {
                // Compares elements if 0 adds to intersection list
                if (!smallList.contains(bigList.get(i))) {
                    symmetricDifferenceSet.add(bigList.get(i));
                }
            }

        }

        // Sorts the list
        Collections.sort(symmetricDifferenceSet);
        return symmetricDifferenceSet;

    }

    public static String powerSet(ArrayList<String> setA) {
        List<List<Object>> powerSet = new ArrayList<>();
        String output = "";

        // removing duplicates (wish i knew of this before)
        List<Object> uniqueList = new ArrayList<>(new LinkedHashSet<>(setA));

        // Find max number of subsets

        int numSubsets = (int) Math.pow(2, uniqueList.size());
        for (int i = 0; i < numSubsets; i++) {
            List<Object> subset = new ArrayList<>();
            for (int j = 0; j < uniqueList.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(uniqueList.get(j));
                }
            }
            powerSet.add(subset);
        }

        output = "Power set:{";
        for (List<Object> subset : powerSet) {
            output += subset + ",";
        }
        output += "}";
        return output;
    }


    public static int compareValue(int a, int b) {
        if (a == b) {
            return 0;
        } else {
            return a - b;
        }
    }

    public static void setSizeFinder(ArrayList<String> setA, ArrayList<String> setB) {
        // Finds the small list and big list to get the loop count and avoid null value
        // cases
        if (compareValue(setA.size(), setB.size()) >= 0) {
            bigList = setA;
            smallList = setB;
        } else {
            bigList = setB;
            smallList = setA;
        }

    }
}
