package Day14_01022024;

import Day10_12112023.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Yahoo_ExtentReport {
    WebDriver driver;
    //declare extentreports variable


    ExtentReports reports;
//declare the logger variable
    ExtentTest logger;

    @BeforeSuite
    public void setUpChromeDriver(){
        //driver setup
        driver = Reusable_Methods.setUpDriver();
        //setup report path
        reports = new ExtentReports("src/main/java/HTML_Report/AutomationReport.html", true);
    }//end of before suite

    @Test
    public void tc001_verifyStaySignedIsChecked(){
        logger= reports.startTest("tc001_verifyStaySignedIsChecked");
        ///navigate to yahoo
        driver.navigate().to("https://www.yahoo.com/");
        //click on sign in
        Reusable_Methods.clickMethod(driver,"//*[@id='login-container']","signIn");
        //use
        logger.log(LogStatus.INFO," Succesfully clicked on the sign in button ");
        //store checked option into a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out whether it is
        System.out.println("The checkbox is checked " + isStaySignedInChecked);
        //assert if it is true
        if (isStaySignedInChecked ==true){
            logger.log(LogStatus.PASS,"The checkbox is checked " + isStaySignedInChecked);
        }else {
            logger.log(LogStatus.FAIL,"The checkbox is checked " + isStaySignedInChecked);
        }
    }//end of tc001

    @AfterSuite
    public void quitDriver() {
        driver.quit();
        //needed to create the html report
        reports.flush();
    }//end of after suite

}
