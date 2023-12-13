package pruebas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import paginas.paginaLogin;



public class Laboratorio5_E1b {
	
	WebDriver driver;
	paginaLogin login;

	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();


	}

	@AfterSuite
	public void cierreNavegador() {

		driver.close();

	}
	
	
	@Test(dataProvider="Datos Login")
	public  void irRegistroLogin(String email,String password) {
		login=new paginaLogin(driver);
		login.ingresoDatos(email,password);
	    Assert.assertEquals(login.getTextTitleForm(), "AUTHENTICATION");
		
	}
 
	@DataProvider(name="Datos Login")
	public Object[][] getData(){
		
		Object [][] data= new Object[3][2];
		data[0][0]="test1@gmail.com";data[0][1]="1234";
		data[1][0]="test2@gmail.com";data[1][1]="5678";
		data[2][0]="test3@gmail.com";data[2][1]="9123";
		return data;
		
	}
	


}