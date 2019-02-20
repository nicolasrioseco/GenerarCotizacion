package ClasesPrincipales;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cotizador.AccesoCotizador;
import Cotizador.AnalizadaPendienteRevision;
import Cotizador.AprobarCotizacion;
import Cotizador.BuscarCotizacion;
import Cotizador.NewCotizacion;
import Utilidades.Alarma.ReproductorMp3;
import cucumber.api.java.After;
import cucumber.api.java.es.Entonces;

public class CP_Then {
	
	CP_When obtenerValor = new CP_When();
	WebDriver driver = obtenerValor.driver;
	static String producto = CP_When.producto;
	static String version = CP_When.version;
	static String docProveedor = CP_When.docProveedor;
	static String servicio = CP_When.servicio;
	static String nombreProveedor = CP_When.nombreProveedor;
	static String acuerdo = CP_When.acuerdo;
	static WebDriverWait wait = CP_Given.wait;
	static String operacion;
	
	
	@Entonces("^se cotiza con los datos generados$")
	public void se_cotiza_con_los_datos_generados() throws Exception{

		/*            Cotizando		*/
        
		System.out.println("Accediendo al Cotizador");
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
        System.out.println("Acceso exitoso");
        
        System.out.println("Generando Cotización");
		/*         Generar Cotización        */
		NewCotizacion nuevaCoti = new NewCotizacion();
		CP_Then.operacion = nuevaCoti.cotizacion(driver, wait, producto, version, servicio, nombreProveedor, acuerdo, docProveedor, "sinVersionTentativa", "Normal" );
	    System.out.println("Se generó la operación 200" + operacion + " maravillosamente.");
	}
	
	
	@Entonces("^se retoma la cotización con los nuevos VR aprobados$")
	public void se_retoma_la_cotización_con_los_nuevos_VR_aprobados() throws Throwable {
/*            Cotizando		*/
        
		System.out.println("Accediendo al Cotizador");
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
        System.out.println("Acceso exitoso");
        
        BuscarCotizacion buscarCotizacion = new BuscarCotizacion();
		buscarCotizacion.buscarCotizacion(driver, wait, operacion);
		System.out.println("Se accedió correctamente a la operación");
		
		AnalizadaPendienteRevision avanzarCoti = new AnalizadaPendienteRevision();
		avanzarCoti.analizadaPendienteRevision(driver, wait);
	}
	

	@Entonces("^se aprueba la cotización generando un Contrato en Sidels$")
	public void se_aprueba_la_cotización_generando_un_Contrato_en_Sidels() throws InterruptedException, IOException{

		/*            Cotizando		*/
        
	    System.out.println("Accediendo a la operación");
	    /*       Buscar Operación y acceder         */
		BuscarCotizacion buscarCotizacion = new BuscarCotizacion();
		buscarCotizacion.buscarCotizacion(driver, wait, operacion);
		System.out.println("Se accedió correctamente a la operación");
		
		System.out.println("Aprobando Cotización");
	    /*      Aprobar Operación        */
		AprobarCotizacion aprobarCoti = new AprobarCotizacion();
		aprobarCoti.aprobarCotizacion(driver, wait, operacion);
		System.out.println("Cotización Aprobada Correctamente");
	}
	
	 @After
	    public void tearDown() throws InterruptedException, Exception{
		 ReproductorMp3.main(null);
	        System.out.println("This will run after the Scenario");
			if (driver != null) {
		        driver.quit();
		        driver = null;
		        wait = null;
		        Thread.sleep(5000);
			}
	    }

}
