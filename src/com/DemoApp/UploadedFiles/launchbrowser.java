package com.DemoApp.UploadedFiles;//changing package name after Upload

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class launchbrowser {

	public static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("launchbrowser.main script started");
		Test();
		System.out.println("launchbrowser.main script finished");
		
	}
	
	public static void Test() throws InterruptedException {

		System.out.println("launchbrowser.Test script started");

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
		
//		//locate a web element
//		String tag=" ";
//		tag=driver.findElement(By.cssSelector("#nav-link-shopall > span:nth-child(2)")).getText();
//		System.out.println(tag);
//		
//		//dropdown
//		WebElement category= driver.findElement(By.cssSelector("#nav-link-shopall > span:nth-child(2) > span"));
//		Actions action =new Actions(driver);
//		action.moveToElement(category).perform();
//		Thread.sleep(2000);
//		
//		WebElement mobile=driver.findElement(By.cssSelector("span.nav-hasPanel:nth-child(7) > span:nth-child(1)"));
//		action.moveToElement(mobile);
//		action.click();
//		action.perform();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.linkText("All Mobile Phones")).click();;
//		Thread.sleep(2000);
//		
//		//Typing the text
//		WebElement myElement=driver.findElement(By.id("twotabsearchtextbox"));
//		myElement.sendKeys("Realme 3 pro");
//		
//		driver.findElement(By.className("nav-input")).click();
//		Thread.sleep(2000);
//		
//		//select the book
//		driver.findElement(By.partialLinkText("Nitro Blue")).click();
//		Thread.sleep(2000);
//		
//		//shift the tab control
//		java.util.Set<String> handles=driver.getWindowHandles();
//		String winHandle1=driver.getWindowHandle();
//		handles.remove(winHandle1);
//		
//		String winHandle=handles.iterator().next();
//		String winHandle2=" ";
//		if(winHandle!=winHandle1)
//		{
//			winHandle2=winHandle;
//			driver.switchTo().window(winHandle2);
//			System.out.println(winHandle2);
//		}
//		Thread.sleep(2000);
//		
//		//add to cart
//				driver.findElement(By.cssSelector("#a-autoid-10 > span > input")).click();
//				Thread.sleep(5000);
//				
//		
//		//add to cart
//		driver.findElement(By.id("add-to-cart-button")).click();
//		Thread.sleep(5000);
		
		//scroll the webpage till the end
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
		/*
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement frame=driver.findElement(By.xpath("//*[@id=\"singleframe\"]"));
		driver.switchTo().frame(frame);
		Thread.sleep(3000);
		
		WebElement textbox=driver.findElement(By.xpath("/html/body/section/div/div/div/input"));
		textbox.sendKeys("Hey");
		Thread.sleep(3000);
		*/
		driver.close();
		driver.quit();
		
		System.out.println("launchbrowser.Test script finished");
	}
}
