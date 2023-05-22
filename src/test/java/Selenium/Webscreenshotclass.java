package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Webscreenshotclass {
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
    }
    @Test
    public void screenshot() throws IOException, InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File SFile = ts.getScreenshotAs(OutputType.FILE);
        File DFile = new File("E:\\QA\\Selenium\\src\\Facebook_Screenshot\\"+"fb.png");
        FileHandler.copy(SFile,DFile);
        Thread.sleep(3000);
        driver.close();
    }
}
