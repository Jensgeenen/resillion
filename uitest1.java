package be.codekata.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

        driver.get("https://www.gva.be/");

        WebElement acceptCookiesButton = driver.findElement(By.id("didomi-notice-agree-button") );
        acceptCookiesButton.click();
        WebElement sportButton = driver.findElement(By.xpath("/html/body/div[4]/div[1]/header/div[1]/nav/ul[1]/li[3]/a") );
        sportButton.click();

        WebElement firstArticleTitle = driver.findElement(By.xpath("/html/body/div[5]/div/div/main/div/div[2]/div/div/div[1]/div/div/div/a/div/div/div/h1"));
        String expectedTitle = "KVM-coach Defour rekent zich nog niet rijk tegen Zulte Waregem: “Maar wel logisch dat we aan de bekerfinale denken”";
        String actualTitle = firstArticleTitle.getText();
        assertEquals(expectedTitle, actualTitle);


        driver.quit();



    }

}
