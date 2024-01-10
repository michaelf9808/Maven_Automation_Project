package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem_03 {
    public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            //add the new webdriver
            WebDriver driver = new ChromeDriver();
            //Navigate to bing.com
            driver.navigate().to("https://www.bing.com/");
            //slow down by 3 seconds
            Thread.sleep(3000);
            //maximize the driver
            driver.manage().window().maximize();
            //search for baseball using relative xpath
            driver.findElement(By.xpath("//*[@id= 'sb_form_q']")).sendKeys("Baseball");
            //slow down by 3 seconds
            Thread.sleep(3000);
            //hit submit on bing search
            driver.findElement(By.xpath("//*[@name= 'q']")).submit();
            //search the results in a string variable
            String searchResult = driver.findElement(By.xpath("//*[@class= 'sb_count']")).getText();
            //slow down by 3 seconds
            Thread.sleep(3000);
            //Proceed to news page about baseball
            driver.findElement(By.xpath("//*[@id='b-scopeListItem-news']")).click();
            //slow down process by 3 seconds
            Thread.sleep(3000);
            //return back to search results page
            driver.findElement(By.xpath("//*[@id='b-scopeListItem-web']")).click();
            //print the result in the console
            System.out.println("Search Result number is " + searchResult);
            //Use split to split the search result
            String[] searchResultVariable = searchResult.split(" ");
            //print the search result number
            System.out.println("The search result number is " + searchResultVariable[1]);
            //slow down by 4 seconds
            Thread.sleep(4000);
            //use the quit command to quit the driver
            driver.quit();
    }//end of main
}//end of class

