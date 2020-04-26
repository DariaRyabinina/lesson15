package org.DariaRyabinina;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Less15 {
    private WebDriver webDriver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test
    public void Less15() {
        webDriver.get("https://yandex.ru");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input = webDriver.findElement(By.id("text"));
        input.sendKeys("руддщ цкщдв", Keys.ENTER);
        WebElement button = webDriver.findElement(By.className("websearch-button__text"));
        button.click();
        webDriver.getTitle().equals("hello world");
        webDriver.navigate().refresh();
        WebElement expentedField = webDriver.findElement(By.xpath("//input[@class='input__control mini-suggest__input']"));
        Assert.assertEquals(expentedField.getAttribute("value"), "hello world");
        webDriver.getCurrentUrl();
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

}
