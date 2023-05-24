package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class FB_login {
    public WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        driver=new ChromeDriver();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
    }
    @Test
    public void login()  {
        driver.findElement(By.id("email")).sendKeys("prarthanachaudhari@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("prarthana");
        driver.findElement(By.name("login")).click();
    }
    @Test
public void signup() throws InterruptedException {
        driver.findElement(By.partialLinkText("Create new ")).click();
        Thread.sleep(3000);
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("prarthana");
        Thread.sleep(5000);
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("chaudhari");
        Thread.sleep(5000);
        WebElement phone = driver.findElement(By.name("reg_email__"));
        phone.sendKeys("prarthana@gmail.com");
        Thread.sleep(5000);
        WebElement re = driver.findElement(By.name("reg_email_confirmation__"));
        re.sendKeys("prarthana@gmail.com");
        Thread.sleep(5000);
        WebElement pass = driver.findElement(By.name("reg_passwd__"));
        pass.sendKeys("prarthana");
        Thread.sleep(5000);
        WebElement day=driver.findElement(By.id("day"));
        day.sendKeys("16");
        Thread.sleep(3000);
        WebElement month=driver.findElement(By.id("month"));
        month.sendKeys("June");
        Thread.sleep(2000);
        WebElement year=driver.findElement(By.id("year"));
        year.sendKeys("1995");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//label[@class='_58mt'])[1]")).click();
    }
}
