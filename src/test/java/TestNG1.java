

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class TestNG1 {
   static ExtentHtmlReporter reporter;
    static ExtentReports extentReports;
  @Test
  public  void test1() throws IOException {
    Assert.assertTrue(true, " Test1");
    ExtentTest test = extentReports.createTest("Test1");
    test.assignAuthor("vishnu");
    //Screenshot for each step
    test.fail("Step1", MediaEntityBuilder.createScreenCaptureFromPath("./Image1/1.jpg").build());
    test.log(Status.WARNING, "Step 2 Details");
    test.log(Status.ERROR, "Step 3 Details");
    test.log(Status.FAIL, "Step 4 Details");
    test.log(Status.FAIL, "Failed");
    //Adding screenshots
    try {
        test.addScreenCaptureFromPath("./Image1/1.jpg");
        test.addScreenCaptureFromPath("./Image2/1.jpg");

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}
 @Test
  public  void test2() {
        ExtentTest test = extentReports.createTest("Test2");
    test.log(Status.INFO, "Testing Test2");
    test.log(Status.PASS, "Passed");


}
@BeforeMethod
    public void beforeMethod(){
    System.out.println("before method");

}

@BeforeTest
  public void beforeTest(){
  System.out.println("before test");
    reporter = new ExtentHtmlReporter("1.html");
    extentReports = new ExtentReports();
    extentReports.attachReporter(reporter);

}
 @AfterMethod
 public void afterMethod(){
 System.out.println("after method");
 extentReports.flush();
}

 @AfterTest
  public void afterTest(){
   System.out.println("after test");
}

}
