package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.table.TableRowSorter;

public class Javascript {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    @Test
    public void Scrollupdown() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(5000);
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void enter_data_disabled_field() throws InterruptedException {
        driver.get("file:///E:/QA/Javascriptexecutor.html");
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor)driver;
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t1').value='Prarthana Chaudhair'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value=''");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value='manager'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').type='button'");
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void frameParent() throws InterruptedException {
        driver.get("file:///E:/QA/Lastname.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);
        driver.findElement(By.id("t1")).sendKeys("Prarthana");
        Thread.sleep(2000);
       driver.switchTo().defaultContent();
       driver.findElement(By.id("t2")).sendKeys("Chaudhari");
       Thread.sleep(2000);
    }
}
