package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Mouse_Hovering_Example {
	ChromeDriver driver;
	//FirefoxDriver driver=new FirefoxDriver();
	
  @Test
  public void Sign_On() {
	 // driver.findElement(By.linkText("SIGN-ON")).click();
	WebElement element =driver.findElementByXPath("//a[contains(text(),'My Account')]");
	Actions action=new Actions(driver);
	action.moveToElement(element).build().perform();
	driver.findElementById("signInBtn").click();
  }
  @BeforeTest
  public void LaunchBrowser() {
	  String absolutePath=System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath=absolutePath+"\\Drivers"+"\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", filePath);
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.yatra.com/");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
