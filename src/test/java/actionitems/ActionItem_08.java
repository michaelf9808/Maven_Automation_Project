package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import Day14_01022024.Reusable_Methods_Loggers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionItem_08 extends TestParent {
    @Test
    public void tc001_lincolnFinancialMessage() throws InterruptedException {
        driver.navigate().to("https://www.lincolnfinancial.com/public/individuals");
        //use the click reusable method
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@class='dropmenu-item']","products",logger);
        //click on the annuities text
        Reusable_Methods_Loggers.clickMethod(driver,"//*[text()='Annuities']",logger,"Annuities");
        //use the scrollintoview to click on the lightbulb at the bottom of the page
        Reusable_Methods_Loggers.scrollintoViewMethod(driver,"//*[@class='callout-grid-item']","Lightbulb",logger);
        //click on learn more
        Reusable_Methods_Loggers.clickMethod(driver,"//*[text()='Learn more']",logger,"learnMore");
        //slowdown by 2 seconds
        Thread.sleep(2000);
        //set up the boolean to determine if the message is displayed
        boolean isMessageCorrect= driver.findElement(By.xpath("//*[@class='copy-publico']")).isDisplayed();
        //String the message and capture the text
        String boldMessage = Reusable_Methods_Loggers.captureText(driver, "//*[@class='copy-publico']", "boldMessage",logger);
        //print the captured text and find out if it is displayed properly
        System.out.println("The message is : " + boldMessage + " Is " + isMessageCorrect);
        //use the boolean method to figure out if it is true
        Reusable_Methods_Loggers.isConditionTrue(isMessageCorrect,logger);
    }//end of test case 1

    @Test
    public void tc002_InsuranceSearch() throws InterruptedException {
        driver.navigate().to("https://www.lincolnfinancial.com/public/individuals");
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@data-linkname='Find a dentist']","dentist",logger);
        Reusable_Methods_Loggers.switchTabByIndex(driver,1,logger);
        //inut the name using sendkeys
        Reusable_Methods_Loggers.sendKeysMethod(driver,"//*[@id='lname']","name field","Mondorius",logger);
        Reusable_Methods_Loggers.sendKeysMethod(driver,"//*[@name='zip']","zipcode","10065",logger);
        Reusable_Methods_Loggers.sendKeysMethod(driver,"//*[@name='address']","address field","116 E66 St",logger);
        Reusable_Methods_Loggers.sendKeysMethod(driver,"//*[@id='city']","city field","Manhattan",logger);
        Reusable_Methods_Loggers.selectByVisibleTextMethod(driver,"//*[@id='state']","New York","dropdown box",logger);
        Thread.sleep(2000);
        boolean isMileageTen = driver.findElement(By.xpath("//*[@value='10']")).isSelected();
        System.out.println("The checkbox is checked: " + isMileageTen);
        Reusable_Methods_Loggers.isConditionTrue(isMileageTen, logger);
    }//end of test case 2


    @Test
    public void tc003_lincolnfinancialHomePageTitle() throws InterruptedException {
        //navigate to lincoln financial
        driver.navigate().to("https://www.lincolnfinancial.com/public/individuals/support/customerservice");
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@aria-label='Find a form']","form box",logger);
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@aria-label='view frequently asked questions']","Questions",logger);
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@aria-label='Contact us']","Questions",logger);
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[@aria-label='File or review a claim']","Claims",logger);
        Reusable_Methods_Loggers.scrollintoViewMethod(driver,"//*[text()='Find a vision provider']","vision provider",logger);
        Reusable_Methods_Loggers.clickByJseMethod(driver,"//*[text()='Find a vision provider']","vision",logger);
        Reusable_Methods_Loggers.switchTabByIndex(driver,1,logger);
        Thread.sleep(2000);
        boolean isCheckboxUnChecked = driver.findElement(By.xpath("//*[@type='checkbox']")).isSelected();
        System.out.println("The checkbox is not checked: " + isCheckboxUnChecked);
        String actualTitle = driver.getTitle();
        //store the expected title
        String expectedTitle = "Landing Page";
        Assert.assertEquals(actualTitle, expectedTitle);
        Reusable_Methods_Loggers.isConditionTrue(isCheckboxUnChecked, logger);



    }




}
