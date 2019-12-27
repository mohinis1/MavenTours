package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Parameter_Sign_On {
	FirefoxDriver driver;

	  @Test
	  @Parameters({"url","uname","upass"})
	  public void Flight_Login(String url,String uname,String upass) {
		    driver.get(url);
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();
			//driver.findElement(By.name("SIGN-OFF")).click();
	  }
	  @BeforeTest
	  public void LaunchBrowser() {
		    String absolutePath=System.getProperty("user.dir");
		    String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", filePath);
			driver=new FirefoxDriver();
			//driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("http://newtours.demouat.com/mercurywelcome.php");
	  }

	  @AfterTest
	  public void CloseBrowser() {
		  driver.quit();
	  }

	}


