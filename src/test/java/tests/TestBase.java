package tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Capture;

public abstract class TestBase {
	public WebDriver driver = null;
	
	 static ExtentReports reports;
	  static ExtentTest test;
	  String browserType="chrome";
		String URL="https://floward.com/en-ae"; 
		
	//intialize Extent report	
	@BeforeClass
	public void startReport() {
		String FileName = "Report"+".html";
		String directory = System.getProperty("user.dir") + "/reports/";
		new File(directory).mkdirs();
		String FullPath = directory + FileName;
        reports = new ExtentReports(FullPath, true);
	}
	//Setup chrome or firfox  
	@BeforeMethod
	public void setup(Method m) throws InterruptedException {
		
        test = reports.startTest(m.getName());
		
        System.out.println("TestBase.setup()");
		
		
        switch(browserType) {
    	
    	case "chrome":
    		WebDriverManager.chromedriver().setup();
    	    driver= new ChromeDriver();
		break;
		
    	case "firefox":
    		WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    		
    	break;
    		
		default:
			break;
}
		  driver.navigate().to(URL);
		
	}
	
	//Getting test result and add screen shoot
	 @AfterMethod
     public void setTestResult(ITestResult result) throws IOException {
                
                 if (result.getStatus() == ITestResult.FAILURE) {
                             test.log(LogStatus.FAIL, result.getName());
                             test.log(LogStatus.FAIL,result.getThrowable() +test.addScreenCapture(Capture.captureScreen(driver)));
                 } else if (result.getStatus() == ITestResult.SUCCESS) {
                             test.log(LogStatus.PASS, result.getName());
                            
                 } else if (result.getStatus() == ITestResult.SKIP) {
                             test.log(LogStatus.SKIP,"Test Case : " + result.getName() + " has been skipped");
                 }
                 
                 reports.endTest(test);
         		 
     }
	
      @AfterClass
      public void close() {
    	  reports.flush();
    	  driver.quit();
      }
	
}
