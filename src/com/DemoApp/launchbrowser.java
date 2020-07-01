package com.DemoApp;//changing package name after Upload

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class launchbrowser {

	

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("launchbrowser.main script started");
		Test();
		System.out.println("launchbrowser.main script finished");
		
	}
	
	public static void Test() throws InterruptedException {
		WebDriver driver = null;
		System.out.println("launchbrowser.Test script started.");
//trying one
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Office Stuff\\DemoApp\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//open the web
		driver.navigate().to("http://amazon.in");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			System.out.println("Title Matches");
		}else {
			System.out.println(title);
		}

		driver.close();
		driver.quit();
		
		System.out.println("launchbrowser.Test script finished");
	}
}
