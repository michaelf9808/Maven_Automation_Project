package Day3_11142023;

public class T3_MultipleConditions {
    public static void main(String[] args) {
        //declare some int values
        int a = 7;
        int b = 26;
        int c = 54;
        //start of conditional statement
        if (a + b > c) {
            System.out.println("sum of a and b is greater than c ");
        } else if (a + b < c) {
            System.out.println("sum of a and b is less than c ");
        } else {
            System.out.println("sum of a and b is  equal to c ");
        }//end of if else statement
    }//end of main
}//end of class
