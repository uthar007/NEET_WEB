package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Profilepage extends TestBase {
    @FindBy(id = "profilename")
    private WebElement pname;

    @FindBy(id = "profileemail")
    private WebElement pemail;

    @FindBy(id = "location")
    private WebElement plocation;

    @FindBy(xpath ="//button[@class='login100-form-btn' and not(@disable)]")
    private WebElement btnsave;

    @FindBy(css = "body > div.sweet-alert.showSweetAlert.visible > p")
    public WebElement errorpopup;

    @FindBy(css="body > div.sweet-alert.showSweetAlert.visible > div.sa-button-container > div > button")
    private WebElement btnok;

    @FindBy(id = "wizard-picture")
    private WebElement uploadpic;

    @FindBy(xpath = "//i[@class=' dw dw-left-arrow1' and not(@disable)]")
    private WebElement Backarrow;


    public void enterpname(String name){
        sendkeys(pname,name);
    }
    public void enterpemail(String email){
        sendkeys(pemail,email);
    }
    public void enterpLoc(String loc){
        sendkeys(plocation,loc);
    }
    public void presssave() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnsave);
    }
    public void clickokbtn() {
        waitForVisibility(btnok);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", btnok);
    }
    public void setUploadpicrandom(){
        WebElement e=driver.findElement(By.id("wizard-picture"));
        Random rand = new Random();
        List<String> givenList = Arrays.asList
                ("D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\SampleJPGImage_1mbmb.jpg",
                        "D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\SamplePNGImage_500kbmb.png",
                        "D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\SampleJPGImage_2mbmb.jpg",
                        "D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\SamplePNGImage_1mbmb.png");

        int numberOfElements =2 ;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            e.sendKeys(randomElement);
        }
    }
    public void uploadBigfile() throws InterruptedException {
        WebElement e=driver.findElement(By.id("wizard-picture"));
        e.sendKeys("D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\SampleJPGImage_5mbmb (1).jpg");
    }
    public void uploadInvalidfile() throws InterruptedException {
        WebElement e=driver.findElement(By.id("wizard-picture"));
        e.sendKeys("D:\\NEET_WEB-master\\src\\main\\resources\\File upload\\2mb.pdf");
    }
    public void setBackarrow(){
        click(Backarrow);
    }
    public void clearall(){
        clear(pname);
        clear(pemail);
        clear(plocation);
    }
}
