package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signinpage extends TestBase {
    @FindBy(xpath = "//div[@class=\"sign-form-title mb-4\"]")
    public WebElement signintitle;

    @FindBy(id = "mobile_no")
    private WebElement fieldmob;

    @FindBy(id = "password")
    private WebElement fieldpwd;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[6]/div/button")
    private WebElement btnsigin;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[5]/a")
    private WebElement forgotlink;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[7]/a")
    private WebElement signuplink;


    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/div/div[3]/small")
    public WebElement errortextmob;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[3]/small")
    public WebElement errortextpwd;

    @FindBy(xpath = "/html/body/div[4]")
    public WebElement errorpopup;

    @FindBy(xpath="//button[text()='OK']")
    public WebElement btnerrorok;

    @FindBy(xpath = " //div[@class='loading-text' and not(@disable)]")
    private WebElement loadingpage;



    public Signinpage entermobile(String mob){
        sendkeys(fieldmob,mob);
        return this;
    }
    public Signinpage enterpwd(String pwd){
        sendkeys(fieldpwd,pwd);
        return this;
    }
    public void pressSignin(){

        click(btnsigin);
    }
    public void signin(String mob,String pwd){
        sendkeys(fieldmob,mob);
        sendkeys(fieldpwd,pwd);
    }

    public String geterrortext(WebElement e){
        return getAttribute(e,"Text");
    }
    public void errorok(WebElement e){
        click(e);
    }
    public Forgotpage forgotlink(){
        click(forgotlink);
        return new Forgotpage();
    }
    public Signuppage signuplink(){
        click(signuplink);
        return new Signuppage();
    }
    public Signinpage clearall() {
        clear(fieldmob);
        clear(fieldpwd);
        return this;
    }
    public void loading(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) loadingpage));

    }
}
