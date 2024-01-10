package actionitems;

public class ActionItem_02_01 {
    public static void main(String[] args) {
        //The student received the grade of an 84
        int studentGrade = 84;
        //execute the grade ranges using if and else if conditional statements to see which grade the student recieved
        if(studentGrade >= 90 && studentGrade <= 100) {
            System.out.println("Student grade is scored as A");
        }else if (studentGrade >= 80 && studentGrade < 90) {
            System.out.println("Student grade is scored as a B");
        }else if (studentGrade >= 70 && studentGrade < 80) {
            System.out.println("Student grade is scored as a C");
        }else if (studentGrade >= 60 && studentGrade < 70) {
            System.out.println("Student grade is scored as a D");
        }else if (studentGrade < 60) {
            System.out.println("Student grade is scored as a F");
        }//end of if statement
    }//end of main
}//end of class
