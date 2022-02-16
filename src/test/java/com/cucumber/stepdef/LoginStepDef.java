package com.cucumber.stepdef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.generic.MasterPageFactory;
import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDef {
	
	WebDriver driver;
	MasterPageFactory obj;
	
	@Given ("I open the browser")
	public void getBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	@Given ("Go to the Application URL")
	public void getURL() throws Exception {
		driver.get(BaseConfig.getValue("URL"));
		driver.manage().window().maximize();
		
	}
	@When("I put valid username")
	public void getUserName() throws Exception {
		obj = new MasterPageFactory(driver);
		Highlighter.getColor(obj.getUsername(), driver);
		obj.getUsername().sendKeys(BaseConfig.getValue("Username"));
		
	}
	@When("I put valid password")
	public void getPasword() throws Exception {
		Highlighter.getColor(obj.getPassword(), driver);
		obj.getPassword().sendKeys(BaseConfig.getValue("Password"));
		
	}
	@When("Click signin button")
	public void getSignIn() {
		Highlighter.getColor(obj.getSubmit(), driver);
		obj.getSubmit().click();
		
	}
	@Then("Login should be successful and signout button should be displayed")
	public void checkSignInValidation() throws Throwable {
		ScreenShot.getScreenShot(driver, "Login Test status");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(obj.getLoginStatusSuccessMsg().getText(), "Login Successfully");
		soft.assertTrue(obj.getSignOffList().get(7).isDisplayed());
				
		soft.assertAll();
		
		
	}
	@Then("Close browser")
	public void closeBrowser() {
		driver.quit();
		
	}
	
}
