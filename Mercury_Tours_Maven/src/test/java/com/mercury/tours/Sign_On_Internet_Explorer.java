package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_Internet_Explorer {
	InternetExplorerDriver driver;

  @Test
  public void Sign_On() throws InterruptedException {
	  driver.get("http://newtours.demoaut.com");
	  driver.findElement(By.linkText("SIGN-ON")).click();
	 // driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("testing");
		driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		
		
		
  }
  @BeforeTest
  public void LaunchBrowser() {

	    String absolutePath=System.getProperty("user.dir");
		String filePath=absolutePath+"\\Drivers"+"\\IEDriverServer.exe";
		System.setProperty("webdriver.ie.driver", filePath);
		///driver=new FirefoxDriver();
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		//driver.get("http://newtours.demoaut.com");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
