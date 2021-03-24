package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTestpage extends TestBase {
    @FindBy(xpath = "//*[@id=\"subject-wrap\"]/div/div[1]/div/div[1]/h5")
    public WebElement Title;




}
