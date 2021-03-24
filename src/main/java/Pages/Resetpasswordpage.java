package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Resetpasswordpage extends TestBase {
   @FindBy(xpath ="//div[@class=\"sign-form-title mb-4\"]")
   public WebElement Resettitle;

   @FindBy(id = "new_password")
   private WebElement edttxtnewpwd;

   @FindBy(id = "confirm_password")
   private WebElement edttxtconpwd;

   @FindBy(xpath= "//*[@id=\"validate-form\"]/div[6]/div/button")
   private WebElement btnsubmit;

   @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > p")
   public WebElement popup;

   @FindBy(css="body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
   public WebElement popupok;

   public void enterpwd(String Input){
      sendkeys(edttxtnewpwd,Input);
   }
   public void enterconpwd(String Input){
      sendkeys(edttxtconpwd,Input);
      scrollend();
   }
   public void pressSubmitbutton(){
      click(btnsubmit);
   }
   public void clearall(){
      clear(edttxtnewpwd);
      clear(edttxtconpwd);
   }

}
