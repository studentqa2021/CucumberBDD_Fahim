package com.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseLogin {
	
	public void getLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		WebElement signInButton = driver.findElement(By.xpath("//*[@class='login']"));
		signInButton.click();
		Thread.sleep(3000);
		
		WebElement email = driver.findElement(By.xpath("//*[@id='email']"));//prob
		email.sendKeys("sarowerny@gmail.com");//prob

		WebElement password = driver.findElement(By.xpath("//*[@name='passwd']"));//prob
		password.sendKeys("student");// crime

		WebElement singinBtn = driver.findElement(By.xpath("//*[@id='SubmitLogin']"));//prob
		singinBtn.click();
		
		Thread.sleep(2000);

		driver.close();
		driver.quit();
	}
}
