package Pages;

import com.qa.Base.TestBase;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Signuppage extends TestBase {
    @FindBy(xpath = "//div[@class=\"sign-form-title mb-4\"]")
    public WebElement signuptitle;

    @FindBy(id = "mobile_no")
    private WebElement fieldmob;

    @FindBy(id = "password")
    private WebElement fieldpwd;

    @FindBy(xpath = "//*[@id=\"register-submit\"]/div[5]/div/button")
    private WebElement btnsigin;

    @FindBy(xpath = "//*[@id=\"register-submit\"]/div[6]/a")
    private WebElement signinlink;

    @FindBy(xpath = "//*[@id=\"register-submit\"]/div[1]/div/div[3]/small")
    public WebElement errortextmob;

    @FindBy(xpath = "//*[@id=\"register-submit\"]/div[3]/small")
    public WebElement errortextpwd;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement errorpopup;

    @FindBy(xpath ="//button[text()='OK']")
    public WebElement errorpopupok;


    public Signuppage entermobile(String mob){
        sendkeys(fieldmob,mob);
        return this;
    }
    public Signuppage enterpwd(String pwd){
        sendkeys(fieldpwd,pwd);
        return this;
    }
    public void pressSignup(){
        click(btnsigin);
    }
    public Signuppage signinlink(){
        click(signinlink);
        return new Signuppage();
    }
    public Signuppage clearall() {
        clear(fieldmob);
        clear(fieldpwd);
        return this;
    }
    public Signuppage errorok() {
    	javascriptclick(errorpopupok);
    	return this;
    }
}
