package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class CrossBrowserTest {
	WebDriver driver;
	String urlSite="http://www.automationpractice.pl/index.php";
	String pathDriver="..\\EduIT\\Drivers\\chromedriver.exe";
	String pathDriverF="..\\EduIT\\Drivers\\geckodriver.exe";
	
	@BeforeMethod
	@Parameters("navegador")
	public void setup(@Optional("chrome")String navegador){
		
		if(navegador.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver",pathDriver);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver(options);

		}

		else{
			System.setProperty("webdriver.gecko.driver", pathDriverF);
			driver=new FirefoxDriver();

		}

		driver.get(urlSite);

		driver.manage().window().maximize();
	
	}
	
	@Test
	public void buscarPalabra(){
		   WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
		   
		   txtBuscador.clear();
	   
		   txtBuscador.sendKeys("Blouse");
	   
		   txtBuscador.sendKeys(Keys.ENTER);
	      
	}
	
	@AfterMethod
	public void cierraNavegador() {
		
		 driver.close();
		
	}
	
}

