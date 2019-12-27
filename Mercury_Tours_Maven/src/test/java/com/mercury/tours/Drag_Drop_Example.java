package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Drag_Drop_Example {
	ChromeDriver driver;
	//FirefoxDriver driver=new FirefoxDriver();
	
  @Test
  public void Sign_On() throws InterruptedException {
	 // driver.findElement(By.linkText("SIGN-ON")).click();
	//WebElement element =driver.findElementByXPath("//a[contains(text(),'My Account')]");
	Actions action=new Actions(driver);
	WebElement drag=driver.findElementById("draggable");
	WebElement drop=driver.findElementById("droppable");
	action.dragAndDrop(drag, drop).build().perform();
	Thread.sleep(5000);
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
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
