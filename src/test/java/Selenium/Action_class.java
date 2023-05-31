package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Action_class {
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
    public void Using_contextClick() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(8000);
        WebElement pass= driver.findElement(By.xpath("//input[@id='pass']"));
        Actions actions=new Actions(driver);
        actions.contextClick(pass).perform();
        Thread.sleep(2000);
    }
    @Test
    public void Using_DragAndDrop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        WebElement src= driver.findElement(By.id("draggable"));
        WebElement des=driver.findElement(By.xpath("//p[text()='Drop here']"));
//       WebElement des= driver.findElement(By.id("droppable"));
        Thread.sleep(2000);
        Actions actions=new Actions(driver);
     actions.dragAndDrop(src,des).perform();
//        actions.moveToElement(src).clickAndHold().perform();
//        actions.release(des).perform();
        driver.close();
    }

   @Test
   public void Using_DoubleClick() throws InterruptedException {
      driver.get("https://www.facebook.com/");
      driver.manage().window().maximize();
      Thread.sleep(2000);
      Actions actions=new Actions(driver);
      WebElement MobNum=driver.findElement(By.id("email"));
      WebElement pass=driver.findElement(By.id("pass"));
      actions.doubleClick(pass).perform();
      Thread.sleep(2000);
      actions.doubleClick(MobNum).perform();
      Thread.sleep(2000);
      driver.close();
   }
}