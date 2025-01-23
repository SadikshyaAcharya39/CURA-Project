package LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
   WebDriver driver;

   @BeforeEach
    public void setUp(){
       driver = new FirefoxDriver();
       driver.get("https://katalon-demo-cura.herokuapp.com/");

   }

   @AfterEach
    public void tearDown(){
       if(driver!=null){
           driver.quit();
       }
   }

   @Test
    public void LoginPageFunctionality(){
       WebElement location = driver.findElement(By.xpath("//h1[normalize-space()='CURA Healthcare Service']"));
       String actualText = location.getText();
       Assertions.assertEquals("CURA Healthcare Service",actualText, "Page title doesnot match");
   }

   @Test
    public void DisplayingLoginForm(){
       driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
       driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
       WebElement actualText = driver.findElement(By.xpath("//h2[normalize-space()='Login']"));
       String expectedText= actualText.getText();
       Assertions.assertEquals("Login", expectedText, "Doesnot match");
   }

   @Test
    public void IncorrectUsernameIncorrectPassword(){
       driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
       driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("Sadikshya");
       driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("Acharya");
       driver.findElement(By.xpath("//button[@id='btn-login']")).click();
       WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
       String actualMessage = errorMessage.getText();
       Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", actualMessage, "Does not match");
   }

   @Test
    public void IncorrectUsernameCorrectPassword(){
       driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
       driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("Dummy");
       driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("Acharya");
       driver.findElement(By.xpath("//button[@id='btn-login']")).click();
       WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
       String actualMessage = errorMessage.getText();
       Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", actualMessage, "Does not match");
   }

   @Test
   public void CorrectUsernameIncorrectPassword(){
       driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
       driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("Sadikshya");
       driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("Acharyaa");
       driver.findElement(By.xpath("//button[@id='btn-login']")).click();
       WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
       String actualMessage = errorMessage.getText();
       Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", actualMessage, "Does not match");
   }

    @Test
    public void CorrectUsernameCorrectPasswordAllCaps(){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("JOHN DOE");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("THISISNOTAPASSWORD");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
        String actualMessage = errorMessage.getText();
        Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", actualMessage, "Does not match");
    }

    @Test
    public void CorrectUsernameCorrectPasswordAllInLowercase(){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("john doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("thisisnotapassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();
        WebElement errorMessage = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
        String actualMessage = errorMessage.getText();
        Assertions.assertEquals("Login failed! Please ensure the username and password are valid.", actualMessage, "Does not match");
    }

    @Test
    public void CorrectUsernameCorrectPassword(){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL, "Navigated to the Home Page");

        WebElement header = driver.findElement(By.xpath("//h2[normalize-space()='Make Appointment']"));
        Assertions.assertEquals("Make Appointment", header.getText(), "Title does not Match");
    }



}
