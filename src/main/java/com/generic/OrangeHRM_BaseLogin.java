package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_BaseLogin {
	
	public void getLogin() {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement Username = driver.findElement(By.xpath("//*[@id='txtUsername']"));
		Username.sendKeys("Admin");
		
		WebElement Password = driver.findElement(By.xpath("//*[@id='txtPassword']"));
		Password.sendKeys("admin123");
		
		WebElement Login = driver.findElement(By.xpath("//*[@name='Submit']"));
		Login.click();
		
		driver.close();
		driver.quit();
	}

}
