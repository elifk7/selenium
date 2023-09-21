package temaCurs18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

import utils.BaseTest;

public class tema18 extends BaseTest{

    @Test
    public void loginFind() {

        WebElement login = driver.findElement(By.linkText("Login"));
        assertTrue(login.isDisplayed());

        WebElement loginForm = driver.findElement(By.id("log"));
        assertFalse(loginForm.isDisplayed());

        WebElement passwordForm = driver.findElement(By.name("pwd"));
        assertFalse(passwordForm.isDisplayed());

        login.click();
        assertTrue(loginForm.isDisplayed());
        assertTrue(passwordForm.isDisplayed());
    }
}
