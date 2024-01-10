package Day7_11282023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_WebElement {
    public static void main(String[] args) throws InterruptedException {
        //setup the chromedriver with webdrivermanager
        WebDriverManager.chromedriver().setup();
        //declare the chromeOptions
        ChromeOptions options = new ChromeOptions();
        //add some options for chromeoptions
        options.addArguments("start-maximized");
        //open in incognito mode
        options.addArguments("incognito");
        //run in headless mode
        //options.addArguments("headless");
        //define the webdriver and pass the options argument
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgage calc website
        driver.navigate().to("https://www.mortgagecalculator.org/");
        //store the homeValue into a web element variable
        WebElement homeValue = driver.findElement(By.xpath("//*[@id= 'homeval']"));
        //clear the homeValue field
        homeValue.clear();
        //type in 900000 in the homeValue field
        homeValue.sendKeys("900000");
        //wait 2 seconds
        Thread.sleep(2000);
        //quit the browser
        driver.quit();
    }//end of main
}//end of class
