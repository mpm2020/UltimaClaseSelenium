package EduIT;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio3_Ejercicio1 {
	WebDriver driver;
	
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
	
		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		
		
	}
	@BeforeTest
	public void irUrl() {		
		driver.get(URL);
		
	}
	
	@BeforeClass
	public void maxVentana() {
		
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=2,description="Test Create Account")
	public void registrarCuenta() {
		
		WebElement txt_Email=driver.findElement(By.id("email_create")); 
		txt_Email.sendKeys("micorreo"+ Math.random()+"@correo.com");
		WebElement btn_Create=driver.findElement(By.id("SubmitCreate"));
		btn_Create.click();

		//g)
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));

		driver.findElement(By.id("id_gender1")).click();

		//c)
		
		WebElement txt_FirstName=driver.findElement(By.name("customer_firstname"));
		txt_FirstName.sendKeys("Juan");
		
		//driver.findElement(By.name("customer_firstname")).sendKeys("Juan"); 

		//d)
		driver.findElement(By.name("passwd")).sendKeys("123456"); 

		//e)

		Select months= new Select(driver.findElement(By.id("months")));

		months.selectByValue("4");
		//h)
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		
		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication", driver.getCurrentUrl());

		
	}
	
	@Test(priority=1)
	public void dummyTest() {
		assertTrue(true);
	}
	
	@AfterMethod
	public void CapturaPantalla() throws Exception {
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EduIT\\Evidencias\\pantalla.png"));
		
	}
	
	
	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de Prueba");
	}
	
	@AfterTest
	public void cierraNavegador() {
		
		 driver.close();
		
	}
	
	@AfterSuite
     public void finSuite() {
		System.out.println("Fin de Suite");
	}


}
