package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtpSignuppage extends TestBase {
    @FindBy(xpath = "//div[@class=\"sign-form-title mb-4\"]")
    public WebElement otptitle;

    @FindBy(xpath = "//*[@id=\"partitioned\"]")
    private WebElement otpfield;

    @FindBy(xpath = "//*[@id=\"myBtn\"]")
    private WebElement btnproceed;

    @FindBy(xpath = "//*[@id=\"reg-otp-form\"]/div[4]/div/button[1]")
    private WebElement btnback;

    @FindBy(id = "resend_proceed")
    private WebElement resend;

    @FindBy(xpath = "//*[@id=\"reg-otp-form\"]/div[2]/small")
    public WebElement emptyerror;

    @FindBy(xpath = "//*[@id=\"reg-otp-form\"]/div[2]/small")
    public WebElement errormsg;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement alertpopup;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    public WebElement alertpopupok;

    public OtpSignuppage enterotp(String otp) {
        sendkeys(otpfield,otp);
        return this;
    }
    public OtpSignuppage pressproceed() {
        click(btnproceed);
        return this;
    }
    public OtpSignuppage pressBack() {
        click(btnback);
        return this;
    }
    public OtpSignuppage presresend() {
        click(resend);
        return this;
    }
    public OtpSignuppage clear(){
        clear(otpfield);
        return this;
    }
}

