package EduIT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class PruebaSauceDemo {

	private WebDriver driver;
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";

	@BeforeClass
	public void configuracion() {
		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void iniciarSesionConDiferentesUsuarios() {
		
		List<WebElement> Inputs = driver.findElements(By.tagName("input"));
	

	    // Verificar si se encontraron elementos de entrada
        if (!Inputs.isEmpty()) {
            System.out.println(Inputs.size());
            // Iterar sobre los elementos de entrada
            for (int i = 0; i < Inputs.size(); i++) {
                // Verificar el índice para determinar el tipo de campo
                if (i == 0) {
                    // Ingresar nombre de usuario
                    Inputs.get(i).sendKeys("standard_user");
                } else if (i == 1) {
                    // Ingresar contraseña
                    Inputs.get(i).sendKeys("secret_sauce");
                } else if (i == 2) {
                    // Hacer clic en el botón de inicio de sesión
                    Inputs.get(i).click();
                }
            }
        } else {
            System.out.println("No se encontraron elementos de entrada.");
        }
			}
		
	

	@AfterClass
	public void tearDown() {
		// Cerrar el navegador
		driver.close();	}
}



