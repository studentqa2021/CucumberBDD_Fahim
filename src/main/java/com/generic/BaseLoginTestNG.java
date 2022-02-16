package com.generic;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

public class BaseLoginTestNG {
	
	static Logger log = Logger.getLogger(BaseLogin.class.getName());

	public static void getLogin(WebDriver driver) throws Throwable {
	
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
