package temaCurs21;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class tema21 extends BaseTest {

    @Test
    public void review() throws InterruptedException {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement theson = driver.findElement(By.cssSelector("a[href*='the-son']"));
        if (theson.isDisplayed())
            theson.click();

        jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth'});", driver.findElement(By.cssSelector("li.reviews_tab")));
        WebElement review = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.reviews_tab")));
        review.click();

        jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth'})", driver.findElement(By.cssSelector("input#wp-comment-cookies-consent")));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#wp-comment-cookies-consent")));

        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        if (checkbox.isSelected()) {
            WebElement submit = driver.findElement(By.cssSelector("input[name*='submit']"));
            submit.click();
        }
        driver.switchTo().alert().accept();

        WebElement rating = driver.findElement(By.cssSelector("a.star-4"));
        rating.click();

        WebElement comment = driver.findElement(By.cssSelector("textarea#comment"));
        if(comment.isEnabled()) {
            comment.click();
            comment.sendKeys("message");
        }
        WebElement autor = driver.findElement(By.cssSelector("input#author"));
        if(autor.isEnabled()) {
            autor.click();
            autor.sendKeys("nume2");
        }
        WebElement mail = driver.findElement(By.cssSelector("input#email"));
        if(mail.isEnabled()) {
            mail.click();
            mail.sendKeys("mail@mail.com");
        }
        WebElement submit = driver.findElement(By.cssSelector("input[name*='submit']"));
        if(checkbox.isEnabled())
            submit.click();

        WebElement approveMsg = driver.findElement(By.cssSelector("em.woocommerce-review__awaiting-approval"));
        assertTrue(approveMsg.isDisplayed());
    }
}
