package com.mercury.tours;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;

public class CrossBrowser_Example extends ApplicationTestData{
	WebDriver driver;

	 /* @Test
	  
	  public void Flight_Login() {
		    driver.get("http://newtours.demoaut.com/mercurysignon.php");
		    driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys("testing");
			driver.findElement(By.name("password")).sendKeys("testing");
			driver.findElement(By.name("login")).click();
			driver.findElement(By.linkText("SIGN-OFF")).click();
			
	  }
	/*@Test
	@Parameters({"url","uname","upass"})
	  public void Flight_Login(String url,String uname,String upass) {
		    driver.get(url);
		    driver.findElement(By.linkText("SIGN-ON")).click();
			driver.findElement(By.name("userName")).sendKeys(uname);
			driver.findElement(By.name("password")).sendKeys(upass);
			driver.findElement(By.name("login")).click();	
			driver.findElement(By.linkText("SIGN-OFF")).click();
	}*/
	@Test(dataProvider="Login")
	  public void Flight_Login(String url,String username,String password) {
		    driver.get(url);
			driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.name("login")).click();
			//driver.findElement(By.name("SIGN-OFF")).click();
	  }
	  
	  @BeforeTest
	  @Parameters("browser")
	  public void setup(String browser) throws Exception{
		  if(browser.equalsIgnoreCase("Firefox"))
		  {
			    String absolutePath=System.getProperty("user.dir");
			    String filePath=absolutePath+"\\Drivers"+"\\geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", filePath);
				driver=new FirefoxDriver();
				//driver=new ChromeDriver();
				driver.manage().window().maximize();
				//driver.get("http://newtours.demoaut.com/mercurysignon.php");
		  }
		  else if(browser.equalsIgnoreCase("IE"))
		  {
		    String absolutePath=System.getProperty("user.dir");
		    String filePath=absolutePath+"\\Drivers"+"\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", filePath);
			driver=new InternetExplorerDriver();
			//driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get("http://newtours.demoaut.com/mercurysignon.php");
		  }
	  }

	  @AfterTest
	  public void CloseBrowser() {
		  driver.quit();
	  }


}
