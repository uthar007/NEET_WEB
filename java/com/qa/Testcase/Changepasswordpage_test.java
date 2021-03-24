package com.qa.Testcase;

import Pages.Changepasswordpage;
import Pages.Homepage;
import Pages.Signinpage;
import Pages.Testpage;
import com.qa.Base.TestBase;
import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class Changepasswordpage_test extends TestBase {
    Signinpage signinpage;
    Changepasswordpage changepasswordpage;
    Homepage homepage;

    @BeforeMethod
    public void beforeMethod(Method m) {
        changepasswordpage = new Changepasswordpage();
        signinpage = new Signinpage();
        homepage = new Homepage();
        System.out.println("\n" + "****** Starting Test:" + m.getName() + "*****" + "\n");
    }

    @Test
    public void a_sigin() {
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));
        homepage.changepassword();
    }

    @Test
    public void emptypwd() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Please Enter Password"));
        click(changepasswordpage.popupok);
    }

    @Test
    public void pwdonly() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@123");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Please Enter Confirm Password"));
        click(changepasswordpage.popupok);
    }

    @Test
    public void invalidpwd() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc123");
        changepasswordpage.enterconpwd("abc123");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Invalid Password"));
        click(changepasswordpage.popupok);
    }

    @Test
    public void pwdnotmatch() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@123");
        changepasswordpage.enterconpwd("abc@12345");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Password doesn't match"));
        click(changepasswordpage.popupok);
    }

    @Test
    public void changesamepwd() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@123");
        changepasswordpage.enterconpwd("abc@123");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Looks you set the old password again ! Please set a new one"));
        click(changepasswordpage.popupok);
    }

    @Test(priority = 1)
    public void changepwd() throws InterruptedException, AWTException {
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@12345");
        changepasswordpage.enterconpwd("abc@12345");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Password Changed Successfully!"));
        click(changepasswordpage.popupok);
    }
    @Test(priority = 2)
    public void changepwdhelp() throws InterruptedException, AWTException {
        homepage.changepassword();
        changepasswordpage.clearall();
        changepasswordpage.enterpwd("abc@123");
        changepasswordpage.enterconpwd("abc@123");
        changepasswordpage.pressSubmitbutton();
        System.out.println(changepasswordpage.popup.getText());
        Assert.assertTrue(changepasswordpage.popup.getText().contains("Password Changed Successfully!"));
        click(changepasswordpage.popupok);
    }
}

