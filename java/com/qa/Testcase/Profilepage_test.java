package com.qa.Testcase;

import Pages.Homepage;
import Pages.Profilepage;
import Pages.Signinpage;
import com.qa.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Profilepage_test extends TestBase{
    Signinpage signinpage;
    Profilepage profilepage;
    Homepage homepage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        signinpage=new Signinpage();
        profilepage=new Profilepage();
        homepage= new Homepage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test(priority = 1)
    public void Sigin() throws InterruptedException {
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));
        waitForVisibility(homepage.title);
        softAssert(homepage.title.getText(),"Welcome !");
    }
    @Test(priority = 2)
    public void emptyprofile() throws InterruptedException {
        homepage.menuclick();
        profilepage.clearall();
        scrollend();
        profilepage.presssave();
        Assert.assertEquals(profilepage.errorpopup.getText(),"Please Enter Username");
        profilepage.clickokbtn();
    }
    @Test(priority = 3)
    public void  pnameonly()throws InterruptedException {
        profilepage.clearall();
        profilepage.enterpname("uthra kumar");
        scrollend();
        profilepage.presssave();
        Assert.assertEquals(profilepage.errorpopup.getText(),"Please Enter Email id");
        profilepage.clickokbtn();
    }
    @Test(priority = 4)
    public void  pnameonlylessthan2()throws InterruptedException {
        profilepage.clearall();
        profilepage.enterpname("uk");
        scrollend();
        profilepage.presssave();
        Assert.assertEquals(profilepage.errorpopup.getText(),"Username should contain atleast 3 characters");
        profilepage.clickokbtn();
    }
    @Test(priority = 5)
    public void pname_pemail() throws InterruptedException {
        profilepage.clearall();
        profilepage.enterpname("uthra kumar");
        profilepage.enterpemail("uthar.a305@gmail.com");
        scrollend();
        profilepage.presssave();
        Assert.assertEquals(profilepage.errorpopup.getText(),"Please Enter your location");
        profilepage.clickokbtn();
    }
    @Test(priority = 6)
    public void pname_Invalidemail() throws InterruptedException {
        profilepage.clearall();
        profilepage.enterpname("uthr kumar");
        profilepage.enterpemail("uthar.a305@");
        scrollend();
        profilepage.presssave();
        softAssert(profilepage.errorpopup.getText(),"Email id looks incorrect");
        profilepage.clickokbtn();
    }
    @Test(priority = 7)
    public void allinputs() throws InterruptedException {
        profilepage.clearall();
        profilepage.enterpname("uthra kumar");
        profilepage.enterpemail("uthar.a305@gmail.com");
        profilepage.enterpLoc("Chennai");
        scrollend();
        profilepage.presssave();
        Assert.assertEquals(profilepage.errorpopup.getText(),"Successfully updated");
        profilepage.clickokbtn();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    public void profileupdate() throws InterruptedException {
        profilepage.setUploadpicrandom();
        Assert.assertEquals(profilepage.errorpopup.getText(),
                "Your profile picture has been updated");
        Thread.sleep(1000);
        profilepage.clickokbtn();
        Thread.sleep(1000);
    }
    @Test(priority = 9)
    public void profileupdateinvalid() throws InterruptedException {
        profilepage.uploadInvalidfile();
        Assert.assertEquals(profilepage.errorpopup.getText(),
                "Hey! We noticed that you have uploaded an invalid image type");
        profilepage.clickokbtn();
        Thread.sleep(1000);
    }
    @Test(priority = 10)
    public void profileupdatemorethan5mb() throws InterruptedException {
        profilepage.uploadBigfile();
        Assert.assertEquals(profilepage.errorpopup.getText(),
                "Profile image size should be less than 5MB");
        profilepage.clickokbtn();
        Thread.sleep(2000);
    }
    @Test(priority =11)
    public void pressback() throws InterruptedException {
        profilepage.setBackarrow();
        Thread.sleep(5000);
        scrolltillend();
        homepage.logout();
    }

}
