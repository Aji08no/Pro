package Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

    private static ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
     private static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        String path = System.getProperty("user.dir") + "//Extent.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(path);

        spark.config().setDocumentTitle("Test Script");
        spark.config().setReportName("Test Web");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("", "");
        extent.setSystemInfo("Tester", "Your Name");
    }

    @Override
    public void onTestStart(ITestResult result) {
          extentTest = extent.createTest(result.getMethod().getMethodName());
//        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
//        test.get().pass("Test Passed");
        extentTest.log(Status.PASS,"");
    }

    @Override
    public void onTestFailure(ITestResult result) {
//        test.get().fail("Test Failed: " + result.getThrowable());
        extentTest.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
//        test.get().skip("Test Skipped: " + result.getThrowable());
        extentTest.log(Status.SKIP,"");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
