package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Homepage extends TestBase {


    public WebElement subject(String Subject){
        WebElement e=driver.findElement(By.xpath("//h5[contains(@class,'card-title')] [contains(text(),'"+Subject+"')]"));
        return e;
    }
    public void menuclick() {
        WebElement webElement = driver.findElement(By.xpath("//*[@id=\"accordion-menu\"]/li[3]/a/span[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }
    @FindBy(xpath = "//*[@id=\"accordion-menu\"]/li[5]/a/span[2]")
    private WebElement changepassword;

    @FindBy(xpath = "//*[@id=\"accordion-menu\"]/li[7]/a/span[2]")
    public WebElement contactus;

    @FindBy(xpath = "//*[@id=\"accordion-menu\"]/li[4]/a/span[2]")
    public WebElement mytest;

    @FindBy(xpath = "//*[@id=\"accordion-menu\"]/li[8]/a/span[2]")
    private WebElement logout;

    @FindBy(xpath = "//*[@id=\"bd-logout\"]/div/div/div[1]/div/div")
    private WebElement logoutpop;

    @FindBy(xpath = "//button[@class='btn btn-danger submitbtn px-3']")
    private WebElement logoutok;

    @FindBy(css = "#first_slider > div.owl-wrapper-outer > div > div:nth-child(1) > div > a > div > h5")
    public WebElement Recentfirst;

    @FindBy(xpath = "//*[@id=\"three_slider\"]/div[1]/div/div[1]/div/a/img")
    public WebElement Latest;

    @FindBy(xpath = "//p[contains(@class,'pt-1')] [contains(text(),'Welcome !')]")
    public WebElement title;

    @FindBy(xpath = "//div[@class='pre-loader']")
    public WebElement invisibleelement;



    public void selectsub(WebElement e){
        click(e);
    }

    public void changepassword(){
       elementtoeclickable(changepassword);
    }
    public void contactus(){
        elementtoeclickable(contactus);
    }
    public void mytest(){
        elementtoeclickable(mytest);
    }
    public void logout(){
        waitForVisibility(logout);
        click(logout);
        waitForVisibility(logoutpop);
        String popup=logoutpop.getText();
        System.out.println(popup);
        Assert.assertTrue(popup.contains("Are you sure you want to logout?"));
        click(logoutok);
    }
}
