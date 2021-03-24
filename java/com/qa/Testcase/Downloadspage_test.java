package com.qa.Testcase;

import Pages.Downloadspage;
import Pages.Homepage;
import Pages.Signinpage;
import Pages.Testpage;
import com.qa.Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Downloadspage_test extends TestBase {
    Signinpage signinpage;
    Homepage homepage;
    Downloadspage downloadspage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        downloadspage=new Downloadspage();
        homepage=new Homepage();
        signinpage=new Signinpage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test(priority = 1)
    public void Sigin() throws InterruptedException {
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));
    }
    @Test(priority = 2)
    public void downloadqb() throws InterruptedException {
        homepage.selectsub(homepage.subject("Download"));
        softAssert(downloadspage.QbTitle.getText(),"DOWNLOAD - Questions and Answers + Solutions");
        click(downloadspage.DownloadQB);
        click(downloadspage.Qbbackarrow);
    }
}
