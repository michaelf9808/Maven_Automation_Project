package actionitems;

import java.util.ArrayList;

public class Actionitem_02 {
    public static void main(String[] args) {
        ArrayList <String> regions = new ArrayList<>();
        //add regions to begin to iterate
        regions.add ("Kyoto ");
        regions.add ("Belgrade ");
        regions.add ("Bucharest ");
        regions.add ("Seoul ");
        ArrayList <Integer> areaCodes = new ArrayList<>();
        //add areacodes to begin to iterate
        areaCodes.add (913);
        areaCodes.add (673);
        areaCodes.add (646);
        areaCodes.add (347);
        //print to find out which regions match with the areacodes
        for (int i = 0;  i < regions.size(); i++) {
            System.out.println("My region is " + regions.get(i) + "and my area code is " + areaCodes.get(i));
        }//end of for loop
        //The student received the grade of an 84
        int studentGrade = 84;
        //execute the grade ranges using if and else if conditional statements to see which grade the student recieved
        if(studentGrade >=90 && studentGrade <=100) {
            System.out.println("Student grade is scored as A");
        }else if (studentGrade >=80 && studentGrade <=90) {
            System.out.println("Student grade is scored as a B");
        }else if (studentGrade >=70 && studentGrade <=80) {
            System.out.println("Student grade is scored as a C");
        }else if (studentGrade >=60 && studentGrade <=70) {
            System.out.println("Student grade is scored as a D");
        }else if (studentGrade <=60) {
            System.out.println("Student grade is scored as a F");
        }//end of if statement
    }//end of main
}//end of class
