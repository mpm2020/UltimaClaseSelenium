package pruebas;


import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio5_E2 {
	
	WebDriver driver;

	String URL="https://demo.guru99.com/test/upload/";
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
	
	@Test
	public void cargarArchivo() {
			
		WebElement rutaACargar=driver.findElement(By.id("uploadfile_0"));
		//File f=new File("pruebas.txt");
		//System.out.println(f.getAbsolutePath());
		//rutaACargar.sendKeys(f.getAbsolutePath());
		rutaACargar.sendKeys("C:\\Users\\maria\\eclipse-workspace\\EduIT\\pruebas.txt");
		
	}

}
