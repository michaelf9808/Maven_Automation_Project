package Day14_01022024;

import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_YahooExtent_Enhanced extends TestParent {
    @Test
    public void tc001_verifyStay() {
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in button
        Reusable_Methods_Loggers.clickMethod(driver, "//*[text() = 'Sign in']", logger, "Sign In Button");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id = 'persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if condition is true
        Reusable_Methods_Loggers.isConditionTrue(isStaySignedInChecked, logger);
    }//end of tc 001
}//end of class
