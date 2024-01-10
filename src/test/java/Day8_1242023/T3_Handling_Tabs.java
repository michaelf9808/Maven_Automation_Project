package Day8_1242023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_Handling_Tabs {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //navigate to fideliscare website
        driver.navigate().to("https://www.fideliscare.org/");
        //slowdown for 3 seconds
        Thread.sleep(3000);
        //click on shop for a plan
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
        //slowdown for 3 seconds
        Thread.sleep(3000);
        //click on the first shop for a plan link
        driver.findElements(By.xpath("//*[text()='Shop for a Plan']")).get(0).click();
        //click on find a doctor button
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();
        //call ArrayList function to store the tabs
        ArrayList<String> tabs= new ArrayList<>(driver.getWindowHandles());
        //switch to new tab 1
        driver.switchTo().window(tabs.get(1));
        //enter a zipcode on the search field
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11218");
        //slow down for 1.5 seconds
        Thread.sleep(1500);
        //close this new tab
        driver.close();
        //switch back to default tab
        driver.switchTo().window(tabs.get(0));
        //click on find a doctor link from the bottom
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(1).click();


    }//end of main
}//end of class
