package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Reusable_Methods {


    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        //create a click method to click on any web element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + ":" + elementName + e);
        }
    }//end of click method

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + ":" + elementName + e);
        }
    }//end of submit method

    public static String captureText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + elementName + e);
        }
        return result;
    }//end of capture text method

    public static WebDriver setUpDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }//end of


    //create a click method to click on any web element
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName) {
        //create a click method to click on any web element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e) {
            System.out.println("Unable to click on element " + ":" + elementName + e);
        }
    }//end of click by index method

    public static void sendKeysMethod(WebDriver driver, String xpath, String elementName,String Text) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(Text);
        } catch (Exception e) {
            System.out.println("Unable to input zipcodes on element " + ":" + elementName + e);
        }
    }//end of send keys method

    public static void scrollintoViewMethod(WebDriver driver, String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        }catch (Exception e ) {
            System.out.println("Unable to scroll into element because of " + elementName + ":" + e);

        }//
    }//end of
    public static void selectByVisibleTextMethod(WebDriver driver, String xpath, String visibleText, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            elementDropdown.selectByVisibleText(visibleText);
        }catch (Exception e) {
            System.out.println("Unable to select by the visible text " + elementName + ":" + e);
        }
    }//end of select method


    public static void switchTabByIndex(WebDriver driver, int tabIndex) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
        } catch (Exception e) {
            System.out.println("Unable to switch tabs by index "  + ":" + e);
        }//
    }//end of switch tab method

    public static void scrollByPixel(WebDriver driver, String pixelScroll){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            jse.executeScript(pixelScroll);
        }catch (Exception e ) {
            System.out.println("Unable to scroll by pixel " + ":" + e);
        }

    }
    public static void clickByJseMethod(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        try {
            jse.executeScript("arguments[0].click();",element);
        }catch (Exception e){
            System.out.println("Unable to click on element using jse because of " + elementName + ":" + e);
        }
    }//end of method

    public static void getURLMethod(WebDriver driver, String Url) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            String currentURL = driver.getCurrentUrl();
            System.out.println("Captured URL: " + Url);
        } catch (Exception e) {
            System.out.println("Unable to get url because of " + e);


        }
    }
        public static void doubleClickMethod(WebDriver driver, String xpath, String elementName){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            try {
                Actions mouseActions = new Actions(driver);
                mouseActions.doubleClick(element).perform();
            }catch (Exception e){
                System.out.println("Unable to double Click on element " + e + ":" + elementName);
            }//

       }//end of doubleClickMethod

        public static void rightClickMethod(WebDriver driver, String xpath, String elementName){
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            try{
                Actions mouseActions = new Actions(driver);
                mouseActions.contextClick(element).perform();
            }catch (Exception e ){
                System.out.println("Unable to right click on element because of " + e + ":" + elementName);
            }//
        }

    public static void typeUsingJse(WebDriver driver, String xpath, String text) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10 );
        Thread.sleep(1500);
        try{
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].value=arguments[1];", element , text);
        }catch (Exception e){
            System.out.println("Unable to type using the JSE because of " + ":" + e);
        }//end of try catch

    }














}//end of class


