package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Contactuspage extends TestBase {
    @FindBy(id = "name")
    private WebElement edttxtname;

    @FindBy(id= "email")
    private WebElement edttxtemail;

    @FindBy(id = "contact_text")
    private WebElement edtcontacttext;

    @FindBy(id= "contact_us_button")
    private WebElement submit;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement popup;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    public WebElement popupok;

    @FindBy(css= "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement successpopup;

    @FindBy(xpath = "//*[@id=\"accordion-menu\"]")
    public WebElement menu;

    public void entername(String Input){
        sendkeys(edttxtname,Input);
    }
    public void enteremail(String Input){
        sendkeys(edttxtemail,Input);
    }
    public void entercontent(String Input){
        sendkeys(edtcontacttext,Input);
    }

    public void pressSubmitbutton(){
        click(submit);
    }
    public void clearall(){
        clear(edttxtname);
        clear(edttxtemail);
        clear(edtcontacttext);
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

    public void scolltillcontactus() throws InterruptedException {
        WebElement element =driver.findElement(By.xpath("//*[@id=\"accordion-menu\"]/li[7]/a/span[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);

    }
}
