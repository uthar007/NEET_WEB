package com.qa.Testcase;

import Pages.Homepage;
import Pages.MyTestpage;
import Pages.Signinpage;
import Pages.Signuppage;

import com.qa.Base.TestBase;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;

public class Signinpage_test extends TestBase {
    Signinpage signinpage;
    Signuppage signuppage;
    MyTestpage myTestpage;
    Homepage homepage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        signinpage=new Signinpage();
        myTestpage=new MyTestpage();
        homepage=new Homepage();
        signuppage=new Signuppage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_gettitle(){
        String title=driver.getTitle();
        softAssert(title,"M-tutor NEET");
    }
    @Test
    public void forgotlinkcheck() throws InterruptedException{
        signinpage.forgotlink();
        driver.navigate().back();
        
    }
    @Test
    public void signuplinkcheck() throws InterruptedException{
        signinpage.signuplink();
        signuppage.signinlink();
       
    }
    @Test
    public void emptysigin() throws InterruptedException {
        signinpage.clearall();
        signinpage.pressSignin();
        softAssert(signinpage.errortextmob.getText(),"Please Enter Mobile Number");
        softAssert(signinpage.errortextpwd.getText(),"Please Enter Password");
       
    }
	@Test
    public void mobonlysigin() throws InterruptedException  {
        signinpage.clearall();
        signinpage.entermobile("9566229711");
        signinpage.pressSignin();
        softAssert(signinpage.errortextpwd.getText(),"Please Enter Password");
        
	}
    @Test
    public void pwdonlysigin() throws InterruptedException   {
        signinpage.clearall();
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        softAssert(signinpage.errortextmob.getText(),"Please Enter Mobile Number");
        
    }
    @Test
    public void unregistereduser() throws InterruptedException, AWTException {
    	 signinpage.clearall();
         signinpage.entermobile("8667651940");
         signinpage.enterpwd("abc123");
         signinpage.pressSignin();
         Thread.sleep(1000);
         String s1=signinpage.errorpopup.getText();
         Assert.assertEquals(s1,"Sorry ! You don't have an account, proceed to Register\n"
         		+ "OK");
         javascriptclick(signinpage.btnerrorok);
        
    }
    @Test
    public void invalidpwd() throws AWTException, InterruptedException {
        signinpage.clearall();
        signinpage.entermobile("9566229711");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        Thread.sleep(2000);
        String s1=signinpage.errorpopup.getText();
        Assert.assertEquals(s1,"Incorrect password..!\n"
        		+ "OK");
        javascriptclick(signinpage.btnerrorok);
       
    }
    
    @Test(priority = 1)
    public void Siginusingvalidinputs() throws InterruptedException {
        signinpage.clearall();
        signinpage.entermobile("9566229711");
        signinpage.enterpwd("abc123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));
    }
}
