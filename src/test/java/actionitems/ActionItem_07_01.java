package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ActionItem_07_01 extends TestParent {
    @Test
    public void tc001click() throws InterruptedException {
        driver.navigate().to("https://www.fideliscare.org/");
        Reusable_Methods.clickByJseMethod(driver, "//*[@id='root-3']", "ShopForPlan");
        //Thread.sleep(2000);
        //click on managed care using jse
        Reusable_Methods.clickByJseMethod(driver,"//*[text()='Medicaid Managed Care']", "ManagedCare");
        //capture the url
        Reusable_Methods.getURLMethod(driver,"https://www.fideliscare.org/Shop-For-A-Plan/Our-Plans/Medicaid-Managed-Care");
        //store the managed care into a webelement
        WebElement element = driver.findElement(By.xpath("//*[text()='Medicaid Managed Care']"));
        //put the url into a string
        String UrlToOpen = element.getAttribute("href");
        //set up the jse executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //open the window using jse
        jse.executeScript("window.open()");
        //switch to new tab
        Reusable_Methods.switchTabByIndex(driver, 1);
        //open new tab
        driver.navigate().to(UrlToOpen);
    }//end of test case 1

    @Test
    public void tc002demoQA() throws InterruptedException {
        //navigate to demoqa buttons website
        driver.navigate().to("https://demoqa.com/buttons");
        //use the double click method to click on double click
        Reusable_Methods.doubleClickMethod(driver,"//*[@id='doubleClickBtn']","DoubleClickBtn");
        //use the right click method to click on the right click button
        Reusable_Methods.rightClickMethod(driver,"//*[@id='rightClickBtn']","RightClick");
        //Thread.sleep(2000);
    }//end of test case 2


    @Test
    public void tc003UploadDownload() throws InterruptedException {
        //navigate to demoQA download website
        driver.navigate().to("https://demoqa.com/upload-download");
        //click on the download button and store the value
        Reusable_Methods.clickMethod(driver,"//*[@id='downloadButton']","Download");
        Thread.sleep(2000);





        //Thread.sleep(2000);
    }//end of test case 3


}
