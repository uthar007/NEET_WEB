package com.qa.Testcase;

import Pages.*;
import com.qa.Base.TestBase;
import org.apache.poi.util.SystemOutLogger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class Signuppage_test extends TestBase {
    Signinpage signinpage;
    MyTestpage myTestpage;
    Homepage homepage;
    Signuppage signuppage;
    Otpforgotpage otpforgotpage;

    @BeforeMethod
    public void beforeMethod(Method m) {
        otpforgotpage = new Otpforgotpage();
        signinpage = new Signinpage();
        myTestpage = new MyTestpage();
        homepage = new Homepage();
        signuppage = new Signuppage();
        System.out.println("\n" + "****** Starting Test:" + m.getName() + "*****" + "\n");
    }

    @Test
    public void a_gettitle(){
            signinpage.signuplink();
            softAssert(signuppage.signuptitle.getText(),"REGISTER");
    }
    @Test
    public void signinlinkcheck(){
        signuppage.signinlink();
        Assert.assertEquals(signinpage.signintitle.getText(),"SIGN IN\n"
        		+ "We are happy to see you again!");
        signinpage.signuplink();
        Assert.assertEquals(signuppage.signuptitle.getText(),"REGISTER");
    }
    @Test
    public void emptysigin() {
        signuppage.clearall();
        signuppage.pressSignup();
        softAssert(signuppage.errortextmob.getText(),"Please Enter Mobile Number");
        softAssert(signuppage.errortextpwd.getText(),"Please Enter Password");
    }
    @Test
    public void mobonlysigup()  {
        signuppage.clearall();
        signuppage.entermobile("8667651940");
        signuppage.pressSignup();
        softAssert(signuppage.errortextpwd.getText(),"Please Enter Password");
    }
    @Test
    public void pwdonlysigin()   {
        signuppage.clearall();
        signuppage.enterpwd("abc123");
        signuppage.pressSignup();
        softAssert(signuppage.errortextmob.getText(),"Please Enter Mobile Number");
    }
    @Test
    public void alreadyregistereduser() throws InterruptedException, AWTException {
        signuppage.clearall();
        signuppage.entermobile("9566229711");
        signuppage.enterpwd("abc123");
        signuppage.pressSignup();
        String s1=signuppage.errorpopup.getText();
        Assert.assertTrue(s1.contains("User already exists, proceed to login"));
        Thread.sleep(1000);
        signuppage.errorok();
    }
    @Test
    public void invalidpwd() throws AWTException, InterruptedException {
        signuppage.clearall();
        signuppage.entermobile("8072243882");
        signuppage.enterpwd("abc@123");
        signuppage.pressSignup();
        String s1=signuppage.errorpopup.getText();
        Assert.assertEquals("Invalid password..!",s1);
        Thread.sleep(1000);
        signuppage.errorok();
    }
    @Test(priority = 1)
    public void Sigupusingvalidinputs() throws InterruptedException {
        signuppage.clearall();
        signuppage.entermobile("8667651940");
        signuppage.enterpwd("abc123");
        signuppage.pressSignup();
        Assert.assertTrue(otpforgotpage.otptitle.getText().contains("OTP VERIFICATION"));
    }
}
