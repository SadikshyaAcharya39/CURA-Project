package LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MakeAppointment {
    private WebDriver driver;

    @BeforeEach
    public void setDriver(){
        driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if(driver!= null){
            driver.quit();
        }
    }


//    @Test
//    public void makingAppointment(){
////        driver.findElement(By.cssSelector("body > section:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(2) > div:nth-child(1)")).click();
////        driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']")).click();
//
////        locate the date input field
//        WebElement datepicked = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
//        datepicked.click();
//
//        // Locate the date picker pop up
//        WebElement datePicker = driver.findElement(By.xpath("//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']"));
//        Assertions.assertTrue(datePicker.isDisplayed(), "Date picker is not displayed.");
//
//        // Enter the correct date in the date field
//        LocalDate currentDate = LocalDate.now();
//        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Assuming MM/dd/yyyy format
//        datepicked.sendKeys(formattedDate);
//
//        // Retrieve the value from the date input field and compare it with the current date
//        String selectedDateStr = datepicked.getAttribute("value"); // Get the value from the input field
//        LocalDate selectedDate = LocalDate.parse(selectedDateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
//
//        Assertions.assertTrue(!selectedDate.isBefore(currentDate), "Date picked is earlier than the current date");

//}


}
