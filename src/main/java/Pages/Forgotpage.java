package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Forgotpage extends TestBase {
    @FindBy(xpath = "//div[@class=\"sign-form-title mb-5\"]")
    public WebElement title;

    @FindBy(id = "mobile_no")
    private WebElement edttxtmob;

    @FindBy(xpath = "//*[@id=\"forgot_password\"]/div[2]/div/button[1]")
    private WebElement btnback;

    @FindBy(id = "forgot_password_submit")
    private WebElement btnsubmit;

    @FindBy(xpath = "//*[@id=\"forgot_password\"]/div[1]/div/div[3]/small")
    public WebElement errortext;

    @FindBy(xpath = "//*[@id=\"forgot_password\"]/div[1]/div/div[3]/small")
    private WebElement errortxt;

    public Forgotpage entermobile(String mob) {
        sendkeys(edttxtmob, mob);
        return this;
    }
    public Forgotpage pressSubmit() {
        click(btnsubmit);
        return this;
    }
    public Forgotpage pressBack() {
        click(btnback);
        return this;
    }
}
