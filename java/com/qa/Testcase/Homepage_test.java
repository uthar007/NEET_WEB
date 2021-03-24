package com.qa.Testcase;

import Pages.Homepage;
import Pages.Signinpage;
import Pages.Testpage;
import com.qa.Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class Homepage_test extends TestBase{
    Homepage homepage;
    Signinpage signinpage;
    Testpage testpage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {
        homepage=new Homepage();
        signinpage=new Signinpage();
        testpage=new Testpage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_Sigin() throws InterruptedException {
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));


    }
    @Test
    public void attenttestPhysics(){
        homepage.selectsub(homepage.subject("Physics"));
        driver.navigate().back();
        homepage.selectsub(homepage.subject("Chemistry"));
        driver.navigate().back();
        homepage.selectsub(homepage.subject("Biology"));
        driver.navigate().back();
        homepage.selectsub(homepage.subject("All Subjects"));
        driver.navigate().back();
        homepage.selectsub(homepage.subject("Download"));
        driver.navigate().back();
    }
    @Test
    public void latest(){
        homepage.selectsub(homepage.Latest);
        testpage.pressinstruction();
        testpage.presshomemenu();
    }

    @Test
    public void recentActivities() throws Exception {
        int i;
        homepage.selectsub(homepage.subject("Physics"));
        fluentwait();
        elementvisible(testpage.testset("Physics 1",1));
        testpage.pressinstruction();
        String count=testpage.count.getText();
        System.out.println(count);
        int qcount=Integer.parseInt(count);
        for (i= 0;i<qcount;i++){
            System.out.println(i);
            testpage.pressfirstoption();
            Thread.sleep(1000);
            testpage.pressSubmitbutton();
            Thread.sleep(1000);
        }
        testpage.presshomemenu();
        String s2=homepage.Recentfirst.getText();
        System.out.println(s2);
       // softAssert(s1,s2);
    }
    @Test(priority = 5)
    public void logout() throws InterruptedException {
        Thread.sleep(2000);
        scrolltillend();
        homepage.logout();
    }
}
