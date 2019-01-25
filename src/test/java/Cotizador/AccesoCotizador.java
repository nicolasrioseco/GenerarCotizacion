package Cotizador;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccesoCotizador {
	
	public void abmCotizador(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
    /*             Acceso al Cotizador         */
    
    
    //espera a que exista y cliquea sobre el boton de la sección Cotizacion
    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS); 
    wait.until(ExpectedConditions.elementToBeClickable(By.id("mainMenuComercial")));
    Thread.sleep(7000);
    driver.findElement(By.cssSelector(".img-comercial.menu-icon")).click();
    //espera a que exista y cliquea sobre el boton para acceder a la sección Cotizacion
    wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCotizaciones")));
    driver.findElement(By.id("menuCotizaciones")).click();
    Thread.sleep(3000);
    //espera a que exista y cliquea sobre el boton para generar una Cotizacion
    wait.until(ExpectedConditions.elementToBeClickable(By.id("addQuote")));
    driver.findElement(By.id("addQuote")).click();

	}
}