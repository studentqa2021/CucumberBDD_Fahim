package com.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager2 {
	
	static WebDriver driver;
	public static WebDriver getDriver(String browser)  {
		

		if(browser.equalsIgnoreCase("chrome")) {//mac & window
			System.out.println("this is chrome browser");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("edge")) {//window
			System.out.println("this is edge browser");
			WebDriverManager.edgedriver().setup();
			 driver = new EdgeDriver();
		} else if(browser.equalsIgnoreCase("safari")) {//mac
			System.out.println("this is safari browser");
			WebDriverManager.safaridriver().setup();
			 driver = new SafariDriver();
		}else {//nothing match
			System.out.println("Browser not matched");
		}
	return driver;
	}
	
	public static void main(String[] args) throws Throwable   {
		DriverManager2.getDriver("edge");
		
	}


}
