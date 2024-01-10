package Day14_01022024;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class Reusable_Methods_Loggers {
    //create a click method to click on any web element
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //create a click method to click on any web element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Successfully clicked on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + ":" + elementName + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            //attach screenshot if click method fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of click method

    //create a submit method to submit on any web element
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger ,String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Successfully Submitted on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on element " + ":" + elementName + e);
            logger.log(LogStatus.FAIL, "Unable to Submit on " + elementName);
            //attach screenshot if submit method fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of submit method

    public static String captureText(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try {
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS, "Successfully Captured text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text " + ":" + elementName + e);
            logger.log(LogStatus.FAIL, "Unable to capture text on " + elementName);
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
    public static void clickByIndexMethod(WebDriver driver, String xpath, int index, String elementName, ExtentTest logger) {
        //create a click method to click on any web element
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Successfully Clicked by index on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element " + ":" + elementName + e);
            logger.log(LogStatus.FAIL, "Unable to Click by index on  " + elementName);
        }
    }//end of click by index method

    public static void sendKeysMethod(WebDriver driver, String xpath, String elementName, String Text, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).sendKeys(Text);
            logger.log(LogStatus.PASS, "Successfully Entered text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to Enter Text on element " + ":" + elementName + e);
            logger.log(LogStatus.FAIL, "Unable to enter text on  " + elementName);
            //attach screenshot if sendkeys method fails
            getScreenShot(driver,elementName,logger);
        }
    }//end of send keys method

    public static void scrollintoViewMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully able to scroll into view on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into element because of " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "Unable to Scroll into view on  " + elementName);
        }//
    }//end of

    public static void selectByVisibleTextMethod(WebDriver driver, String xpath, String visibleText, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select elementDropdown = new Select(element);
            elementDropdown.selectByVisibleText(visibleText);
            logger.log(LogStatus.PASS, "Successfully able to Select by visible text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select by the visible text " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "Unable to Select by visible text " + elementName);
        }
    }//end of select method


    public static void switchTabByIndex(WebDriver driver, int tabIndex,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabIndex));
            logger.log(LogStatus.PASS, "Successfully able to switch by tab index to  " + tabIndex);
        } catch (Exception e) {
            System.out.println("Unable to switch tabs by index " + ":" + e);
            logger.log(LogStatus.FAIL, "Unable to Switch to tab " + tabIndex);

        }//
    }//end of switch tab method

    public static void scrollByPixel(WebDriver driver, String pixelScroll) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            jse.executeScript(pixelScroll);
        } catch (Exception e) {
            System.out.println("Unable to scroll by pixel " + ":" + e);
        }

    }

    public static void clickByJseMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        try {
            jse.executeScript("arguments[0].click();", element);
            logger.log(LogStatus.PASS, "Successfully able to Click by JSE on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element using jse because of " + elementName + ":" + e);
            logger.log(LogStatus.FAIL, "Unable to Click by Jse on " + elementName);
        }
    }//end of method

    public static void getURLMethod(WebDriver driver, String Url, ExtentTest logger, String currentURL) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            driver.getCurrentUrl();
            System.out.println("Captured URL: " + Url);
            logger.log(LogStatus.PASS, "Successfully able to Capture the url on" + currentURL);
        } catch (Exception e) {
            System.out.println("Unable to get url because of " + e);
            logger.log(LogStatus.FAIL, "Unable to Click by Jse on " + currentURL);
        }
    }

    public static void doubleClickMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        try {
            Actions mouseActions = new Actions(driver);
            mouseActions.doubleClick(element).perform();
            logger.log(LogStatus.PASS, "Successfully able to Double click on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to double Click on element " + e + ":" + elementName);
            logger.log(LogStatus.FAIL, "Unable to Double click on " + elementName);
        }//

    }//end of doubleClickMethod

    public static void rightClickMethod(WebDriver driver, String xpath, String elementName, ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        try {
            Actions mouseActions = new Actions(driver);
            mouseActions.contextClick(element).perform();
            logger.log(LogStatus.PASS, "Successfully able to Right click on  " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to right click on element because of " + e + ":" + elementName);
            logger.log(LogStatus.FAIL, "Unable to Right click on  " + elementName);
        }//
    }

    public static void typeUsingJse(WebDriver driver, String xpath, String text, ExtentTest logger) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(1500);
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].value=arguments[1];", element, text);
            logger.log(LogStatus.PASS, "Successfully able to Type using jse on " + text);
        } catch (Exception e) {
            System.out.println("Unable to type using the JSE because of " + ":" + e);
            logger.log(LogStatus.FAIL, "Unable to type using JSE on " + text);
        }//end of try catch

    }

    public static void isConditionTrue(boolean bool, ExtentTest logger) {
        if (bool == true) {
            logger.log(LogStatus.PASS, "Boolean Condition is " + bool);
        } else {
            logger.log(LogStatus.FAIL, "Boolean Condition is " + bool);
        }
    }//end of isConditionTrue method

    public static void hoverOverElement(WebDriver driver, WebElement element,ExtentTest logger) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Successfully able to hover over element on " + element);
        } catch (Exception e) {
            System.out.println("Unable to hover over element because of " + ":" + e + element);
            logger.log(LogStatus.FAIL,"Unable to hover over on " + element);
        }//end
    }//end of hover method

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger){
            try {
                String fileName = imageName + ".png";
                String directory = null;
                String snPath = null;
                directory = "src/main/java/HTML_Report/Screenshots/";
                snPath = "Screenshots//";
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(directory + fileName));
                String image = logger.addScreenCapture(snPath + fileName);
                logger.log(LogStatus.FAIL, "", image);
            } catch (Exception e) {
                logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
                e.printStackTrace();
            }


    }//end of get screenshot method





}//end of class
