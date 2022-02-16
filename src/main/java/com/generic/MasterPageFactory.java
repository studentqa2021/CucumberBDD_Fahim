package com.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {
	
	public MasterPageFactory(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='userName']")
	private WebElement user; 
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//*[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "(//*[@class='mouseOut'])[8]")//grouping (findElement)
	private WebElement signOff;
	
	@FindBy(xpath = "//*[@class='mouseOut']")//without grouping (findElements)
	private List<WebElement> signOffList;
	
	@FindBy(xpath = "//*[text()='Login Successfully']")
	private WebElement loginStatusSuccessMsg;

	public WebElement getUsername() {
		return user;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submitButton;
	}

	public WebElement getSignOff() {
		return signOff;
	}

	public List<WebElement> getSignOffList() {
		return signOffList;
	}

	public WebElement getLoginStatusSuccessMsg() {
		return loginStatusSuccessMsg;
	}
	
	
	
}
