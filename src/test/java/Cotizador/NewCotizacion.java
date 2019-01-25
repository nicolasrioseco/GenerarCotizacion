package Cotizador;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewCotizacion {
	
	public String cotizacion(WebDriver driver, WebDriverWait wait, String producto, String version, String docProveedor) throws InterruptedException{    
    
   
		/*              Cotización              */
        
		FormularioCoti cotizacion = new FormularioCoti();
		cotizacion.agregarCliente(driver, wait);
        cotizacion.datosCliente(driver, wait);
        cotizacion.informador(driver, wait);
        cotizacion.infoGral(driver, wait, producto);
        cotizacion.bienesServicios(driver, wait, version);
        cotizacion.seguros(driver, wait);
        cotizacion.proveedor(driver, wait, docProveedor);
        cotizacion.lugarUtilizacion(driver, wait);
        cotizacion.datosFinancieros(driver, wait);
        cotizacion.calcular(driver, wait);
        String operacion = cotizacion.validar(driver, wait);
        
	    return operacion;
	}
}