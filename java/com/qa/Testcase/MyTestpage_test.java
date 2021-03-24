package com.qa.Testcase;

import Pages.*;
import com.qa.Base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class MyTestpage_test extends TestBase {
    Signinpage signinpage;
    Homepage homepage;
    MyTestpage myTestpage;
    Testpage testpage;
    @BeforeMethod
    public void beforeMethod(Method m)
    {

        signinpage=new Signinpage();
        homepage=new Homepage();
        myTestpage=new MyTestpage();
        testpage=new Testpage();
        System.out.println("\n" + "****** Starting Test:"+ m.getName() +"*****"+"\n");
    }
    @Test
    public void a_sigin() throws InterruptedException {
        signinpage.entermobile("8667651940");
        signinpage.enterpwd("abc@123");
        signinpage.pressSignin();
        invisble(homepage.invisibleelement);
        exceptedcondition(homepage.subject("Physics"));
    }
    @Test
    public void mytest() throws Exception {
        int i;
        homepage.selectsub(homepage.subject("Physics"));
        fluentwait();
        elementvisible(testpage.testset("Physics 2",1));
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
        homepage.mytest();
        String s2=myTestpage.Title.getText();
        System.out.println(s2);
      //  softAssert(s1,s2);
    }
}

