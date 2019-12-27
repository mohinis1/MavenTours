package com.mercury.tours;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class ExtentReport_Example {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	FirefoxDriver driver;

  @Test(priority=2)
  public void Sign_On() throws InterruptedException {
	  
	  test=extent.createTest("Test Case 2","Login to Mercury Web Application");
	  driver.get("http://newtours.demoaut.com");
	  driver.findElementByPartialLinkText("SIGN").click();
	 	driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("logins")).click();
	
  }
  @Test(priority=1)
  public void LaunchBrowser() {
	  
	  test=extent.createTest("Test Case 1","Login to Mercury Web Application");
	    String absolutePath=System.getProperty("user.dir");
		String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filePath);
		driver=new FirefoxDriver();
		//driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		//driver.get("http://newtours.demoaut.com");
  }
  @BeforeTest
  public void startReport()
  {
	  //initialize the htmlreporter
	  htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.html");
	  
	  //initialize extentreport and attach htmlreporter
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  //to add system or environ info by using the setSystemInfo method
	  extent.setSystemInfo("OS", "WINDOWS 10");
	  extent.setSystemInfo("Browser", "Firefox 60+");
	  
	  //configure items to change the look and feel
	  //add content manage tests etc
	 // htmlReporter.config().setChartVisibilityOnOpen(true);
	  htmlReporter.config().setDocumentTitle("Extent Report Demo");
	  htmlReporter.config().setReportName("Test Report");
	 // htmlReporter.config().setTestViewChatLocation(ChartLocation.TOP);
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	  
  }
	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"FAILED",ExtentColor.RED));
			test.fail(result.getThrowable());
			// File Browserscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			//	FileUtils.copyFile(Browserscreenshot, new File("C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\Screenshot"));
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"PASSED",ExtentColor.GREEN));
					
		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"SKIPPED",ExtentColor.ORANGE));
			test.skip(result.getThrowable());
			
		}
	}

  
  
  
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
	  //to write or update test information to reporter
	  extent.flush();
  }

}
