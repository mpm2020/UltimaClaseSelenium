package EduIT;

import java.io.File;
import java.time.Duration;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Ejer_10 {
	WebDriver driver;
	String url = "https://www.saucedemo.com/";

	@BeforeMethod
	public void setUp () 
	{
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();;
	}

	@Test(priority=1 ,description="CP_Login")
	public void Login() {
		//User
		WebElement txt_User= driver.findElement(By.id("user-name"));
		txt_User.sendKeys("standard_user");

		//Password
		WebElement txt_Password= driver.findElement(By.id("password"));
		txt_Password.sendKeys("secret_sauce");

		//Login button
		WebElement btn_Login= driver.findElement(By.id("login-button"));
		btn_Login.click();

		//ScreenShot Login
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("..\\EduIT\\Evidencias\\Login.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	@Test(priority=2 ,description="CP_Shopping_Cart")
	public void Shopping_Cart() 
	{

		//User
		WebElement txt_User= driver.findElement(By.id("user-name"));
		txt_User.sendKeys("standard_user");

		//Password
		WebElement txt_Password= driver.findElement(By.id("password"));
		txt_Password.sendKeys("secret_sauce");

		//Login button
		WebElement btn_Login= driver.findElement(By.id("login-button"));
		btn_Login.click();

		//Add Elements to the card
		WebElement btn_backpack= driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		btn_backpack.click();
		WebElement btn_Light= driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
		btn_Light.click();	

		//Go to the shop car
		WebElement btn_Car= driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		btn_Car.click();


		//Assertion
		WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement Titulo= wait2.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='title'][contains(.,'Your Cart')]"))));
		Assert.assertEquals("Your Cart",Titulo.getText());

		//ScreenShot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("..\\EduIT\\Evidencias\\ShopingCart.png"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}


