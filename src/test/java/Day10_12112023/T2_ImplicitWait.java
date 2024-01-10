package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //declare implicit wait statement
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        //navigate to USPS website
        driver.navigate().to("https://www.google.com/");
        //setup try catch
      try {
          driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
      }catch (Exception e){
          System.out.println("Unable to enter search value on field because" + e);
      }//end of try catch

        try {
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        }catch (Exception e){
            System.out.println("Unable to submit into search field because of " + e);
        }//end of try catch

        try {
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);
        }//end of search result exception
    }//end of main
}//end of class
