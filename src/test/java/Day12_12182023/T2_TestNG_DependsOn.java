package Day12_12182023;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_TestNG_DependsOn {
    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver(){
        driver = Reusable_Methods.setUpDriver();
    }//end of before suite


    @Test
    public void tc001_searchforCar() {
        //navigate to google
        driver.navigate().to("https://www.google.com/");
        //Search for BMW
        Reusable_Methods.sendKeysMethod(driver, "//*[@name='q']","Search Field","BMW");
        //hit submit on Google search button
        Reusable_Methods.submitMethod(driver,"//*[@name='btnK']","Submit Field");
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_searchforCar")
    public void tc002_captureSearchResult(){
        //store result into variable
        String result = Reusable_Methods.captureText(driver, "//*[@id='result-stats']", "SearchResult");
        //split the result
        String[] searchresultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchresultArray[1]);
    }//end of test case 2

    @AfterSuite
    public void quitDriver() {
        driver.quit();
    }//end of after suite

}//end of class
