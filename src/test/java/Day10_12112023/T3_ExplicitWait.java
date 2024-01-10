package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class T3_ExplicitWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //declare explicit wait statement
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //navigate to google website
        driver.navigate().to("https://www.google.com/");
        //setup try catch
        //navigate to google site
        driver.navigate().to("https://www.google.com");
        try{
            //search for a car
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='q']"))).sendKeys("cars");
        }catch (Exception e){
            System.out.println("Unable to enter value on search field: " + e);
        }//end of search exception
        try{
            //submit
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='btnK']"))).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on search button: " + e);
        }//end of submit exception
        try{
            String result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='result-stats']"))).getText();
            //capture the result and print it
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);
        }//end of search result exception
        driver.quit();
    }//end of main
}//end of class
