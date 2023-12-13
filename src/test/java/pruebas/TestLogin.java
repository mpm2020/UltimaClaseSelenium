package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import paginas.LoginPage;

public class TestLogin {
    private WebDriver driver;
    private LoginPage loginPage;
    
    String URL="https://the-internet.herokuapp.com/login";
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";

    @BeforeClass
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();


    }

    @Test
    public void testSuccessfulLogin() {
    	loginPage = new LoginPage(driver);
        loginPage.login("tomsmith","SuperSecretPassword!");
        // Agregar aserciones para verificar que el inicio de sesión fue exitoso
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}