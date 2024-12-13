import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Project02 {
    public static ArrayList<String> testA = new ArrayList<>();
    public static ArrayList<String> testB = new ArrayList<>();
    public static ArrayList<String> bigList = new ArrayList<>();
    public static ArrayList<String> smallList = new ArrayList<>();

    public static void main(String[] args) {
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

        setSizeFinder(testA, testB);
        System.out.println(setUnionOperation(testB, testA));
        
    }

    public static ArrayList<String> setUnionOperation(ArrayList<String> bigList,  ArrayList<String> smallList){
        ArrayList<String> unoinSet = new ArrayList<>();
        // int bigListSize = Math.max(setA.size(),setB.size());

        //Adds any missing elements form the bigger set, skips duplicate elements 
        for(int i = 0; i < bigList.size(); i++){
            if(! unoinSet.contains(bigList.get(i))){
                unoinSet.add(bigList.get(i));
            }
        }
        
        //Adds any missing elements form the smaller set, skips duplicate elements 
        for(int i = 0; i < smallList.size(); i++){
            if(! unoinSet.contains(smallList.get(i))){
                unoinSet.add(smallList.get(i));
            }
        }

        //Sorts the list
        Collections.sort(unoinSet);

        return unoinSet;
    }

    // public static ArrayList<String> setIntersectionOperation(ArrayList<String> bigList,  ArrayList<String> smallList){
    //     ArrayList<String> intersecttionSet = new ArrayList<>();

    //     for(int i = 0; i)
    // }


    public static int compareSize(int a, int b){
        if(a == b){
            return 0; 
        }else{
            return a-b;
        }
    }

    public static void setSizeFinder(ArrayList<String> setA,  ArrayList<String> setB){
        //Finds the small list and big list to get the loop count and avoid null value cases 
        if(compareSize(setA.size(),setB.size()) >= 0){
            bigList = setA;
            smallList = setB;
        } else{
            bigList = setB;
            smallList = setA;
        }

    }
}
