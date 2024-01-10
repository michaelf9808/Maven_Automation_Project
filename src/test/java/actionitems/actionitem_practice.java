package actionitems;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class actionitem_practice extends TestParent {
    @Test
    public void tc001_UspsPage() throws InterruptedException {
        driver.navigate().to("https://www.usps.com/");
        //set up the actions driver
        Actions mouseActions = new Actions(driver);
        //hover over to business tab
        WebElement businessTab = driver.findElement(By.xpath("//*[text()='Business']"));
        //hover over the business tab to access the dropdown
        mouseActions.moveToElement(businessTab).perform();
        //hover over to calculate a business price
        WebElement calculateBusiness = driver.findElement(By.xpath("//*[text()='Calculate a Business Price']"));
        //click on calculate a business price tool
        mouseActions.moveToElement(calculateBusiness).click().perform();
        //create a webelement for the shipping date
        WebElement shippingDate = driver.findElement(By.xpath("//*[@id='ShippingDate']"));
        //input the shipping date
        Reusable_Methods.typeUsingJse(driver, "//*[@id='ShippingDate']", "12/31/2023");
        //use the click reusable method to click on postcard
        Reusable_Methods.clickMethod(driver,"//*[@id='option_0']","Postcard");
        //store the mailing list into a webelement
        WebElement element = driver.findElement(By.xpath("//*[text()='New Mailing']"));
        //store the element into a string to capture the href
        String hrefElement = element.getAttribute("href");
        //print out the href attribute
        System.out.println("The href attribute is "  + hrefElement);
        //set up the javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //store the url into a string
        String hrefURL = "https://postcalc.usps.com/business/MailServices?country=0&ccode=US&mdt=12%2F31%2F2023&m=8#";
        //open the new blank tab
        jse.executeScript("window.open()");
        //switch to the new tab
        Reusable_Methods.switchTabByIndex(driver,1);
        //input the url into the new tab
        driver.get(hrefURL);
        //input 10 into pieces field
        Reusable_Methods.typeUsingJse(driver,"//*[@id='NumberOfPieces']","10");
        //input 120 into pounds field
        Reusable_Methods.typeUsingJse(driver,"//*[@id='Pounds']","120");
        //input 1920 into ounces field
        Reusable_Methods.typeUsingJse(driver,"//*[@id='Ounces']","1920");
    }//end of tc001

}
