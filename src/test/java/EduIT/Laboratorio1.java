package EduIT;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio1 {

   @Test @Ignore
   public void lab1_test() {
	   
	System.out.println("Hola Mundo de Automatización!");
  
   }
   
   @Test @Ignore
   public void lab1_e1() {
	   
	   System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
	   
	   WebDriver driver=new ChromeDriver();
	   
	   driver.get("http://www.automationpractice.pl/index.php");
	   
	   driver.close();
	   
   }
   
   @Test @Ignore
   public void lab1_e2() {
	   
	   System.setProperty("webdriver.gecko.driver", "..\\EduIT\\Drivers\\geckodriver.exe");
	   
	   WebDriver driver=new FirefoxDriver();
	   
	   driver.get("http://www.automationpractice.pl/index.php");
	   
	   driver.close();
	   
   }
   
   
   @Test 
   public void lab1_E3() {
	   
	   try{
		   System.setProperty("webdriver.chrome.driver", "..\\EduIT\\Drivers\\chromedriver.exe");
	   
		   WebDriver driver=new ChromeDriver();
	   
		   driver.get("http://www.automationpractice.pl/index.php");
	   
		   driver.manage().window().maximize();
	   
		   WebElement txtBuscador=driver.findElement(By.id("search_query_top"));
	   
		   txtBuscador.clear();
	   
		   txtBuscador.sendKeys("Blouse");
	   
		   txtBuscador.sendKeys(Keys.ENTER);
	      
		   driver.close();
	  
	   }
	   catch(Exception ex) {
		   
			System.out.print("Se ha producido un error");
		   
		   
	   }
	   
   }
   
   
  
}
