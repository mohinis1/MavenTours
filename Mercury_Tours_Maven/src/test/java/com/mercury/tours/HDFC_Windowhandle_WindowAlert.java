package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HDFC_Windowhandle_WindowAlert {
	ChromeDriver driver;
	//FirefoxDriver driver=new FirefoxDriver();
	
  @Test
  public void Alert()throws Exception {
	 // driver.findElement(By.linkText("SIGN-ON")).click();
	  	driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		String Actres=driver.switchTo().alert().getText();
		String Expres="Customer ID  cannot be left blank.";
		Assert.assertEquals(Actres, Expres);
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
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
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
