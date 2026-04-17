package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class myfirstclass {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // --- Open Moole.ai ---
            driver.get("https://moole.ai/");
            driver.manage().window().maximize();

            // --- Click Sign In ---
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(@href,'signin')]")
            )).click();

            // --- Wait for email input field ---
            
            WebElement emailField = driver.findElement(By.name("email"));
           // ));

            // --- Use JavaScript to set value in React-controlled input ---
            String email = "moole.dev.2@gmail.com";
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //js.executeScript(script "arguments[0].value='moole.dev.2@gmail.com'",emailField);
            emailField.submit();

            System.out.println("✅ Email entered successfully!");

            // --- Click Continue ---
            WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'Continue')]")
            ));
            continueBtn.click();

            System.out.println("✅ Continue clicked!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}