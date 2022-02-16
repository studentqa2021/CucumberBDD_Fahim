package com.generic;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.util.BaseConfig;
import com.util.DriverManager2;
import com.util.Highlighter;
import com.util.ScreenShot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryTours_BaseLogin {
	
	Logger log = Logger.getLogger(MercuryTours_BaseLogin.class.getName());

	public void getLogin() throws Throwable {
		//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); old
		//WebDriverManager.chromedriver().setup(); //new
		
		//System.setProperty("webdriver.chrome.silentOutput", "true");
		//java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		WebDriver driver = DriverManager2.getDriver("edge");
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://demo.guru99.com/test/newtours/");
		driver.get(BaseConfig.getValue("URL"));
		driver.manage().window().maximize();
		
		log.info("Home page opened");
		
		MasterPageFactory obj = new MasterPageFactory(driver);
		Highlighter.getColor(obj.getUsername(), driver);
		//obj.getUsername().sendKeys("user");
		obj.getUsername().sendKeys(BaseConfig.getValue("Username"));
		Highlighter.getColor(obj.getPassword(), driver);
		obj.getPassword().sendKeys(BaseConfig.getValue("Password"));
		//obj.getPassword().sendKeys("password");
		Highlighter.getColor(obj.getSubmit(), driver);
		obj.getSubmit().click();
		System.out.println(obj.getSignOff().isDisplayed());
		//HandleClick.getJSEClick(driver, obj.getSubmit());
		ScreenShot.getScreenShot(driver, "Login Test status");
		
		//Assert.assertTrue(obj.getSignOff().isDisplayed());
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(obj.getLoginStatusSuccessMsg().getText(), "Login Successfully");
		soft.assertTrue(obj.getSignOffList().get(7).isDisplayed());
		log.info("Login Passed");
		
		//WebElement username = driver.findElement(By.xpath("//*[@name='userName']"));
		//username.sendKeys("smarttech");
		
		//WebElement password = driver.findElement(By.xpath("//*[@name='password']"));
		//password.sendKeys("student");
		
		//WebElement submit = driver.findElement(By.xpath("//*[@name='submit']"));
		//submit.click();
		
		//driver.close();
		driver.quit();
		soft.assertAll();
		
	}
}
