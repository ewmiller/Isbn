/**
 * Created by Ethan Miller on 12/30/15.
 */

import java.util.*;

public class Isbn {
    public String number;
    public Isbn(String number){
        this.number = number;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an ISBN-10 number into the console, excluding dashes (e.g. 0385539436):");
        String num = scanner.nextLine();
        Isbn isbn = new Isbn(num);
        if(isbn.isValid()){
            System.out.println("ISBN " + isbn.number + " is valid.");
        }
        else {
            System.out.println("ISBN " + isbn.number + " is not valid.");
        }
    }

    public boolean isValid(){
        char[] arr = number.toCharArray();
        if(arr.length != 10){
            System.out.println("Invalid input: " + number + " is not the correct length.");
            System.out.println("Exiting.");
            System.exit(1);
        }
        int[] iArr = new int[arr.length];
        int sum = 0;

        // cast char array to int array
        try {
            for (int i = 0; i < arr.length; i++) {
                String s = Character.toString(arr[i]);
                // handles X digit that can appear in ISBN numbers
                if (s.equals("X")) {
                    iArr[i] = 10;
                } else {
                    iArr[i] = Integer.parseInt(s);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error while reading input: " + number);
            System.out.println(e.toString());
            System.out.println("Your input may be incorrectly formatted.");
        }
        // sum operation according to isbn rules
        for(int i = 10; i > 0; i--){
            sum+=(iArr[10-i]*i);
        }
        return (sum % 11 == 0);
    }

}
