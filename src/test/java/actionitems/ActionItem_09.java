package actionitems;

import Day13_12192023.TestParent;
import Day14_01022024.Reusable_Methods_Loggers;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ActionItem_09 extends TestParent {
    @Test
    public void tc001_lincolnFinancialCommit() throws InterruptedException {
        driver.navigate().to("https://www.lincolnfinancial.com/public/individuals");
        //use the click reusable method
        Reusable_Methods_Loggers.clickByJseMethod(driver, "//*[@class='dropmenu-item']", "products", logger);
        //slowdown by 2 seconds
        Thread.sleep(2000);
        //click on the annuities text
        Reusable_Methods_Loggers.clickMethod(driver, "//*[text()='Annuities']", logger, "Annuities");
        //use the scrollintoview to click on the lightbulb at the bottom of the page
        Reusable_Methods_Loggers.scrollintoViewMethod(driver, "//*[@class='callout-grid-item']", "Lightbulb", logger);
        //click on learn more
        Reusable_Methods_Loggers.clickMethod(driver, "//*[text()='Learn more']", logger, "learnMore");
        //slowdown by 2 seconds
        Thread.sleep(2000);
        //set up the boolean to determine if the message is displayed
        boolean isMessageCorrect = driver.findElement(By.xpath("//*[@class='copy-publico']")).isDisplayed();
        //String the message and capture the text
        String boldMessage = Reusable_Methods_Loggers.captureText(driver, "//*[@class='copy-publico']", "boldMessage", logger);
        //print the captured text and find out if it is displayed properly
        System.out.println("The message is : " + boldMessage + " Is " + isMessageCorrect);
        //use the boolean method to figure out if it is true
        Reusable_Methods_Loggers.isConditionTrue(isMessageCorrect, logger);
    }//end of test case 1
}
