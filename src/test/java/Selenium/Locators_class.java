package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Reporter.clear;

public class Locators_class {
    public WebDriver driver;
    @BeforeMethod
    public void setup() {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
    }
    @Test
    public void open() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test
    public void locator_method() throws InterruptedException {
   open();
//        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("985644567");
        //OR
        WebElement ele =driver.findElement(By.cssSelector("input#email"));
        ele.sendKeys("65456887555");
        ele.clear();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("65845575665");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Email address ')]")).sendKeys("65845575665");
        driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[starts-with(@placeholder,'Email address')]")).sendKeys("65845575665");
//      driver.findElement(By.xpath("//input[ends-with(@placeholder,'Email address')]")).sendKeys("65845575665");
        Thread.sleep(3000);
        open();
        WebElement Text = driver.findElement(By.linkText("Create new account"));
        String text = Text.getText();
        System.out.println(text);
        WebElement dis = driver.findElement(By.linkText("Create new account"));
        boolean display = dis.isDisplayed();
        System.out.println(display);
        driver.findElement(By.partialLinkText("Create new ")).click();
        driver.quit();

    }
}
