package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Webelementclass {
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
    public void login() throws InterruptedException, IOException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement Text = driver.findElement(By.linkText("Create new account"));
        String text = Text.getText();
        System.out.println(text);

        WebElement dis = driver.findElement(By.linkText("Create new account"));
        boolean display = dis.isDisplayed();
        System.out.println(display);
        driver.findElement(By.partialLinkText("Create new ")).click();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement ele = driver.findElement(By.id("email"));
        ele.sendKeys("prarthanachaudhari@gmail.com");
        Thread.sleep(5000);
        ele.clear();
        String attribute = ele.getAttribute("placeholder");
        System.out.println(attribute);
        Thread.sleep(5000);
        ele.sendKeys("priti@gmail.com");
        WebElement pass = driver.findElement(By.name("pass"));
        int x = pass.getLocation().getX();
        int y = pass.getLocation().getY();
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        int h = pass.getSize().getHeight();
        System.out.println("Height=" + h);
        int w = pass.getSize().getWidth();
        System.out.println("Width=" + w);
        pass.sendKeys("prarthana");
        WebElement log = driver.findElement(By.name("login"));
//        log.click();
        log.submit();
    }
}
