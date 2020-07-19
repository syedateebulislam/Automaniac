package com.RunFiles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

//always tell devs to follw this convetion
public class Ateeb_Run_4161{

	public static void main(String[] args) throws InterruptedException {
		String keyword=null;
		Test(keyword);
	}

	public static void Test(String User_Keyword) throws InterruptedException {

		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Desktop\\Office Stuff\\DemoApp\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		
		//open the web
		driver.navigate().to("http://google.com");
		driver.manage().window().maximize();

		WebElement Emailid=driver.findElement(By.xpath("/html/body/div/div[2]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
		Emailid.click();
		Emailid.sendKeys(User_Keyword);		
		Thread.sleep(2000);
		
		WebElement searchBtn=driver.findElement(By.className("gNO89b"));
		searchBtn.click();
		Thread.sleep(2000);

		driver.close();
		driver.quit();		
	}

}
