package com.mercury.tours;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class ReadDataFromExcel_XLSX extends ApplicationTestData {
	FirefoxDriver driver;

	@Test(dataProvider = "LoginDataXLSX")
	public void LoginApp(String uname, String upass) throws Exception {
		
		driver.findElement(By.linkText("SIGN-ON")).click();
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(upass);
		driver.findElement(By.name("login")).click();

	}

	@BeforeTest
	public void LaunchApp() {

		String absolutePath = System.getProperty("user.dir");
		String filePath = absolutePath + "\\Drivers" + "\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", filePath);
		driver = new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();

	}

}
