package temaCurs19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class tema19 extends BaseTest {

    @Test
    public void findForest() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        List<WebElement> categories = driver.findElements(By.cssSelector(".sc_tabs_title"));
        WebElement carte = driver.findElement(By.cssSelector("a[href*='the-forest']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement category: categories) {

            jse.executeScript("arguments[0].click();", category);

            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("a[href*='the-forest']")));

            //String elem = category.getText();
            //System.out.println(elem);
            //category.click();
        }
        carte.click();
        assertEquals("https://keybooks.ro/shop/the-forest/", driver.getCurrentUrl());
    }
}