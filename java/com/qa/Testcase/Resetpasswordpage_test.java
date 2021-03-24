package com.qa.Testcase;

import Pages.*;
import com.qa.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.GmailQuickstart;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

public class Resetpasswordpage_test extends TestBase {
    Signinpage signinpage;
    Resetpasswordpage resetpasswordpage;
    Forgotpage forgotpage;
    Otpforgotpage otpforgotpage;
    Changepasswordpage changepasswordpage;
    Homepage homepage;
    GmailQuickstart gmailQuickstart;
    @BeforeMethod
    public void beforeMethod(Method m) {
        resetpasswordpage = new Resetpasswordpage();
        signinpage = new Signinpage();
        forgotpage=new Forgotpage();
        otpforgotpage=new Otpforgotpage();
        changepasswordpage = new Changepasswordpage();
        homepage = new Homepage();
        gmailQuickstart=new GmailQuickstart();
        System.out.println("\n" + "****** Starting Test:" + m.getName() + "*****" + "\n");
    }

    @Test
    public void a_gotoresetpage() throws InterruptedException, IOException, GeneralSecurityException {
        signinpage.forgotlink();
        forgotpage.entermobile("8667651940");
        forgotpage.pressSubmit();
        otpforgotpage.enterotp(gmailQuickstart.getmailotp());
        otpforgotpage.pressproceed();
        softAssert(resetpasswordpage.Resettitle.getText(),"RESET PASSWORD");
    }

    @Test(dependsOnMethods = "a_gotoresetpage")
    public void emptypwd() throws InterruptedException, AWTException {
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Please Enter Password"));
        click(resetpasswordpage.popupok);

    }

    @Test(dependsOnMethods = "a_gotoresetpage")
    public void pwdonly() throws InterruptedException, AWTException {
        resetpasswordpage.enterpwd("abc@123");
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Please Enter Confirm Password"));
        Thread.sleep(2000);
        click(resetpasswordpage.popupok);
        resetpasswordpage.clearall();
    }

    @Test(dependsOnMethods = "a_gotoresetpage")
    public void invalidpwd() throws InterruptedException, AWTException {
        // homepage.changepassword();
        resetpasswordpage.enterpwd("abc123");
        resetpasswordpage.enterconpwd("abc123");
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Invalid Password"));
        Thread.sleep(2000);
        click(resetpasswordpage.popupok);
        resetpasswordpage.clearall();
    }

    @Test(dependsOnMethods = "a_gotoresetpage")
    public void pwdnotmatch() throws InterruptedException, AWTException {
        //  homepage.changepassword();
        resetpasswordpage.enterpwd("abc@123");
        resetpasswordpage.enterconpwd("abc@12345");
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Password doesn't match"));
        Thread.sleep(2000);
        click(resetpasswordpage.popupok);
        resetpasswordpage.clearall();
    }

    @Test(dependsOnMethods = "a_gotoresetpage")
    public void resetsamepwd() throws InterruptedException, AWTException {
        //  homepage.changepassword();
        resetpasswordpage.enterpwd("abc@123");
        resetpasswordpage.enterconpwd("abc@123");
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Looks you set the old password again ! Please set a new one"));
        Thread.sleep(2000);
        click(resetpasswordpage.popupok);
        resetpasswordpage.clearall();
    }

    @Test(priority = 1)
    public void resetpwd() throws InterruptedException, AWTException {
        resetpasswordpage.enterpwd("abc@12345");
        resetpasswordpage.enterconpwd("abc@12345");
        resetpasswordpage.pressSubmitbutton();
        System.out.println(resetpasswordpage.popup.getText());
        Assert.assertTrue(resetpasswordpage.popup.getText().contains("Password Reset Successfully..!"));
        Thread.sleep(2000);
        click(resetpasswordpage.popupok);
    }
    @Test(priority = 2)
    public void resethelp(){
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@12345");
        signinpage.pressSignin();
        homepage.changepassword();
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@123");
        changepasswordpage.enterconpwd("abc@123");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Password Changed Successfully!"));
    }
}
