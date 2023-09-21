package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testngtest {
    @Test
    public void exemplu(){
        System.out.println("merge");
        WebDriver Driver = new ChromeDriver();
        Driver.get("https://keybooks.ro/");
    }
}
