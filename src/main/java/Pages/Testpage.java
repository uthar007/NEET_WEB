package Pages;

import com.qa.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Testpage extends TestBase {
    @FindBy(xpath = "//a[@id='redirect_tag']")
    private WebElement instruction;

    @FindBy(xpath = "//*[@id=\"subject-wrap\"]/div/div/div[1]/div[1]/ul/li[1]/p/span/span[2]")
    public WebElement count;

    @FindBy(xpath = "//*[@id=\"one\"]/ul/li[1] ")
    private WebElement firstoption;

    @FindBy(xpath = "//*[@id=\"subject-wrap\"]/div/div/div[2]/div/div[2]/button[2]")
    private WebElement btnsubmit;

    @FindBy(xpath = "//*[@id=\"product\"]/div/div[1]/div/h5/a/i ")
    public WebElement backarrowque;
    @FindBy(xpath = " //*[@id=\"product\"]/div/div[1]/div/div/a/img")
    public WebElement backarrowtest;

    @FindBy(xpath = "//*[@id=\"accordion-menu\"]/li[2]/a/span[2]")
    private WebElement homemenu;

    public WebElement testset(String Testname, int xpathcase) throws Exception {
         WebElement Testset;
              
        switch (xpathcase) {
            case 1:
                 Testset = driver.findElement(By.xpath("//span[contains(@class,'card-box-footer bg-darkgreen')]" +
                        " [contains(text(),'" + Testname + "')]"));
                System.out.println("Test==================" + Testset.getText());
                break;
            case 2:
                 Testset = driver.findElement(By.xpath("//span[contains(@class,'card-box-footer bg-darkbluen')]" +
                    " [contains(text(),'" + Testname + "')]"));
                System.out.println("Test==================" + Testset.getText());
                break;
            case 3:
                 Testset = driver.findElement(By.xpath("//span[contains(@class,'card-box-footer bg-red')]" +
                        " [contains(text(),'" + Testname + "')]"));
                System.out.println("Test==================" + Testset.getText());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + xpathcase);
        }

        return Testset;
    }




//    public WebElement Testset2(String test) throws Exception {
//        int j;
//        for(j=1;j<tot;i++){
//            WebElement Test=driver.findElement(By.xpath("//span[contains(@class,'card-box-footer bg-darkbluen')]" +
//                    " [contains(text(),'"+ ExcelUtils.getCellData(2,i) +"')]"));
//            return Test;
//        }
//    }
//    public WebElement Testset3(String test){
//        WebElement Test=driver.findElement(By.xpath("//span[contains(@class,'card-box-footer bg-red')]" +
//                " [contains(text(),'"+test+"')]"));
//        return Test;
//    }
    public void selecttest(WebElement e){
        click(e);
    }
    public void pressinstruction(){
        elementvisible(instruction);
        fluentwait();
    }
    public void pressfirstoption() throws InterruptedException {
        visible(firstoption);
        elementtoeclickable(firstoption);
        scrollend();
    }
    public void pressSubmitbutton() throws InterruptedException {
        visible(btnsubmit);
        elementtoeclickable(btnsubmit);
    }
    public Homepage presshomemenu(){
        pageload();
        elementvisible(homemenu);
        return new Homepage();
    }

}
