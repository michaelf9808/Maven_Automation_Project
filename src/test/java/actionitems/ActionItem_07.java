package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem_07 extends TestParent {
    @Test
    public void tc001_fidelisSearchNumber() throws InterruptedException {
        //navigate to fidelis care
        driver.navigate().to("https://www.fideliscare.org/");
        //click on search
        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-haspopup='true']",1,"SearchButton");
        //slow down for 2 seconds
        //Thread.sleep(2000);
        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-label='Search']",0,"Searchfield");
        //type into box get dental coverage using sendkeysmethod
        Reusable_Methods.sendKeysMethod(driver,"//*[@aria-label='Search']","Searchfield","get dental coverage");
        //click on search button by index
        Reusable_Methods.clickByIndexMethod(driver,"//*[@aria-label='Execute Search']",0,"searchButton");
        //create a string reusable capture text method to be able to split and print result
        String result = Reusable_Methods.captureText(driver,"//*[@id='resInfo-0']","SearchResult");
        //split the result
        String[] searchresultArray = result.split(" ");
        //print out only the number from the results
        System.out.println("Search Result number is " + searchresultArray[1]);
        //click on dental coverage link
        Reusable_Methods.clickMethod(driver,"//*[text()='Get Dental Coverage']","Dental Coverage");
        //slow down by 2 seconds
        //Thread.sleep(2000);
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_fidelisSearchNumber")
    public void tc002_ThankYouSubmission() throws InterruptedException {
        //switch to new tab
        Reusable_Methods.switchTabByIndex(driver, 1);
        //type in first name into field
        Reusable_Methods.sendKeysMethod(driver,"//*[@formcontrolname='firstName']","Firstname","Lackov");
        //Thread.sleep(2000);
        //type last name mondorius into field
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='lastName']","LastName","Mondorius");
        //input zipcode into field
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='zipCode']","zipField","10065");
        //Thread.sleep(2000);
        //use select to select Bronx from dropdown menu
        Reusable_Methods.selectByVisibleTextMethod(driver,"//*[@id='county']","Bronx","Dropdown");
        //input phone number into field
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='phoneNumber']","phonenumber","7182348902");
        //input email into field
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='email']","emailField","lackovmondorius69@gmail.com");
        //click on the checkbox
        Reusable_Methods.clickMethod(driver,"//*[@for='contactMe']","checkBox");
        //Thread.sleep(2000);
        //use submit method to submit form
        Reusable_Methods.submitMethod(driver,"//*[@type='submit']","Submit");
        //Thread.sleep(2000);
        //string the reusable capture text method to be able to print it out
        String textMessage = Reusable_Methods.captureText(driver,"//*[@class='alert alert-success']","textMessage");
        //print out the message
        System.out.println("The message is " + textMessage);
        //close the tab
        driver.close();
    }//end of test case 2

    @Test(dependsOnMethods = "tc002_ThankYouSubmission")
    public void tc003_onlinePortal() throws InterruptedException {
        //switch to original tab
        Reusable_Methods.switchTabByIndex(driver, 0);
        //slowdown 2 seconds
        Thread.sleep(2000);
        //click on login button with index 0
        Reusable_Methods.clickByIndexMethod(driver, "//*[@aria-haspopup='true']", 0, "LoginButton");
        //Thread.sleep(2000);
        //click on member portal
        Reusable_Methods.clickMethod(driver, "//*[@target='_blank']", "Portal");
        //Thread.sleep(2000);
        //switch to new tab
        Reusable_Methods.switchTabByIndex(driver, 1);
        //slowdown by 2 seconds
        Thread.sleep(2000);
        //string the reusbale capture text method to be able to print it out
        String helpMessage = Reusable_Methods.captureText(driver, "//*[@class='flex flex-column p-8']", "HelpMessage");
        //print out the hints message
        System.out.println("The helpful hints are " + helpMessage);
        //close the tab
        driver.close();
    }//end of test case 3
}//end of class
