package LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SocialMediaButtons {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    @AfterEach
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Test
    public void verifyingFacebookButton(){
        WebElement facebookIcon = driver.findElement(By.xpath("//i[@class='fa fa-facebook fa-fw fa-3x']"));
        facebookIcon.click();
        String currentURL =  driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("facebook"), "Does not navigate to the facebook page.");
    }

    @Test
    public void verifyingTwitterButton(){
        WebElement twitterIcon = driver.findElement(By.xpath("//i[@class='fa fa-twitter fa-fw fa-3x']"));
        twitterIcon.click();
        String currentURL =  driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("twitter"),"Does not navigate to the twitter page.");
    }

    @Test
    public void verifyingWebButton(){
        WebElement dribbleIcon = driver.findElement(By.xpath("//i[@class='fa fa-dribbble fa-fw fa-3x']"));
        dribbleIcon.click();
        String currentURL =  driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("dribble"), "Does not navigate to the dribble page.");
    }

    @Test
    public void testMailToLink(){
        WebElement mailLink = driver.findElement(By.xpath("//a[normalize-space()='info@katalon.com']"));
        mailLink.click();
        String currentURL = driver.getCurrentUrl();
        Assertions.assertTrue(currentURL.contains("mailto:"), "Failed to open the mail client");
    }
}
