package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Webdriverclass {
    public WebDriver driver;

    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }

    @Test
    public void FB() throws InterruptedException, IOException{
    driver.get("https://www.facebook.com/");
    driver.manage().window().maximize();
    String url= driver.getCurrentUrl();
    System.out.println(url);
    String title= driver.getTitle();
    System.out.println(title);
    String source=driver.getPageSource();
    System.out.println(source);
    Thread.sleep(5000);
   driver.navigate().to("https://www.nykaa.com/");
   driver.navigate().back();
   Thread.sleep(3000);
   driver.navigate().refresh();
   driver.navigate().forward();
   Thread.sleep(3000);
   driver.close();
//    driver.quit();
    }
}