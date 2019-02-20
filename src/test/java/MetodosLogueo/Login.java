package MetodosLogueo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.Constantes;
import Utilidades.waitCuore;

public class Login {
	
	public static String Defoult_URL = Constantes.Defoult_URL;
	public static String login_post;
	public static String token;
	
	public void login(WebDriver driver, WebDriverWait wait, String usuario, String password) throws InterruptedException {			
			
			//espera a que exista el boton de Iniciar Sesion 
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
	        wait.until(ExpectedConditions.elementToBeClickable(By.id("signupSubmit")));
	        //se completa los campos de login y se accede
	        driver.findElement(By.id("signupEmail")).sendKeys("cuore.admin.QA");
	        driver.findElement(By.id("signupPassword")).sendKeys("Calidad_01");
	        driver.findElement(By.id("signupSubmit")).click();
	}
}