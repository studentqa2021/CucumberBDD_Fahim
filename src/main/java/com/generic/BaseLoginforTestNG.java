package com.generic;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

public class BaseLoginforTestNG {
	
	static Logger log = Logger.getLogger(BaseLoginforTestNG.class.getName());
	
	public static void getLogin(WebDriver driver) {
		
		try {
			driver.get(BaseConfig.getValue("URL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		
		log.info("Home page opened");
		
		MasterPageFactory obj = new MasterPageFactory(driver);
		Highlighter.getColor(obj.getUsername(), driver);
		//obj.getUsername().sendKeys("user");
		try {
			obj.getUsername().sendKeys(BaseConfig.getValue("Username"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Highlighter.getColor(obj.getPassword(), driver);
		try {
			obj.getPassword().sendKeys(BaseConfig.getValue("Password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//obj.getPassword().sendKeys("password");
		Highlighter.getColor(obj.getSubmit(), driver);
		obj.getSubmit().click();
		System.out.println(obj.getSignOff().isDisplayed());
		//HandleClick.getJSEClick(driver, obj.getSubmit());
		try {
			ScreenShot.getScreenShot(driver, "Login Test status");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(obj.getLoginStatusSuccessMsg().getText(), "Login Successfully");
		soft.assertTrue(obj.getSignOffList().get(7).isDisplayed());
		log.info("Login Passed");
		
		soft.assertAll();
		
	}

}
