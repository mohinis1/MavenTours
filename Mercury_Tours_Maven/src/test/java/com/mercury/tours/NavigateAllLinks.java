package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NavigateAllLinks {
	ChromeDriver driver;
	//FirefoxDriver driver=new FirefoxDriver();
	
  @Test
  public void navigateToAllLinks()throws Exception {
	List <WebElement> linksize=driver.findElements(By.tagName("a"));
	int linksCount=linksize.size();
	System.out.println("total no of links available:"+linksCount);
	String[] links=new String[linksCount];
	System.out.println("links of all links available");
	//print all links from webpage
	for(int i=0;i<linksCount;i++)
	{
		links[i]=linksize.get(i).getAttribute("href");
		System.out.println(linksize.get(i).getAttribute("href"));
	}
	//navigate to each link on page
	for(int i=0;i<linksCount;i++)
	{
		driver.navigate().to(links[i]);
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}
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
		driver.get("https://www.google.co.in/");
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.close();
  }

}
