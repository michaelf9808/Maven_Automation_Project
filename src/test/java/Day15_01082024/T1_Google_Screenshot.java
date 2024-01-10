package Day15_01082024;

import Day10_12112023.Reusable_Methods;
import Day13_12192023.TestParent;
import Day14_01022024.Reusable_Methods_Loggers;
import org.testng.annotations.Test;

public class T1_Google_Screenshot extends TestParent {
    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods_Loggers.sendKeysMethod(driver, "//*[@name= 'q']", "SearchField", "BMW",logger);
        //hit submit on the google search button
        Reusable_Methods_Loggers.submitMethod(driver, "//*[@name= 'btnKl']", logger,"Submit");
        Thread.sleep(1000);
    }//end of test case 2


        @Test
        public void tc002_gitCommit() {
        //committing a new test case
        }//end of test case 2


}//end of class
