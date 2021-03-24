package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Changepasswordpage extends TestBase {


    @FindBy(id = "password")
    private WebElement edttxtpwd;

    @FindBy(id = "confirm_password")
    private WebElement edttxtconpwd;

    @FindBy(xpath= "//*[@id=\"validate-form\"]/div[4]/div/button")
    private WebElement btnsubmit;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement popup;

    @FindBy(css="body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    public WebElement popupok;

    public void enterpwd(String Input){
       sendkeys(edttxtpwd,Input);
    }
    public void enterconpwd(String Input){
        sendkeys(edttxtconpwd,Input);
        scrollend();
    }
    public void pressSubmitbutton(){
        click(btnsubmit);
    }
   public void clearall(){
        clear(edttxtpwd);
        clear(edttxtconpwd);
    }

}
