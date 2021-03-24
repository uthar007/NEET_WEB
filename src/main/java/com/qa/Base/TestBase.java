package com.qa.Base;


import Pages.Signinpage;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.TestUtil;
import utils.WebEventListener;


public class TestBase {

    WebDriverWait wait;

    public static WebDriver driver;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PageFactory.initElements(driver, this);
    }
    @Parameters({"URl"})
    @BeforeTest
    public static void initialization(String URl){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "D://NEET_WEB-master//src//test//java//Resource//Driver//chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "");
            driver = new FirefoxDriver();
        }


        /*e_driver = new EventFiringWebDriver(driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;*/

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(URl);



    }
    public void waitForVisibility(WebElement e) {
        wait = new WebDriverWait (driver, TestUtil.Wait);
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void exceptedcondition(WebElement e) {
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void sendkeys(WebElement e,String Input){
        waitForVisibility(e);
        e.sendKeys(Input);
    }
    public void click(WebElement e){
        waitForVisibility(e);
        e.click();
    }
    public void softAssert(Object actual, Object expected) {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        SoftAssert sa=new SoftAssert();
        sa.assertEquals(actual, expected);
        sa.assertAll();
    }
    public String getAttribute(WebElement e,String attribute) {
        waitForVisibility(e);
        return e.getAttribute(attribute);
    }
    public Signinpage clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
        return null;
    }
    public void swap(WebElement e){
        waitForVisibility(e);
        Alert alert= driver.switchTo().alert();
        alert.accept();
    }
    public void pageload(){
     new WebDriverWait(driver, 120).until(
             webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void scrollend(){
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void elementtoeclickable(WebElement e){
        wait = new WebDriverWait (driver, 200);
        WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(e));
        click(e1);
    }
    public WebElement elementvisible(WebElement e){
        wait = new WebDriverWait (driver,200);
        WebElement e1 = wait.until(ExpectedConditions.visibilityOf(e));
        click(e1);
        return e1;
    }
    public void visible(WebElement e){
        wait = new WebDriverWait (driver, 200);
        WebElement e1 = wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void invisble(WebElement e){
        wait = new WebDriverWait(driver, 200);
        Boolean e1=wait.until(ExpectedConditions.invisibilityOf(e));
    }
    public void fluentwait(){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(200, TimeUnit.SECONDS)
                .pollingEvery(50, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
    }


    public void keyboardenterkey() throws AWTException {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    public void scrolltillend(){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"accordion-menu\"]/li[8]/a/span[2]"));
        Coordinates coordinate = ((Locatable)element).getCoordinates();
        coordinate.onPage();
        coordinate.inViewPort();
    }
    public void javascriptclick(WebElement e){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();",e);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
