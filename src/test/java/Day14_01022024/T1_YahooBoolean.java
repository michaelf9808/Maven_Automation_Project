package Day14_01022024;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_YahooBoolean extends TestParent {
    @Test
    public void tc001_verifyStaySignedIsChecked(){
        ///navigate to yahoo
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in
        Reusable_Methods.clickMethod(driver,"//*[@id='login-container']","signIn");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out whether it is
        System.out.println("The checkbox is checked " + isStaySignedInChecked);
        //assert if it is true
        Assert.assertTrue(isStaySignedInChecked);
    }//end of tc001

    @Test
    public void tc002_verifySignInOptionIsUnchecked(){
        //click on the checkbox to uncheck it
        Reusable_Methods.clickMethod(driver,"//*[@class='stay-signed-in checkbox-container']","SignIn");
        //should store false value since checkbox is not checked
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out whether if its true or false
        System.out.println("The checkbox is checked " + isStaySignedInChecked);
        //assert if it is true
        Assert.assertFalse(isStaySignedInChecked);
    }//end of tc002
}
