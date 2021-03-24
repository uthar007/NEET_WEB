package com.qa.Testcase;

import Pages.Homepage;
import Pages.Signinpage;
import Pages.Testpage;
import com.qa.Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Test_test_JEE extends TestBase {
    Testpage testpage;
    Homepage homepage;
    Signinpage signinpage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        testpage=new Testpage();
        homepage=new Homepage();
        signinpage=new Signinpage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }

        @Test(priority = 1)
        public void Sigin () throws InterruptedException {
            signinpage.entermobile("8667651940");
            signinpage.enterpwd("abc@123");
            signinpage.pressSignin();
            invisble(homepage.invisibleelement);
            softAssert(homepage.title.getText(),"Welcome !");
        }


}
