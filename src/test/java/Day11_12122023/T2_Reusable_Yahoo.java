package Day11_12122023;

import Day10_12112023.Reusable_Methods;
import org.openqa.selenium.WebDriver;

public class T2_Reusable_Yahoo {
    public static void main(String[] args) {
        //instantiate the driver
        WebDriver driver = Reusable_Methods.setUpDriver();
        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com/");
        //click on the sports menu (third tab)
        Reusable_Methods.clickByIndexMethod(driver, "//*[contains(@class, '_yb_q22uj')]", 2, "yahoo headers");
        //quit the driver
        driver.quit();
    }//end of main
}//end of class
