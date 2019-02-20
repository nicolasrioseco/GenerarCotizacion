package Cotizador;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;
import cucumber.api.PendingException;

public class NewCotizacion {

	public String cotizacion(WebDriver driver, WebDriverWait wait, String producto, String version, 
			String servicio, String proveedor, String acuerdo, String docProveedor, String versionTentativa, String tarea) throws Exception{    




		/*              Cotización              */
		//espera a que exista y cliquea sobre el boton para generar una Cotizacion
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addQuote")));
		driver.findElement(By.id("addQuote")).click();
		FormularioCoti cotizacion = new FormularioCoti();
		cotizacion.agregarCliente(driver, wait);
		cotizacion.datosCliente(driver, wait);
		cotizacion.informador(driver, wait);
		cotizacion.infoGral(driver, wait, producto);
		cotizacion.bienes(driver, wait);
		int resultado = cotizacion.buscarBienes(driver, wait, version);
		System.out.println(resultado);
		if (tarea.equals("Normal")) {
			if (resultado != 0) {
				System.out.println("Flujo Normal");
				cotizacion.agregarBien(driver, wait, version);
				cotizacion.servicios(driver, wait, servicio, proveedor, acuerdo);
			}else {
				System.out.println("No se encontró el bien. Debe cargar el bien o realizar el caso de bien tentativo");
				throw new PendingException();
			}
		}else if (tarea.equals("Bien_Tentativo")) {
			System.out.println("Flujo con bien tentativo");
			cotizacion.agregarBien(driver, wait, version);
			cotizacion.servicios(driver, wait, servicio, proveedor, acuerdo);
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-250)", "");
			//Robot robot = new Robot();
			//robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			//robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			int resultadoTentativo = cotizacion.buscarBienes(driver, wait, versionTentativa);
			if (resultadoTentativo != 0) {
				System.out.println("Flujo Normal");
				cotizacion.agregarBien(driver, wait, versionTentativa);
			}else {
				System.out.println("Generando Solicitud de Bien Tentativo");
				cotizacion.agregarBienTentativo(driver, wait, versionTentativa);
			}
		}
		cotizacion.seguros(driver, wait);
		cotizacion.proveedor(driver, wait, docProveedor);
		cotizacion.lugarUtilizacion(driver, wait);
		cotizacion.datosFinancieros(driver, wait);
		cotizacion.calcular(driver, wait);
		String operacion = cotizacion.validar(driver, wait);

		return operacion;
	}
}