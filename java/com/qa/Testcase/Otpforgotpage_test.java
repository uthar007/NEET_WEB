package com.qa.Testcase;

import Pages.Forgotpage;
import Pages.Otpforgotpage;
import Pages.Resetpasswordpage;
import Pages.Signinpage;
import com.qa.Base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.GmailQuickstart;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.util.Scanner;

public class Otpforgotpage_test extends TestBase {
   Signinpage signinpage;
   Forgotpage forgotpage;
   Forgotpage_test forgotpage_test;
   Otpforgotpage otpforgotpage;
   Resetpasswordpage resetpasswordpage;
   GmailQuickstart gmailQuickstart;
   @BeforeMethod
    public void beforeMethod(Method m)
    {
        signinpage=new Signinpage();
        forgotpage=new Forgotpage();
        otpforgotpage=new Otpforgotpage();
        forgotpage_test=new Forgotpage_test();
        resetpasswordpage=new Resetpasswordpage();
        gmailQuickstart=new GmailQuickstart();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_otptitlecheck() throws InterruptedException {
        signinpage.forgotlink();
        softAssert(forgotpage.title.getText(),"FORGOT PASSWORD");
        forgotpage.entermobile("8667651940");
        forgotpage.pressSubmit();
        Assert.assertTrue(otpforgotpage.otptitle.getText().contains("OTP VERIFICATION"));
    }
    @Test
    public void emptycheck() throws InterruptedException {
       otpforgotpage.pressproceed();
       softAssert(otpforgotpage.alertpopup.getText(),"Please Enter Your OTP");
       click(otpforgotpage.alertpopupok);
       Thread.sleep(2000);
    }
    @Test
    public void incorrectotp(){
        otpforgotpage.enterotp("1234");
        otpforgotpage.pressproceed();
        softAssert(otpforgotpage.alertpopup.getText(),"Incorrect OTP");
        click(otpforgotpage.alertpopupok);
    }
    @Test
    public void incomleteotp(){
        otpforgotpage.enterotp("12");
        otpforgotpage.pressproceed();
        softAssert(otpforgotpage.alertpopup.getText(),"Invalid OTP");
        click(otpforgotpage.alertpopupok);
    }

    //Valid Scenario implemented to resetpassword

}
