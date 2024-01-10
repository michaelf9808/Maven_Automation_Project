package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_04 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11104");
        zipCodes.add("13160");
        zipCodes.add("10006");
        //setup up the webdriver
        WebDriverManager.chromedriver().setup();
        //declare the chromeOptions
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //set the chromedriver options
        WebDriver driver = new ChromeDriver(options);
        //execute the javascript driver
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //create a forloop
        for (int i = 0; i < zipCodes.size(); i++) {
            //navigate to weightwatchers website
            driver.navigate().to("https://www.weightwatchers.com/us/");
            //declare find a workshop as an element and click on it
            driver.findElement(By.xpath("//*[text()= 'Find a Workshop']")).click();
            //declare the search as a web element
            WebElement locatorZ = driver.findElement(By.xpath("//*[@id= 'location-search']"));
            locatorZ.click();
            Thread.sleep(2000);
            //clear the field
            locatorZ.clear();
            locatorZ.sendKeys(zipCodes.get(i));
            locatorZ.submit();
            Thread.sleep(2000);
            ArrayList<WebElement> watchStudio =new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '3SE46')]")));
            Thread.sleep(2000);
            if (i==0){//if i==0 click on the second link
                jse.executeScript("arguments[0].scrollIntoView(true);",watchStudio.get(1));
                Thread.sleep(2000);
                watchStudio.get(1).click();
                Thread.sleep(2000);
            }//end of if conditional
            if (i==1) {//if i==1 click on third link
                jse.executeScript("arguments[0].scrollIntoView(true);", watchStudio.get(2));
                Thread.sleep(2000);
                watchStudio.get(2).click();
                Thread.sleep(2000);
            }//end of if conditional
            if (i==2) {//if i==2 click on first link
                jse.executeScript("arguments[0].scrollIntoView(true);", watchStudio.get(0));
                Thread.sleep(2000);
                watchStudio.get(0).click();
                Thread.sleep(2000);
            }//end of if conditional
            WebElement workSchedule = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",workSchedule);
            Thread.sleep(3000);
            WebElement workAddress = driver.findElement(By.xpath("//*[@class= 'address-2PZwW']"));
            //print out the results
            System.out.println("Studio Details are " + zipCodes.get(i) + " " + workSchedule.getText() + workAddress.getText());
        }//end of forloop
        driver.quit();
    }//end of main
}//end of class
