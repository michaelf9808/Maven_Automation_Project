package actionitems;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ActionItem_06 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Reusable_Methods.setUpDriver();
        //navigate to weight watchers
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("11104");
        zipCodes.add("13160");
        zipCodes.add("10006");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i=0; i < zipCodes.size(); i++) {
            //navigate to weight watchers website
            driver.navigate().to("https://www.weightwatchers.com/us/");
            //click on find a workshop
            Reusable_Methods.clickMethod(driver, "//*[text()='Find a Workshop']", "Find a Workshop");
            //click on search for location
            Reusable_Methods.clickMethod(driver,"//*[@id='location-search']", "Search For Location");
            //input the zipcodes
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='location-search']", "Search For Location", zipCodes.get(i));
            //submit the zipcodes
            Reusable_Methods.submitMethod(driver,"//*[@id='location-search']", "Search For Location");
            //click on the studio links
            ArrayList<WebElement> watchStudio =new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '3SE46')]")));
            //start of if statement
            if (i==0) {//if i==0 click on the second link
                jse.executeScript("arguments[0].scrollIntoView(true);", watchStudio.get(1));
                //Thread.sleep(2000);
                Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class, '3SE46')]", 1, "Studio Links");
            }//end of if statement
            if (i==1){//if i==1 click on the third studio link
                jse.executeScript("arguments[0].scrollIntoView(true);", watchStudio.get(2));
                //Thread.sleep(2000);
                Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class, '3SE46')]", 2, "Studio Links");
            }//end of if statement
            if (i==2) {//if i==2 click on first link
                jse.executeScript("arguments[0].scrollIntoView(true);", watchStudio.get(0));
                //Thread.sleep(2000);
                Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class, '3SE46')]", 0, "Studio Links");
            }//end of if statement
            WebElement workSchedule = driver.findElement(By.xpath("//*[@id= 'studioWorkshopSchedule']"));
            jse.executeScript("arguments[0].scrollIntoView(true);",workSchedule);
            WebElement workAddress = driver.findElement(By.xpath("//*[@class= 'address-2PZwW']"));
            System.out.println("Studio Details are " + zipCodes.get(i) + " " + workSchedule.getText() + workAddress.getText());

        }//end of forloop
        driver.quit();
    }//end of main
}//end of class
