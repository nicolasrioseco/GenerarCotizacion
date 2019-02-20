package ClasesPrincipales;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;

import MetodosLogueo.Login;
import Utilidades.Alarma.ReproductorMp3;
import Utilidades.CreateDriver;
import cucumber.api.java.es.Dado;

public class CP_Given {

	static WebDriver driver; 
	static String fechaDesde;
	static String fechaHasta;
	static WebDriverWait wait;
	
	
	@Dado("^El usuario accede a la aplicación Cuore con la configuración adecuada$")
	public void el_usuario_accede_a_la_aplicación_Cuore_con_la_configuración_adecuada() throws Exception{

		
	    System.out.println("Accediendo a Cuore desde Chrome");
		/*               Login              */
		CreateDriver setCuore = new CreateDriver();
		setCuore.initConfig();
		driver = CreateDriver.driver;
		System.out.println("Acceso Exitoso");
		ReproductorMp3.main(null);
	    LocalDate date = LocalDate.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("d/MM");
	    fechaDesde = date.format(formato);
	    fechaHasta = date.format(formato2);
	    
		SessionId session = ((ChromeDriver) driver).getSessionId();
		System.out.println("Session id: " + session.toString());
	    
	    CP_Given.wait = new WebDriverWait(driver, 20);
	}
	
	
	@Dado("^el usuario \"([^\"]*)\" se logea a cuore con el password \"([^\"]*)\"$")
	public void el_usuario_se_logea_a_cuore_con_el_password(String usuario, String password) throws InterruptedException{
		
	    //             Loggin                   
	    
		System.out.println("Inicio del Logeo en Cuore");
		//               Login              
		Login login = new Login();
		login.login(driver, wait, usuario, password);
		System.out.println("Logueo exitoso");
	}
}
