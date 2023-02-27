package be.codekata.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class uitest {
    @Test
    public void checktest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jensg\\IdeaProjects\\selenium_workshop_02_03_22\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.google.com/");
        String googleTitle = driver.getTitle();

        assertEquals("Google", googleTitle);
        driver.quit();

    }
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jensg\\IdeaProjects\\selenium_workshop_02_03_22\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        // Navigate to the website with the cookies pop up
        driver.get("https://hln.be");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Switch to the iframe containing the cookies pop up
        WebElement iframe = driver.findElement(By.cssSelector("#sp_message_iframe_767683"));
        driver.switchTo().frame(iframe);

        // Accept the cookies
        WebElement acceptButton = driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/button[1]"));
        acceptButton.click();

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Close the browser
        driver.quit();



    }


}
