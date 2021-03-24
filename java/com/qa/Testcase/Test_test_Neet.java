package com.qa.Testcase;

import Pages.Homepage;
import Pages.Signinpage;
import Pages.Testpage;
import com.qa.Base.TestBase;
import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Constants;
import utils.ExcelUtils;

import java.lang.reflect.Method;

public class Test_test_Neet extends TestBase{
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
        @Test
        public void a_sigin () throws InterruptedException {
            signinpage.entermobile("8667651940");
            signinpage.enterpwd("abc@123");
            signinpage.pressSignin();
            invisble(homepage.invisibleelement);
        }

        @Test
        public void testphysics () throws Exception {
            int j;
            int tot=12;
            for(j=1;j<tot;j++){
                elementvisible(homepage.subject("Physics"));
                fluentwait();
                if(j<=4) {
                    elementvisible(testpage.testset("Physics "+j+"",1));
                }else if (j>4 & j<=8){
                    elementvisible(testpage.testset("Physics "+j+"",2));
                }else{
                    elementvisible(testpage.testset("Physics "+j+"",3));
                }
                testpage.pressinstruction();
                String count = testpage.count.getText();
                System.out.println(count);
                int qcount = Integer.parseInt(count);
                int i;
                for (i = 0; i < qcount; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(3000);
                        testpage.pressfirstoption();
                        testpage.pressSubmitbutton();
                    }  catch (Exception e){
                        testpage.presshomemenu();
                    }
                }
                Thread.sleep(1000);
                testpage.presshomemenu();
                fluentwait();
            }
        }
    @Test
    public void testChemistry () throws Exception {
        int j;
        int tot=12;
        for(j=1;j<tot;j++){
            elementvisible(homepage.subject("Chemistry"));
            fluentwait();
            if(j<=4) {
                elementvisible(testpage.testset("Chemistry "+j+"",1));
            }else if (j>4 & j<=8){
                elementvisible(testpage.testset("Chemistry "+j+"",2));
            }else{
                elementvisible(testpage.testset("Chemistry "+j+"",3));
            }
            testpage.pressinstruction();
            String count = testpage.count.getText();
            System.out.println(count);
            int qcount = Integer.parseInt(count);
            int i;
            for (i = 0; i < qcount; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                    testpage.pressfirstoption();
                    testpage.pressSubmitbutton();
                }  catch (Exception e){
                    testpage.presshomemenu();
                }
            }
            testpage.presshomemenu();
            fluentwait();
        }
    }
    @Test
    public void testBiology () throws Exception {
        int j;
        int tot=12;
        for(j=1;j<tot;j++){
            elementvisible(homepage.subject("Biology"));
            fluentwait();
            if(j<=4) {
                elementvisible(testpage.testset("Biology "+j+"",1));
            }else if (j>4 & j<=8){
                elementvisible(testpage.testset("Biology "+j+"",2));
            }else{
                elementvisible(testpage.testset("Biology "+j+"",3));
            }
            testpage.pressinstruction();
            String count = testpage.count.getText();
            System.out.println(count);
            int qcount = Integer.parseInt(count);
            int i;
            for (i = 0; i < qcount; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                    testpage.pressfirstoption();
                    testpage.pressSubmitbutton();
                }  catch (Exception e){
                    testpage.presshomemenu();
                }
            }
            testpage.presshomemenu();
            fluentwait();
        }
    }
    @Test
    public void testAllsub () throws Exception {
        int j;
        int tot=12;
        for(j=1;j<tot;j++){
            elementvisible(homepage.subject("All Subjects"));
            fluentwait();
            if(j<=4) {
                elementvisible(testpage.testset("Mock Test "+j+"",1));
            }else if (j>4 & j<=8){
                elementvisible(testpage.testset("Mock Test "+j+"",2));
            }else{
                elementvisible(testpage.testset("Mock Test "+j+"",3));
            }
            testpage.pressinstruction();
            String count = testpage.count.getText();
            System.out.println(count);
            int qcount = Integer.parseInt(count);
            int i;
            for (i = 0; i < qcount; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(3000);
                    testpage.pressfirstoption();
                    testpage.pressSubmitbutton();
                } catch (Exception e){
                    testpage.presshomemenu();
                }
            }
            testpage.presshomemenu();
            fluentwait();
        }
    }
}
