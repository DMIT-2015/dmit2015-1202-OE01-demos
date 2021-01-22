package dmit2015.ui;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SeleniumJupiter.class)
public class CircleJSPSeleniumTest {

    @Test
    void testWithFireFox(FirefoxDriver driver) {
        driver.get("http://localhost:8080/dmit2015-1202-oe01-instructor-demos/circle.jsp");
        Assertions.assertEquals("Circle Calculator", driver.getTitle());

        WebElement radiusElement = driver.findElement(By.id("radius"));
        radiusElement.clear();
        radiusElement.sendKeys("5");

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        WebElement areaElement = driver.findElement(By.id("area"));
        Assertions.assertEquals("Area = 78.53981633974483", areaElement.getText());

    }

    @Test
    void testWithChrome(ChromeDriver driver) {
        driver.get("http://localhost:8080/dmit2015-1202-oe01-instructor-demos/circle.jsp");
        Assertions.assertEquals("Circle Calculator", driver.getTitle());

        WebElement radiusElement = driver.findElement(By.id("radius"));
        radiusElement.clear();
        radiusElement.sendKeys("5");

        WebElement submitButton = driver.findElement(By.tagName("button"));
        submitButton.click();

        WebElement areaElement = driver.findElement(By.id("area"));
        Assertions.assertEquals("Area = 78.53981633974483", areaElement.getText());

    }
}
