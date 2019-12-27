package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Sign_On_Read_Properties_File {
	//ChromeDriver driver;
	FirefoxDriver driver;
	File file=new File("C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours_Maven\\Mercury_Tours.properties");
	Properties prop=new Properties();
  @Test
  public void Sign_On() {
	
		driver.get(prop.getProperty("URL"));		
		driver.manage().window().maximize();
	    driver.findElement(By.linkText(prop.getProperty("Isignon"))).click();
		driver.findElement(By.name(prop.getProperty("Iusername"))).sendKeys("testing");
		driver.findElement(By.name(prop.getProperty("Inuserpass"))).sendKeys("testing");
		driver.findElement(By.name("login")).click();
		//driver.quit();
  }
  @BeforeTest
  public void LaunchBrowser() throws IOException {
	  String absolutePath=System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filePath);
		driver=new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours\\chromedriver.exe");
		//driver=new ChromeDriver();
		FileInputStream fileInput=new FileInputStream(file);
		prop.load(fileInput);
	
		
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
