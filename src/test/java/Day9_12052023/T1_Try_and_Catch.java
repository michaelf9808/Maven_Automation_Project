package Day9_12052023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_Try_and_Catch {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        //navigate to mortgagecalc website
        driver.navigate().to("https://www.mortgagecalculator.org");

        try {
            //enter a home value
            WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
            //clear the field
            homeValue.clear();
            //enter a value of 950000
            homeValue.sendKeys("950000");
        }catch (Exception e){
            System.out.println("Unable to enter home value for reason" + e );
        }//end of homevalue try catch


        try {
            //enter a down payment value
            WebElement dpValue = driver.findElement(By.xpath("//*[@id='downpayment']"));
            //clear the field
            dpValue.clear();
            //enter a value of 200123
            dpValue.sendKeys("200123");
        }catch (Exception e){
            System.out.println("Unable to enter downpayment value for reason " + e );
        }//end of down payment try catch

        //quit the driver
        driver.quit();






    }//end of main
}//end of class
