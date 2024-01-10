package Day8_1242023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgagecalc website
        driver.navigate().to("https://www.mortgagecalculator.org");
        //slowdown by 3 seconds
        Thread.sleep(3000);
        //declare homeval as a webelement
        WebElement homeVal = driver.findElement(By.xpath("//*[@id= 'homeval']"));
        //clear the field
        homeVal.clear();
        homeVal.sendKeys("450000");
        WebElement dPayment = driver.findElement(By.xpath("//*[@id= 'downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("9000");
        //select january as the month
        WebElement StartMonth = driver.findElement(By.xpath("//*[@name= 'param[start_month]']"));
        //set the select function for the start month dropdown
        Select StartMonthDropdown = new Select(StartMonth);
        //select by visible text and select january as the month
        StartMonthDropdown.selectByVisibleText("Jan");
        //slowdown by 2 seconds
        Thread.sleep(2000);
        //select by visible text and verify it switches back to dec
        StartMonthDropdown.selectByVisibleText("Dec");
        //call the quit function
        driver.quit();





    }//end of main
}//end of class
