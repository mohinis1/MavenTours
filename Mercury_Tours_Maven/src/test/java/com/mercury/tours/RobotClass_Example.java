package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class RobotClass_Example {
	FirefoxDriver driver;
	String url="https://gofile.io/?t=uploadFiles";
	
  @BeforeTest
  public void LaunchBrowser() throws Exception{
	  String absolutePath=System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath1=absolutePath+"\\Drivers"+"\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filePath1);
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		
  }

  @Test
  public void testUpload() throws InterruptedException {
	  driver.get(url);
	  String absolutePath=System.getProperty("user.dir");
		//String filePath=absolutePath+"\\chromedriver.exe";
		String filePath=absolutePath+"\\Images"+"\\Image0019.jpg";
		System.out.println(filePath);
		driver.findElement(By.id("btnChooseFiles")).click();
		uploadFile(filePath);
		Thread.sleep(10);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\SeleniumTraining\\Workspace\\Mercury_Tours\\chromedriver.exe");

  }

  
  public static void uploadFile(String fileLocation)
  {
	  try{
		  //upload file through robot API
		  StringSelection ss=new StringSelection(fileLocation);
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  //native key stroke for ctrl,v and enter keys
		  Robot robot=new Robot();
		  robot.delay(1000);
		  //Press ctrl+V
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  //Release ctrl+V
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  //press enter
		  robot.delay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  robot.delay(1000);
	  }catch(Exception exp)
	  {
		  exp.printStackTrace();
	  }
  }
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
