package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //navigate to USPS website
        driver.navigate().to("https://www.usps.com/");
        Thread.sleep(3000);
        //declare the mouse actions
        Actions mouseActions = new Actions(driver);
        //hove to quick tools module
        WebElement quickTool = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        mouseActions.moveToElement(quickTool).perform();
        //click on track a package using mouse click
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        mouseActions.moveToElement(trackPackage).click().perform();
        WebElement searchField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        //when the search field does not have tag input you will have to click on the search field first, also if you see text area it means to click on the search field
        //slowdown by 3 seconds
        Thread.sleep(3000);
        mouseActions.moveToElement(searchField).click().sendKeys("11881881881818").perform();
        //mouseActions.moveToElement(searchField).sendKeys("11881881881818").perform();

    }//end of main
}//end of class
