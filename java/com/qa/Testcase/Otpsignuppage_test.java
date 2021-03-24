package com.qa.Testcase;

import Pages.*;
import com.qa.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.GmailQuickstart;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

public class Otpsignuppage_test extends TestBase {
    Signuppage signuppage;
    Signinpage signinpage;
    Forgotpage forgotpage;
    Forgotpage_test forgotpage_test;
    OtpSignuppage otpSignuppage;
    Resetpasswordpage resetpasswordpage;
    GmailQuickstart gmailQuickstart;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        signinpage=new Signinpage();
        signuppage =new Signuppage();
        forgotpage=new Forgotpage();
        otpSignuppage=new OtpSignuppage();
        forgotpage_test=new Forgotpage_test();
        resetpasswordpage=new Resetpasswordpage();
        gmailQuickstart=new GmailQuickstart();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_otptitlecheck() throws InterruptedException {
        signinpage.signuplink();
        softAssert(signuppage.signuptitle.getText(),"SIGN UP");
        signuppage.entermobile("8675485259");
        signuppage.enterpwd("abc@123");
        signuppage.pressSignup();
        Assert.assertTrue(otpSignuppage.otptitle.getText().contains("OTP VERIFICATION"));
    }
    @Test
    public void emptycheck() throws InterruptedException {
        otpSignuppage.pressproceed();
        softAssert(otpSignuppage.errormsg.getText(),"Please Enter OTP");
        Thread.sleep(2000);
    }
    @Test
    public void incorrectotp(){
        otpSignuppage.enterotp("1234");
        otpSignuppage.pressproceed();
        softAssert(otpSignuppage.alertpopup.getText(),"Incorrect OTP");
        click(otpSignuppage.alertpopupok);
    }
    @Test
    public void incomleteotp(){
        otpSignuppage.enterotp("12");
        otpSignuppage.pressproceed();
        softAssert(otpSignuppage.errormsg.getText(),"Invalid OTP");
        otpSignuppage.clear();
    }
    @Test(priority = 1)
    public void validOtp() throws InterruptedException, GeneralSecurityException, IOException {
        otpSignuppage.enterotp(gmailQuickstart.getmailotp());
        otpSignuppage.pressproceed();
        softAssert(signuppage.errorpopup.getText(),"Registered Successfully..!");
        click(signuppage.errorpopupok);
    }
}
