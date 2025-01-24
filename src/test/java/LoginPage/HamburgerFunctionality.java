package LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HamburgerFunctionality {
    private WebDriver driver;
    private LoginTest loginTest;

    @BeforeEach
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void verifyingHamburgerButtonFunctionalityWithoutLogIn(){
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        WebElement sidebar = driver.findElement(By.xpath("//nav[@id='sidebar-wrapper']"));
        Assertions.assertTrue(sidebar.isDisplayed(), "Side bar is not displayed");
    }

    @Test
    public void navigatingtoHomePageUsingSideBar(){
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/", currentURL, "URL doesnot match");
    }

    @Test
    public void navigatingtoLoginPageUsingSideBar(){
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#login", currentURL, "URL doesnot match");
    }

    //  After Login

    @Test
    public void navigatingtoHomePage(){
//        loginTest.CorrectUsernameCorrectPassword();

        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL, "Navigated to the Home Page");
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/", currentURL, "URL doesnot match");
    }

    @Test
    public void navigatingtoHistoryPage(){
//        loginTest.CorrectUsernameCorrectPassword();

        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL, "Navigated to the Home Page");

        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.cssSelector("a[href='history.php#history']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/history.php#history", currentURL, "URL doesnot match");
    }

    @Test
    public void navigatingToProfilePage(){
//        loginTest.CorrectUsernameCorrectPassword();

        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL, "Navigated to the Home Page");
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Profile']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/profile.php#profile", currentURL, "URL doesnot match");
    }

    @Test
    public void navigatingToLogoutPage(){
//        loginTest.CorrectUsernameCorrectPassword();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
        driver.findElement(By.xpath("//input[@id='txt-username']")).sendKeys("John Doe");
        driver.findElement(By.xpath("//input[@id='txt-password']")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.xpath("//button[@id='btn-login']")).click();

        String expectedURL = "https://katalon-demo-cura.herokuapp.com/#appointment";
        String actualURL = driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL, actualURL, "Navigated to the Home Page");
        driver.findElement(By.xpath("//a[@id='menu-toggle']")).click();
        driver.findElement(By.xpath("//a[@href='authenticate.php?logout']")).click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertEquals("https://katalon-demo-cura.herokuapp.com/", currentURL, "URL doesnot match");
    }
}
