package EduIT;



import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Ejer_11 {

	WebDriver driver;
	String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	@Before
	public void OpenHRM_Before() {
		System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver = new ChromeDriver(options);	
		driver.get(url);
		driver.manage().window().maximize();
	}


	@Test 
	public void OpenHRM_AltaUsuario() throws InterruptedException {

		//Login

		WebDriverWait wait_txt = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement txtUsername = wait_txt.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
		txtUsername.sendKeys("Admin");

		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys("admin123");

		WebElement btnLogin=driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();

		//Opcion de menu
		WebDriverWait waitBtnAdmin = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement btnAdmin = waitBtnAdmin.until(ExpectedConditions.elementToBeClickable(By.linkText("Admin")));
		btnAdmin.click();

		WebDriverWait wait_btn_arr = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement btnArr = wait_btn_arr.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button' and @role='none']")));
		btnArr.click();

		//opcion añadir
		WebDriverWait waitBtnAdd = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btnAdd = waitBtnAdd.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add')]")));
		btnAdd.click();

		//Carga de datos del empleado
		WebDriverWait waitUserRole = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement listUserRole = waitUserRole.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[label[text()='User Role']]]//div[contains(@class, 'oxd-select-text--after')]")));
		listUserRole.click();


		WebElement optionUserRole = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']"));
		optionUserRole.click();

		WebDriverWait  waitOptionStatus = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement listOptionStatus = waitOptionStatus.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[div[label[text()='Status']]]//div[contains(@class, 'oxd-select-text--after')]")));
		listOptionStatus.click();

		WebElement  optionStatus = driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Enabled']"));
		optionStatus.click();


		WebElement txtEmployeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
		txtEmployeeName.sendKeys("P");
		txtEmployeeName.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		txtEmployeeName.sendKeys(Keys.ARROW_DOWN);  
		txtEmployeeName.sendKeys(Keys.ENTER);



		List<WebElement> inputs= driver.findElements(By.xpath("//input[@class='oxd-input oxd-input--active']"));
		inputs.get(1).sendKeys("newUser"+ Math.random());
		txtEmployeeName.sendKeys(Keys.ESCAPE); 


		WebElement txtPass_1 = driver.findElement(By.xpath("(//input[@type='password'])[1]"));
		txtPass_1.sendKeys("Tomas123456#");


		WebElement txtPass_2 = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		txtPass_2.sendKeys("Tomas123456#");

		WebElement btnSubmit=driver.findElement(By.xpath("//button[@type='submit']"));
		btnSubmit.click();


	}


	@After
	public void OpenHRM_After() {
		driver.close();
	}
}
