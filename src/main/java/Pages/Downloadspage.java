package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Downloadspage extends TestBase {
    @FindBy(css = "#download_all > div > div > div.sub-title > p")
    public WebElement DownloadQB;
//a[@class="backLink"]
    @FindBy(xpath = "//a[@class=\"backLink\"]")
    public WebElement QbTitle;
    //*[@id="product"]/div/div[1]/div/div/a/img
    @FindBy(xpath = "//*[@id=\"product\"]/div/div[1]/div/div/a/img")
    public WebElement Qbbackarrow;
}
