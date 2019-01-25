package AcuerdoServicio;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BusquedaAcuerdo {
	
	public int buscarAcuerdo(WebDriver driver, String acuerdo) throws InterruptedException{    
		
		int cantItems;
		
		/*             Búsqueda de Acuerdo         */
    
	    //Buscar Acuerdo QA
	    driver.findElement(By.id("searchAgreementsAgreementName")).sendKeys(acuerdo);
	    driver.findElement(By.id("searchAgreementsDoSearch")).click();
	    Thread.sleep(10000);
	    String resultado = driver.findElement(By.xpath("//p[contains(@class, 'panel-title')]")).getText();
	    String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
	    if (resultadoParcial[0].equals("0")) {
	    	cantItems = Integer.parseInt(resultadoParcial[0]);
		}else
			cantItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
	    return cantItems;
	}
}