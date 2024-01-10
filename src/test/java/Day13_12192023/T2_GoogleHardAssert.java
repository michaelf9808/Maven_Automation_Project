package Day13_12192023;

import Day10_12112023.Reusable_Methods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_GoogleHardAssert extends TestParent{
    @Test(priority = 1)
    public void tc001_verifyGoogleTitle() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //store the title of google page
        String actualTitle = driver.getTitle();
        //store the expected title
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle);
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods.sendKeysMethod(driver, "//*[@name= 'q']", "SearchField", "BMW");
        //hit submit on the google search button
        Reusable_Methods.submitMethod(driver, "//*[@name= 'btnK']", "Submit");
    }//end of test case 2

    @Test(priority = 3)
    public void tc003_captureSearchResult(){
        //store result into variable
        String result = Reusable_Methods.captureText(driver, "//*[@id='result-stats']", "SearchResult");
        //split the result
        String[] searchresultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchresultArray[1]);
        String actualSearchNumber = searchresultArray[1];
        String expectedSearchNumber = "1,360,000,000,000";
    }//end of test case 3

}//end of class
