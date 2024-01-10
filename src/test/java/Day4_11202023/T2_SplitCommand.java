package Day4_11202023;

public class T2_SplitCommand {
    public static void main(String[] args) {
        //declare a string variable with a single message
        String message = "My name is John ";
        //delcare an array to store the split message
        String[] splitMessage = message.split(" ");
        //print out only John from the string message
        System.out.println("The name is "+ splitMessage[3]);
        //split based on _
        String message2 = "Automation_01";
        String[] splitMessage2  = message2.split("_");
        //print out only the action item number
        System.out.println("Action item number is " + splitMessage2[1]);

        String message3 = " my name is Michael";
        String [] splitMessage3 = message3.split(" ");
        System.out.println("The first name of my name is " + splitMessage3[4]);

        String message4 = "The building is over there ";
        String[] splitMessage4 = message4.split(" ");
        System.out.println("By the 34th street " + splitMessage4[1]);




    }//end of main
}//end of class
