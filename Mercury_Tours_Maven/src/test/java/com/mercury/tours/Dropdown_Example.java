package com.mercury.tours;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Dropdown_Example {
	ChromeDriver driver;
	ChromeOptions options=new ChromeOptions();
	
  @Test
  public void Sign_On() throws InterruptedException {
	  driver.findElement(By.linkText("SIGN-ON")).click();
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("testing");
		//driver.findElement(By.name("userName")).sendKeys("testing");
		driver.findElement(By.name("password")).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		Thread.sleep(6000);
			
		
		//To verify where roundtrip is selected or not
		String str=driver.findElement(By.xpath("//input[@value='roundtrip']")).getAttribute("checked");
		if(str.equalsIgnoreCase("true"))
		{
			System.out.println("Roundtrip is selected");
		}
		
		//Radio button Oneway
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		
		//to verify whether oneway get selected or not post click
		WebElement ele=driver.findElement(By.xpath("//input[@value='oneway']"));
		Assert.assertEquals(ele.isSelected(), true);
		Thread.sleep(5000);
		
		Select SelectPass = new Select(driver.findElement(By.name("passCount")));
		SelectPass.selectByValue("4");
		
		Select oselect=new Select(driver.findElement(By.name("fromPort")));
		oselect.selectByValue("London");
		driver.findElementByXPath("//input[@value='Business']").click();
		//Continue button
		driver.findElementByName("findflights").click();
		
	
		
		
		
  }
  @BeforeTest
  public void LaunchBrowser() {

	    String absolutePath=System.getProperty("user.dir");
		String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://newtours.demouat.com/mercurywelcome.php");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
