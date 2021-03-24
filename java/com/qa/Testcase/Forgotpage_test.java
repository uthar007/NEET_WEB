package com.qa.Testcase;

import Pages.Forgotpage;
import Pages.Otpforgotpage;
import Pages.Signinpage;
import com.qa.Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Forgotpage_test extends TestBase {
    Signinpage signinpage;
    Forgotpage forgotpage;
    Otpforgotpage otpforgotpage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        signinpage=new Signinpage();
        forgotpage=new Forgotpage();
        otpforgotpage=new Otpforgotpage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_forgotTitle(){
        signinpage.forgotlink();
        softAssert(forgotpage.title.getText(),"FORGOT PASSWORD");
    }

    @Test
    public void emptysubmit(){
        forgotpage.pressSubmit();
        softAssert(forgotpage.errortext.getText(),"Please Enter Mobile Number");
    }
    @Test
    public void invalidmob(){
        forgotpage.entermobile("8667651");
        forgotpage.pressSubmit();
        softAssert(forgotpage.errortext.getText(),"Mobile Number looks incorrect");
    }
    @Test(priority = 1)
    public void validmob() throws InterruptedException {
        forgotpage.entermobile("8667651940");
        forgotpage.pressSubmit();
    }
    @Test(priority = 2)
    public void backbutton(){
        driver.navigate().back();
        forgotpage.pressBack();
    }
}
