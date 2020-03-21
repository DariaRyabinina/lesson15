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
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement input = webDriver.findElement(By.id("text"));
        input.sendKeys("руддщ цкщдв", Keys.ENTER);
        //  WebElement button =webDriver.findElement(By.className("websearch-button__text"));
        //  button.click();
        WebElement expentedField = webDriver.findElement(By.className("uniq15833093538611"));
        Assert.assertEquals(expentedField.getText(), "hello word");

    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }

}
