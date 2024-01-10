package Day13_12192023;

import Day10_12112023.Reusable_Methods;
import org.testng.annotations.Test;

public class T1_GoogleInheritance extends TestParent {
    @Test
    public void tc001_searchforCar() {
        //navigate to google
        driver.navigate().to("https://www.google.com/");
        //Search for BMW
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']","Search Field","BMW");
        //hit submit on Google search button
        Reusable_Methods.submitMethod(driver,"//*[@name='btnK']","Submit Field");
    }//end of test case 1

    @Test
    public void tc002_captureSearchResult(){
        //store result into variable
        String result = Reusable_Methods.captureText(driver, "//*[@id='result-stats']", "SearchResult");
        //split the result
        String[] searchresultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchresultArray[1]);
    }//end of test case 2

}//end of class
