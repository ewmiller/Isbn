/**
 * Created by Ethan Miller on 12/30/15.
 */
public class Isbn {
    public String number;
    public Isbn(String number){
        this.number = number;
    }
    public static void main(String[] args){
        //TODO: get number as user input
        Isbn isbn = new Isbn("0385539436");
        if(isbn.isValid()){
            System.out.println("ISBN number " + isbn.number + " is valid.");
        }
        else {
            System.out.println("ISBN number " + isbn.number + " is not valid.");
        }
    }

    public boolean isValid(){
        char[] arr = number.toCharArray();
        int[] iArr = new int[arr.length];
        int sum = 0;

        //TODO: validate number string, or add error checking
        //TODO: handle "X" digit

        // cast char array to int array
        for(int i = 0; i < arr.length; i++){
            String s = Character.toString(arr[i]);
            iArr[i] = Integer.parseInt(s);
        }
        // sum operation according to isbn rules
        for(int i = 10; i > 0; i--){
            sum+=(iArr[10-i]*i);
        }
        return (sum % 11 == 0);
    }

}
