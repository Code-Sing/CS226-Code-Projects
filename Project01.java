import java.util.Scanner;

public class Project01{
   
    public static boolean[] bitArray1;
    public static boolean[] bitArray2;
    private static Scanner keyboard =  new Scanner(System.in);

    public static final String MSG_1_STRING = "Please enter 1st bit string of lenght n:";
    public static final String MSG_2_STRING = "Please enter 2nd bit string of lenght n:";


    public static void main(String[] args) {
        
        colletBitStrings();
        System.out.println(bitAND(bitArray1, bitArray2));
        System.out.println(bitOR(bitArray1, bitArray2));
        System.out.println(bitXOR(bitArray1, bitArray2));

    }

    public static void colletBitStrings(){
        String bitString1, bitString2;
        boolean vaildBitString = true;
        boolean notBit = false;

        do{
            notBit = false;

            //Gets bit Strings
            System.out.println(MSG_1_STRING);
            bitString1 = keyboard.nextLine();
            System.out.println(MSG_2_STRING);
            bitString2 = keyboard.nextLine();
            
            //Checks for different lengths
                while(bitString1.length() != bitString2.length()){
                    System.out.println("2nd String is not " + bitString1.length() + " char long.");
                    System.out.println(MSG_2_STRING);
                    bitString2 = keyboard.nextLine();
                }

            char [] charArray1 = bitString1.toCharArray();
            char [] charArray2 = bitString2.toCharArray();
            bitArray1 = new boolean[bitString1.length()];
            bitArray2 = new boolean[bitString2.length()];

            //Makes bitArrays from input strings and checks for invaild chars 
                for(int i = 0; i < charArray1.length; i++){
                    if(charArray1[i] == '1'){
                        bitArray1[i] = true;
                    }else if(charArray1[i] == '0'){
                        bitArray1[i] = false;
                    } else {
                        System.out.println("String(s) not bits");
                        notBit = true;
                    }
                    //System.out.println("Array 1 index: " + i + " " + bitArray1[i]);
                }

                for(int i = 0; i < charArray2.length; i++){
                    if(charArray2[i] == '1'){
                        bitArray2[i] = true;
                    }else if(charArray2[i] == '0'){
                        bitArray2[i] = false;
                    } else {
                        System.out.println("One of the Strings is not a bitstring. Try again.");
                        notBit = true;
                    }
                    //System.out.println("Array 2 index: " + i + " " + bitArray2[i]);
                }
    
            if(notBit == true){
                vaildBitString = false;
            } else{
                vaildBitString = true;
            }
            
        }while(vaildBitString == false);

        keyboard.close();
        System.out.println("Colleted bitStrings");
    }

    public static String bitAND (boolean[] bitArray1, boolean[] bitArray2){
        String bitwiseAND = "Bitwise AND is ";

        for(int i = 0; i < bitArray1.length; i++){
            if(bitArray1[i] && bitArray2[i]){
                bitwiseAND += "1"; 
            }else{
                bitwiseAND += "0";
            }
        }

        return bitwiseAND;
    }

    public static String bitOR (boolean[] bitArray1, boolean[] bitArray2){
        String bitwiseOR = "Bitwise Or is ";

        for(int i = 0; i < bitArray1.length; i++){
            if(bitArray1[i] || bitArray2[i]){
                bitwiseOR += "1"; 
            }else{
                bitwiseOR += "0";
            }
        }

        return bitwiseOR;
    }

    public static String bitXOR (boolean[] bitArray1, boolean[] bitArray2){
        String bitwiseXOR = "Bitwise XOR is ";

        for(int i = 0; i < bitArray1.length; i++){
            if((bitArray1[i] || bitArray2[i]) && !(bitArray1[i] && bitArray2[i])){
                bitwiseXOR += "1"; 
            }else{
                bitwiseXOR += "0";
            }
        }

        return bitwiseXOR;
    }


} 
