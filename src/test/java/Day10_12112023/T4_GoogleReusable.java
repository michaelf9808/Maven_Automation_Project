package Day10_12112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class T4_GoogleReusable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        options.addArguments("start-maximized");
        WebDriver michaelDriver = new ChromeDriver(options);
        //navigate to google.com
        michaelDriver.navigate().to("https://www.google.com/");

        //click on Google Search button
        Reusable_Methods.submitMethod(michaelDriver,"//*[@name='btnK']","Search Button");

        Reusable_Methods.clickMethod(michaelDriver,"//*[text()='About']","About Link");


    }//end of main
}//end of class
