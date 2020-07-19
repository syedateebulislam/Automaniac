package com.RunFiles;

import java.awt.Desktop.Action;
import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Ateeb_Run_430{

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Office Stuff\\selenium_java\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//open the web
		driver.navigate().to("http://www.rtitata.com/index.html");
		driver.manage().window().maximize();
		String title=driver.getTitle();
		if(title.equalsIgnoreCase("Rajkiya Technical Instittute")) {
			System.out.println("Title Matches");
		}else {
			System.out.println(title);
		}
		
		driver.findElement(By.cssSelector("#popup1 > a:nth-child(1)")).click();
		Thread.sleep(2000);
		
		java.util.Set<String> handles=driver.getWindowHandles();
		String winHandle1=driver.getWindowHandle();
		
		String winHandle2=handles.iterator().next();
		handles.remove(winHandle2);
		String winHandle=" ";
		if(winHandle!=winHandle2)
		{
			winHandle=winHandle1;
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(2000);
		
		String tag=" ";
		tag=driver.findElement(By.cssSelector("li.dropdown:nth-child(8) > a:nth-child(1)")).getText();
		
		WebElement category= driver.findElement(By.cssSelector("li.dropdown:nth-child(8) > a:nth-child(1)"));
		Actions action =new Actions(driver);
		action.moveToElement(category).perform();
		Thread.sleep(2000);
		
		WebElement diploma=driver.findElement(By.linkText( "Diploma"));
		action.moveToElement(diploma);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("#popup1 > a:nth-child(1)")).click();
		Thread.sleep(2000);
		
		java.util.Set<String> ahandles=driver.getWindowHandles();
		String awinHandle1=driver.getWindowHandle();
		
		String awinHandle2=ahandles.iterator().next();
		ahandles.remove(awinHandle2);
		String awinHandle=" ";
		if(awinHandle!=awinHandle2)
		{
			awinHandle=awinHandle1;
			driver.switchTo().window(awinHandle);
		}
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,400)");
		Thread.sleep(3000);
		
		driver.switchTo().frame(1);
		
//		Select dropdown=new Select(driver.findElement(By.cssSelector("#ddlregYear")));
//		dropdown.selectByVisibleText("2010");
//		
		WebElement myElement1=driver.findElement(By.id("txtdob"));
		myElement1.sendKeys("01/07/1988");

		WebElement myElement2=driver.findElement(By.id("txtSearch"));
		myElement2.sendKeys("J32/R8800/10");
		
		WebElement myElement3=driver.findElement(By.id("btnSearch"));
		myElement3.click();
		
		WebElement stdname=driver.findElement(By.id("lblName"));
		String name=stdname.getText();
		String candidateName="SYED SHIKOHUL ISLAM";
		if(name.equalsIgnoreCase(candidateName))
		{
			System.out.println("Your Result is found on the portal.");
		}
		else {
			System.out.println("Your Result is not uploaded on the website");
		}
		driver.close();
		driver.quit();
	}
}
