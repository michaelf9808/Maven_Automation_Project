package actionitems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ActionItem_05 {
    public static void main(String[] args) {
        //create a firstName ArrayList
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Derek");
        firstName.add("Joshua");
        //create a lastName ArrayList
        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Stevens");
        lastName.add("Santos");
        //create a zipCode ArrayList
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11104");
        zipCode.add("10065");
        //create date of birth arrayList
        ArrayList<String> doB = new ArrayList<>();
        doB.add("08/25/1998");
        doB.add("07/13/1985");
        //create vehicleYear of arrayList
        ArrayList<String> vehicleYear = new ArrayList<>();
        vehicleYear.add("2015");
        vehicleYear.add("2020");
        //create vehicleMake arrayList
        ArrayList<String> vehicleMake = new ArrayList<>();
        vehicleMake.add("BMW");
        vehicleMake.add("Honda");
        //create vehicleModel arraylist
        ArrayList<String> vehicleModel = new ArrayList<>();
        vehicleModel.add("M4");
        vehicleModel.add("Accord");
        //create daysperweek arraylist
        ArrayList<String> daysperWeek = new ArrayList<>();
        daysperWeek.add("4");
        daysperWeek.add("5");
        //create miles arraylist
        ArrayList<String> miles = new ArrayList<>();
        miles.add("2000");
        miles.add("45000");
        //set up the webdriver
        WebDriverManager.chromedriver().setup();
        //set up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //start googlechrome maximized
        options.addArguments("start-maximized");
        //start googlechrome incognito mode
        options.addArguments("Incognito");
        //set up the webdriver driver
        WebDriver driver = new ChromeDriver(options);
        //set up the forloop
        for (int i=0; i< zipCode.size(); i++)  {
            //navigate to geico.com
            driver.navigate().to("https://www.geico.com/");
            //set up the autobox try catch
            try{
            driver.findElement(By.xpath("//*[@class='product-checkbox']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on checkbox because");
            }//end of autobox click try catch

            //set up the start my quote try catch
            try{
                driver.findElements(By.xpath("//*[text()= 'Start My Quote']")).get(1).click();
            }catch (Exception e){
                System.out.println("Unable to click on start my quote because" + e);
            }//end of start my quote try catch

            //set up the zipcode try catch
            try{
                //set up the webelement
                WebElement zipfield = driver.findElement(By.xpath("//*[@id= 'bundle-modal-zip']"));
                zipfield.clear();
                zipfield.sendKeys(zipCode.get(0));
                Thread.sleep(2000);
            }catch (Exception e ){
                System.out.println("Unable to input zipcode because of" + e);
            }//end of zipcode try catch

            //set up homeowners try catch
            try{
                driver.findElements(By.xpath("//*[@data-product= 'homeowners']")).get(1).click();
            }catch (Exception e){
                System.out.println("Unable to click on homeowners because " + e);
            }//end of try catch

            //set up the Continue Button try catch
            try{
                driver.findElements(By.xpath("//*[@value= 'Continue']")).get(0).click();
            }catch (Exception e){
                System.out.println("Unable to click on continue because" + e);
            }//end of try catch

            //set up the date of birth try catch
            try{
                //wait 4 seconds
                Thread.sleep(4000);
                driver.findElement(By.xpath("//*[@class= 'date']")).sendKeys(doB.get(i));
            }catch(Exception e){
                System.out.println("Not able to input date of birth because of" + e);
            }//end of try catch

            //set up Next button try catch
            try{
                driver.findElement(By.xpath("//*[@class= 'btn btn--primary btn--full-mobile btn--pull-right']")).click();
            }catch(Exception e){
                System.out.println("Unable to click on next button because " + e);
            }//end of the next button try catch

            //setup first name try catch
            try{
                //slow down by 3 seconds
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@aria-label= 'First Name']")).sendKeys(firstName.get(i));
            }catch (Exception e){
                System.out.println("Not able to input first name because " + e);
            }//end of first name try catch

            //set up last name try catch
            try{
                Thread.sleep(4000);
                driver.findElement(By.xpath("//*[@aria-label= 'Last Name']")).sendKeys(lastName.get(i));
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to input last name because");
            }//end of last name try catch

            //set up the next button try catch
            try{
                driver.findElement(By.xpath("//*[@class='btn btn--primary btn--full-mobile btn--pull-right']")).click();
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to click on next because of " + e);
            }//end of click on continue try catch

            //set up the address try catch
            try{
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[contains(@class,'include-clear-action')]")).sendKeys("4125 44th Street");
            }catch (Exception e){
                System.out.println("Unable to input address because of " + e);
            }//end of address try catch

            //set up the apartment input try catch
            try {
                driver.findElement(By.xpath("//*[@data-formotivid='UnitNumber']")).sendKeys("APT 3E");
                //slowdown by 3 seconds
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to input apartment number because of " + e);
            }//end of apartment number try catch

            //Set up the next button try catch
            try{
                //slowdown by 3 seconds
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[contains(@class, 'btn--full-mobile btn--pull-right')]")).click();
                //slowdown by 3 seconds
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println("Unable to click on next button due to " + e);
            }//end of next button try catch

            //set up the Labelfor try catch
            try {
                //slowdown by 6 seconds
                Thread.sleep(6000);
                //set up the arraylist webelement with the id label for
                ArrayList<WebElement> yesButton = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@id,'labelFor')]")));
                yesButton.get(0).click();
                //slowdown by 6 seconds
                Thread.sleep(6000);
            }catch (Exception e){
                System.out.println("Unable to click on yes button because" + e);
            }//end of click try catch

            //set up the next button try catch
            try{
                //slowdown by 5 seconds
                Thread.sleep(5000);
                driver.findElement(By.xpath("//*[contains(@class, 'btn btn--primary btn--full-mobile btn--pull-right']"));
                //slowdown by 5 seconds
                Thread.sleep(5000);
            }catch (Exception e){
                System.out.println("Not able to click on the next button because " + e);
            }//end of next button try catch

            //set up the next button try catch
            try{
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on next button for said reason" + e);
            }//end of next button try catch

            //set up the labelforno try catch
            try{
                driver.findElement(By.xpath("id='labelForNo']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on no button because of " + e);
            }//end of labelforno try catch

            //set up yes button try catch
            try{
                driver.findElement(By.xpath("//*[@id='labelForYes']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on yes button because of " + e);
            }//end of yes button try catch

            //set up the next button try catch
            try {
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on next button because of " + e);
            }//end of next button try catch

            //set up the address try catch
            try {
                driver.findElements(By.xpath("//*[@aria-invalid='false']")).get(0).sendKeys("910 Park Avenue");
            }catch (Exception e){
                System.out.println("Unable to input address becasue of " + e);
            }//end of address try catch

            //start of apartment try catch
            try{
                driver.findElements(By.xpath("//*[aria-invalid='false']")).get(1).sendKeys("APT 4K");
            }catch (Exception e){
                System.out.println("Not able to input apartment number because of" + e);
            }//end of apartment try catch

            //start of zipcode try catch
            try{
                driver.findElements(By.xpath("//*[aria-invalid='false']")).get(2).sendKeys("10065");
            }catch (Exception e){
                System.out.println("Not able to input zipcode because of " + e);
            }//end of zipcode try catch

            //start of next button try catch
            try{
                driver.findElement(By.xpath("//*[type='submit']")).click();
            }catch (Exception e){
                System.out.println("Not able to click on next because of " + e);
            }//end of next button try catch

            //set up the no button try catch
            try{
                driver.findElement(By.xpath("//*[@id='labelForNo']")).click();
            }catch (Exception e){
                System.out.println("Not able to click on no button " + e);
            }//end of no button try catch

            //set up the year dropdown box try catch
            try{
               WebElement yearBox = driver.findElement(By.xpath("//*[@aria-label='Year']"));
                //use the select function to select the dropdown year
                Select yearBoxDropDown = new Select(yearBox);
                //click by xpath visible text
                yearBoxDropDown.selectByVisibleText("2015");
            }catch (Exception e){
                System.out.println("Unable to click on 2015 because of " + e);
            }//end of yeardropdownBox try catch

            //set up the makeDropdown box try catch
            try{
                WebElement Make = driver.findElement(By.xpath("//*[@aria-label='Make']"));
                //use the select function to select the dropdown make
                Select makeboxDropDown = new Select(Make);
                //select by xpath visible text
                makeboxDropDown.selectByVisibleText("Honda");
            }catch(Exception e) {
                System.out.println("Not able to use visible text because of " + e);
            }//end of make dropdown box try catch

            //set up the model dropdown box try catch
            try{
                WebElement Model = driver.findElement(By.xpath("//*[@aria-label='Model']"));
                //use the select function to select the dropdown model
                Select modelboxDropDown = new Select(Model);
                //select by xpath visible text
                modelboxDropDown.selectByVisibleText("Accord");
            }catch (Exception e){
                System.out.println("Unable to select accord from dropdown because of " + e);
            }//end of model dropdown box try catch

            //set up the next button try catch
            try{
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            }catch (Exception e){
                System.out.println("Unable to click on next because of " + e);
            }//end of next button try catch

            //set up the next button try catch
            try {
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on next button because of " + e);
            }//end of next button try catch

            //Setup the leased button try catch
            try {
                driver.findElement(By.xpath("//*//*[@id='labelForL']")).click();
            }catch (Exception e){
                System.out.println("Not able to click on leased button because of " + e);
            }//end of leased button try catch

            //set up the next button try catch
            try{
                driver.findElement(By.xpath("//*[@type='submit']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on next button because of " + e);
            }//end of next button try catch













        }//end of for loop









    }
}
