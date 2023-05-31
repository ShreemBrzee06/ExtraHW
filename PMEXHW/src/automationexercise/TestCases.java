package automationexercise;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestCases extends BaseTest {

    String baseUrl = "http://automationexercise.com";
    @Before
    public void setUp(){
        openingBrowser(baseUrl);
    }
    @Test
    public void loginWithValidCredentials(){
        boolean actualHomePgMsg = driver.findElement(By.xpath("//a[@ href=\"/\"]")).isDisplayed();
        System.out.println(actualHomePgMsg);
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean userName= driver.findElement(By.xpath("//a//i[@class='fa fa-user']")).isDisplayed();
        System.out.println("userName" + userName);
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();
        String deletedAccountMsg = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println(deletedAccountMsg);

    }

    @Test
    public void loginWithInvalidCredentials(){
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String errorMsg= driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        System.out.println("ErrorMsg" + errorMsg);
    }

    @Test
    public void logoutUser(){
        boolean actualHomePgMsg = driver.findElement(By.xpath("//a[@ href=\"/\"]")).isDisplayed();
        System.out.println(actualHomePgMsg);
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean userName= driver.findElement(By.xpath("//a//i[@class='fa fa-user']")).isDisplayed();
        System.out.println("userName" + ""+userName);
        driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();
        boolean userInHomePG =driver.findElement(By.xpath("//a[@ href=\"/\"]")).isDisplayed();
        System.out.println("User is in Home page is "+ ""+ userInHomePG);

    }

    @Test
    public void registerUserWithExistingEmail(){
        boolean actualHomePgMsg = driver.findElement(By.xpath("//a[@ href=\"/\"]")).isDisplayed();
        System.out.println(actualHomePgMsg);
        driver.findElement(By.name("name")).sendKeys("test");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String ErrorMsg = driver.findElement(By.xpath("//p[@style='color: red;']")).getText();
        System.out.println("Error message of already existed email is"+ " "+ErrorMsg);
    }

    @Test
    public void verifyTestCasesPage(){
        boolean actualHomePgMsg = driver.findElement(By.xpath("//a[@ href=\"/\"]")).isDisplayed();
        System.out.println(actualHomePgMsg);
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean userName= driver.findElement(By.xpath("//a//i[@class='fa fa-user']")).isDisplayed();
        System.out.println("userName" + ""+userName);
        driver.findElement(By.xpath("//button[@type='button']")).click();
        String userIsOnTestCasesPG = driver.findElement(By.xpath("//h2[@class='title text-center']")).getText();
        System.out.println("User is on Test Cases page: "+""+userIsOnTestCasesPG);
    }
    @Test
    public void verifyAllProductsAndDetailPage(){
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean userName= driver.findElement(By.xpath("//a//i[@class='fa fa-user']")).isDisplayed();
        System.out.println("userName" + ""+userName);
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();
        boolean productDisplayed = driver.findElement(By.xpath("//section[@style='height: auto !important;']//div[@class='container']")).isDisplayed();
        System.out.println("Product is displayed is "+""+productDisplayed);

    }
    @Test
    public void searchProduct(){
        driver.findElement(By.xpath("//a[@ href=\"/login\"]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("softwaretesting@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("test12345");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        boolean userName= driver.findElement(By.xpath("//a//i[@class='fa fa-user']")).isDisplayed();
        System.out.println("userName" + ""+userName);
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();
        boolean productDisplayed = driver.findElement(By.xpath("//section[@style='height: auto !important;']//div[@class='container']")).isDisplayed();
        System.out.println("Product is displayed is "+""+productDisplayed);
        driver.switchTo().alert().sendKeys("Close");
       // driver.findElement(By.name("search")).click();
       driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys("dress");
       // driver.findElement(By.xpath("//button[@id='submit_search']")).click();

    }

    @After
    public void tearDown(){
      //  closingBrowser();
    }
}
