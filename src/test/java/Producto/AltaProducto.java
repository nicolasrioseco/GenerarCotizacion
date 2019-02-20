package Producto;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class AltaProducto {
	
	public void crearProducto(WebDriver driver, WebDriverWait wait, int cantItems, 
			String fechaHasta, String clase, String subclase, String servicio, String subtasa, String producto) throws InterruptedException{    
    
		/*             Alta de Producto         */
    
			//espera a que exista y cliquea sobre el boton para generar un nuevo Producto
	    	Thread.sleep(1000);
	    	waitCuore.repited(driver, wait);
		    driver.findElement(By.id("addProducs")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Producto
		    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinnerLayerLoader")));
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		    WebElement name = driver.findElement(By.id("name"));
		    waitCuore.repited(driver, wait);
		    name.sendKeys(producto);
		    Select tipoProd = new Select(driver.findElement(By.id("productType")));
		    waitCuore.repitedCampos(driver, wait, "6", tipoProd, "value");
		    driver.findElement(By.id("vigenciaDesdeAltaProductos_input")).click();
			driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
			driver.findElement(By.id("vigenciaHastaAltaProductos_input")).click();
			driver.findElement(By.xpath("//td[contains(@class, 'today')]")).click();
		    driver.findElement(By.id("vigenciaHastaAltaProductos_input")).sendKeys(Keys.BACK_SPACE,Keys.BACK_SPACE + "20");
			driver.findElement(By.xpath("//td[contains(@class, 'active')]")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("isCampaign")).click();
		    driver.findElement(By.xpath("//*[@id=\"textArea\"]/textarea")).sendKeys("Producto Automatizado QA");
		    
		    // Clientes
		    Select persona = new Select(driver.findElement(By.id("clientPersonType")));
		    waitCuore.repitedCampos(driver, wait, "1", persona, "value");
		    waitCuore.repitedCampos(driver, wait, "2", persona, "value");
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[contains(@data-id, 'clientActivity')]")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("/html/body/div/div/div/div/button")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.xpath("//*[contains(@data-id, 'clientBanking')]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/div/div/div/div/button")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[contains(@data-id, 'clientSubBanking')]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/div/div/div/div/button")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//*[contains(@data-id, 'clientSegment')]")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("/html/body/div/div/div/div/button")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("clientMiPymeNA")).click();
		    
		    
		    //Bienes y Servicios
		    driver.findElement(By.id("tabGoodsAndServices")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("goodsAddGood")));
		    Select estado = new Select(driver.findElement(By.id("goodsState")));
		    waitCuore.repitedCampos(driver, wait, "1", estado, "value");
		    waitCuore.repitedCampos(driver, wait, "2", estado, "value");
		    waitCuore.repitedCampos(driver, wait, "3", estado, "value");
		    Select destino = new Select(driver.findElement(By.id("goodsDestination")));
		    waitCuore.repitedCampos(driver, wait, "1", destino, "value");
		    waitCuore.repitedCampos(driver, wait, "2", destino, "value");
		    Select titular = new Select(driver.findElement(By.id("goodsHolder")));
		    waitCuore.repitedCampos(driver, wait, "2", titular, "value");
		    //titular.selectByValue("1");
		    //titular.selectByValue("3");
		    Select origen = new Select(driver.findElement(By.id("goodsOrigin")));
		    waitCuore.repitedCampos(driver, wait, "1", origen, "value");
		    waitCuore.repitedCampos(driver, wait, "2", origen, "value");
		    
		    
		    //Agregar Bien
		    driver.findElement(By.id("goodsAddGood")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("searchGoodCancelConfirmation")));
		    waitCuore.repited(driver, wait);
		    driver.findElement(By.id("searchGoodDefineGrouper")).click();
		    Thread.sleep(2000);
		    Select claseAgrup = new Select(driver.findElement(By.id("searchGoodClass")));
		    waitCuore.repitedCampos(driver, wait, clase, claseAgrup, "text");
		    Select subclaseAgrup = new Select(driver.findElement(By.id("searchGoodSubClass")));
		    waitCuore.repitedCampos(driver, wait, subclase, subclaseAgrup, "text");
		    Thread.sleep(5000);
		    driver.findElement(By.id("searchGoodDefineGroupConfirmation")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(4000);
			waitCuore.repited(driver, wait);
		    
		    //Agregar Servicio
			wait.until(ExpectedConditions.elementToBeClickable(By.id("goodsAddService")));
			waitCuore.repited(driver, wait);
			driver.findElement(By.id("goodsAddService")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("acceptSearchService")));
		    driver.findElement(By.id("inputDefault")).sendKeys(servicio);
		    driver.findElement(By.id("searchService")).click();	    
		    Thread.sleep(3000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		    driver.findElement(By.id("checkall")).click();
		    driver.findElement(By.id("acceptSearchService")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    
		    
		    Select aseguradora = new Select(driver.findElement(By.id("insuranceCarrierssubClass0NodeInsurances0")));
		    waitCuore.repitedCampos(driver, wait, "7", aseguradora, "value");
		    Select poliza = new Select(driver.findElement(By.id("insurancePolicessubClass0NodeInsurances0")));
		    waitCuore.repitedCampos(driver, wait, "19", poliza, "value");
		    Select cobertura = new Select(driver.findElement(By.id("insuranceCoveragessubClass0NodeInsurances0")));
		    waitCuore.repitedCampos(driver, wait, "1", cobertura, "value");
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    
		    
		    //Datos Financieros
			wait.until(ExpectedConditions.elementToBeClickable(By.id("name")));
		    Actions move = new Actions(driver);
		    move.moveToElement(name).click().build().perform();
		    driver.findElement(By.id("tabFinanceData")).click();
		    Thread.sleep(1000);
			waitCuore.repited(driver, wait);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("financialDataContractMinTerm")));
		    waitCuore.repited(driver, wait);
		    Select dador = new Select(driver.findElement(By.id("financialDataLessor")));
		    waitCuore.repitedCampos(driver, wait, "2", dador, "value");
		    //dador.selectByValue("1");
		    Select tipoContrato = new Select(driver.findElement(By.id("financialDataContractType")));
		    waitCuore.repitedCampos(driver, wait, "2", tipoContrato, "value");
		    waitCuore.repitedCampos(driver, wait, "3", tipoContrato, "value");
		    waitCuore.repitedCampos(driver, wait, "4", tipoContrato, "value");
		    Select amortizacion = new Select(driver.findElement(By.id("financialDataAmortizationType")));
		    waitCuore.repitedCampos(driver, wait, "3", amortizacion, "value");
		    Thread.sleep(1000);
		    driver.findElement(By.id("financialDataContractMinTerm")).sendKeys("12");
		    driver.findElement(By.id("financialDataContractMaxTerm")).sendKeys("36");
		    Select periodicidad = new Select(driver.findElement(By.id("financialDataFeePeriodicity")));
		    waitCuore.repitedCampos(driver, wait, "1", periodicidad, "value");
		    Thread.sleep(1000);
		    driver.findElement(By.id("financialDataHasTermOptionsEnabledYes")).click();
		    driver.findElement(By.id("financialDataTermOptions")).sendKeys("12 24 36");
		    Select cartera = new Select(driver.findElement(By.id("financialDataPortfolioLine")));
		    waitCuore.repitedCampos(driver, wait, "0", cartera, "value");
		    //driver.findElement(By.id("financialDataPortfolioLineEditable")).click();
		    Select monedaContrato = new Select(driver.findElement(By.id("financialDataContractCurrency")));
		    waitCuore.repitedCampos(driver, wait, "1000", monedaContrato, "value");
		    //driver.findElement(By.id("financialDataContractCurrencyEditable")).click();
		    Select tipoTasa = new Select(driver.findElement(By.id("financialDataRateType")));
		    waitCuore.repitedCampos(driver, wait, "1", tipoTasa, "value");
		    //driver.findElement(By.id("financialDataRateTypeEditable")).click();
		    Select subtasaProd = new Select(driver.findElement(By.id("rate_subtype")));
		    waitCuore.repitedCampos(driver, wait, subtasa, subtasaProd, "text");
		    //driver.findElement(By.id("financialDataRateSubtypeEditable")).click();
		    Select canonInicial = new Select(driver.findElement(By.id("financialDataHasInitialCanonFirstFeeEnabled")));
		    waitCuore.repitedCampos(driver, wait, "1", canonInicial, "value");
		    //driver.findElement(By.id("financialDataRateSubtypeEditable")).click();
		    Select canonExtra = new Select(driver.findElement(By.id("financialDataHasExtraCanonFirstFeeEnabled")));
		    waitCuore.repitedCampos(driver, wait, "2", canonExtra, "value");
		    //driver.findElement(By.id("financialDataExtraCanonFirstFeeEditable")).click();
		    //Select tipoCEporcentaje = new Select(driver.findElement(By.id("financialDataInitialCanonCeValueType")));
		    //tipoCEporcentaje.selectByValue("2");
		    //driver.findElement(By.id("financialDataInitialCanonCE")).sendKeys("10");//valor CE
		    //driver.findElement(By.id("financialDataCeValueEditable")).click();
		    Select dadorFee = new Select(driver.findElement(By.id("financialDataAdmFeeLessor")));
		    waitCuore.repitedCampos(driver, wait, "2", dadorFee, "value");
		    //driver.findElement(By.id("financialDataAdmFeeLessorEditable")).click();
		    driver.findElement(By.id("financialDataAdmFeeLessorPercentageValue")).sendKeys("2");
		    //driver.findElement(By.id("financialDataAdmFeeLessorPercentageValueEditable")).click();
		    Select dadorFeeImpo = new Select(driver.findElement(By.id("financialDataFeeLessor")));
		    waitCuore.repitedCampos(driver, wait, "2", dadorFeeImpo, "value");
		    //driver.findElement(By.id("id="financialDataFeeLessorEditable"")).click();
		    driver.findElement(By.id("financialDataPercentualFeeToPayValue")).sendKeys("2");
		    //driver.findElement(By.id("id="financialDataPercentualFeeToPayValueEditable"")).click();
		    Select ivaAdelantado = new Select(driver.findElement(By.id("financialDataUpFrontIva")));
		    waitCuore.repitedCampos(driver, wait, "1", ivaAdelantado, "value");
		    //driver.findElement(By.id("id="financialDataUpFrontIvaEditable"")).click();
		    driver.findElement(By.id("financialDataTnaPercentageValue")).sendKeys("70");
		    //driver.findElement(By.id("id="financialDataTnaPercentageValueEditable"")).click();
		    Select periodoGracia = new Select(driver.findElement(By.id("financialDataGracePeriod")));
		    waitCuore.repitedCampos(driver, wait, "0", periodoGracia, "value");
		    //driver.findElement(By.id("id="financialDataGracePeriodEditable"")).click();
		    Select bonificacion = new Select(driver.findElement(By.id("financialDataFeeBonification")));
		    waitCuore.repitedCampos(driver, wait, "5", bonificacion, "value");
		    //driver.findElement(By.id("id="financialDataFeeBonificationEditable"")).click();
		    		    	    
		    driver.findElement(By.id("send")).click();
		    Thread.sleep(2000);
			waitCuore.repited(driver, wait);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
		    driver.findElement(By.id("focusElement")).click();
	}
}