package temaCurs20;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class tema20 extends BaseTest {

    @Test
    public void search() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement search = driver.findElement(By.cssSelector("button[title='Open search']"));
        search.click();
        WebElement searchField = driver.findElement(By.cssSelector(".search_field"));

        if (searchField.isEnabled()) {
            searchField.sendKeys("The story about me");
            searchField.submit();
        }

        By carte = By.cssSelector("a[href*='https://keybooks.ro/shop/the-story-about-me/']");
        //WebElement carte = driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/shop/the-story-about-me/']"));

        WebElement carte1 = null;

        while(carte1 == null) {
            WebElement load1 = null;
            if (load1 == null) {
                jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth'});", driver.findElement(By.cssSelector("span.viewmore_text_1")));
                load1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.viewmore_text_1")));
                load1.click();
            }
            try {
                if (carte1 == null) {
                    carte1 = wait.until(ExpectedConditions.presenceOfElementLocated(carte));
                }
            }
            catch (org.openqa.selenium.TimeoutException e) {
                System.out.println("Nup");
            }
        }

        Thread.sleep(1000);
        carte1.click();
        Thread.sleep(1000);
        assertEquals("https://keybooks.ro/shop/the-story-about-me/", driver.getCurrentUrl());

        WebElement addCart = driver.findElement(By.cssSelector("button[name*='add-to-cart']"));
        addCart.click();

        WebElement cartMessage = driver.findElement(By.cssSelector("div.woocommerce-message"));
        assertTrue(cartMessage.isDisplayed());

        WebElement viewCart = driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/cart/']"));
        if(viewCart.isDisplayed()) {
            viewCart.click();
        }
        Thread.sleep(1000);
        assertEquals("https://keybooks.ro/cart/", driver.getCurrentUrl());
    }

    @Test(dependsOnMethods = "search")
    public void buy() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement qty = driver.findElement(By.cssSelector("input[type*='number']"));
        WebElement increase = driver.findElement(By.cssSelector("span.q_inc"));

       // String quantity = null;
       // if (qty.isDisplayed()) {
       //     quantity = qty.getText();
       // }
       // System.out.println(quantity);
        //if (quantity.equals("1")) {
            increase.click();
        //}

        //quantity = qty.getText();
        //assertTrue(quantity.equals("2"));

        WebElement submit = driver.findElement(By.cssSelector("button[type*='submit'][name*='update_cart']"));
        if (submit.isDisplayed())
            submit.click();

        WebElement msg = driver.findElement(By.cssSelector("div.woocommerce-message"));
        assertTrue(msg.isDisplayed());

        jse.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth'});", driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/checkout/']")));

        Thread.sleep(3000);
        WebElement proceed = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='https://keybooks.ro/checkout/'][class*='checkout-button button alt wc-forward']")));
        //WebElement proceed = driver.findElement(By.cssSelector("a[href*='https://keybooks.ro/checkout/']"));
        proceed.click();

        Thread.sleep(3000);
        assertEquals("https://keybooks.ro/checkout/", driver.getCurrentUrl());

        WebElement bill = driver.findElement(By.cssSelector("h3:contains('Billing details')"));
        //WebElement addition =

                      //  <h3>Billing details</h3>
                      //  <h3>Additional information</h3>
    }
}