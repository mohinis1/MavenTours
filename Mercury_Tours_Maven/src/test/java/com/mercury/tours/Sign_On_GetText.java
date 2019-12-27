package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_GetText {
	//ChromeDriver driver;
	//ChromeOptions options=new ChromeOptions();
	FirefoxDriver driver;
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("testing");
		//driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
		WebElement element=driver.findElement(By.linkText("SIGN-OFF"));
		String Actvalue=element.getText();
		String Expvalue="SIGN-OFF";
		System.out.println(Actvalue);
		Assert.assertEquals(Expvalue, Actvalue);
		
		String ExpUrl="http://newtours.demouat.com/mercuryreservation.php";
		String ActUrl=driver.getCurrentUrl();
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(ExpUrl, ActUrl);
		
		String ExpTitle="Find a Flight: Mercury Tours:";
		String ActTitle=driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(ExpTitle, ActTitle);
		element.click();
		
  }
  @BeforeTest
  public void LaunchBrowser() {

	    String absolutePath=System.getProperty("user.dir");
		/*String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		driver=new ChromeDriver(options);*/
	   	String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filePath);
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurysignon.php");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
