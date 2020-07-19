package com.UploadedFiles;

import java.awt.Desktop.Action;
//import java.awt.List;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class YtPlaylistCounter {

	public static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException,NoSuchElementException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Office Stuff\\selenium_java\\Driver\\chromedriver.exe");
		
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();

		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);

		//Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize chrome driver which will switch off this browser notification on the chrome browser
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//open the web
		driver.navigate().to("https://www.youtube.com/watch?v=WOUpjal8ee4&list=PLGwb7xZHg-oMv1pOlTHAqAEjw0EPALzlL");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
//Actual Logic
		String className="style-scope ytd-thumbnail-overlay-time-status-renderer";
		String aLabelNameText="seconds";
		boolean aLabelVal=false;
		boolean aClassVal=false;
		
		WebElement myClass=driver.findElement(By.className(className));
		String classText=myClass.getText();
		System.out.println("class text = "+classText);
		if(classText.contains(":")) {
			aClassVal=true;
		}
		
		
//		List<WebElement> myclass=driver.findElements(By.className(className));
//		System.out.println("total vids = "+myclass.size());
//		//String IdentifyMyElement=driver.findElement(By.className(ClassName)).getAttribute("aria-label");
		
//		if(ClassNameValue.equalsIgnoreCase(className.) && aLabelVal) {
//			
//		}
//		
		Thread.sleep(2000);
		

//		

		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
