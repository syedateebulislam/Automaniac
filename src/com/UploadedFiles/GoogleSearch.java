package com.UploadedFiles;//change this dynamically during upload
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("googleSearch.main script started");
		Test();
		System.out.println("googleSearch.main script finished");
	}

	public static void Test() throws InterruptedException {
		WebDriver driver = null;
		System.out.println("googleSearch.Test script started");

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Office Stuff\\DemoApp\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//open the web
		driver.navigate().to("http://google.com");
		driver.manage().window().maximize();

		WebElement Emailid=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		Emailid.click();
		Emailid.sendKeys("Tiger");		
		Thread.sleep(2000);
		
		WebElement searchBtn=driver.findElement(By.className("gNO89b"));
		searchBtn.click();
		Thread.sleep(2000);

		driver.close();
		driver.quit();
		
		System.out.println("googleSearch.Test script finished");
	}

}