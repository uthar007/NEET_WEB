package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Otpforgotpage extends TestBase {
    @FindBy(xpath = "//div[@class=\"sign-form-title mb-4\"]")
    public WebElement otptitle;

    @FindBy(xpath = "//*[@id=\"partitioned\"]")
    private WebElement otpfield;

    @FindBy(xpath = "//*[@id=\"otp_submit\"]")
    private WebElement btnproceed;

    @FindBy(xpath = "//*[@id=\"forgot_otp_submit\"]/div[3]/div/button[1]")
    private WebElement btnback;

    @FindBy(id = "resend_proceed")
    private WebElement resend;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement alertpopup;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    public WebElement alertpopupok;

    public Otpforgotpage enterotp(String otp) {
        sendkeys(otpfield,otp);
        return this;
    }
    public Otpforgotpage pressproceed() {
        click(btnproceed);
        return this;
    }
    public Otpforgotpage pressBack() {
        click(btnback);
        return this;
    }
    public Otpforgotpage presresend() {
        click(resend);
        return this;
    }
}
