package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Capture_Screenshot_Example {
	//ChromeDriver driver;
	WebDriver driver;
	 //String filePath;
	//filePath="C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\Screenshot";
	
	
	 @Test
	  public void Sign_On() {
		  driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("logins")).click();
	  }
	 @AfterMethod
	 public void teardown(ITestResult result) throws IOException
	 {
		 if(ITestResult.FAILURE==result.getStatus())
		 {
			 File Browserscreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Browserscreenshot, new File("C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\Screenshot"));
			//FileUtils.copyFile(Browserscreenshot, new File(filePath+"/"+result.getName()+"_"+System.nanoTime()+".png"));
		 }
		 driver.quit();
	 }
	
	  @BeforeTest
	  public void LaunchBrowser() {
		  String absolutePath=System.getProperty("user.dir");
		
			String filePath1=absolutePath+"\\Drivers"+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filePath1);
			driver=new FirefoxDriver();
			driver.get("http://newtours.demoaut.com/");
			driver.manage().window().maximize();
			
	  }
 /* @AfterTest
  public void CloseBrowser() {
	//  driver.quit();
  }*/

}
