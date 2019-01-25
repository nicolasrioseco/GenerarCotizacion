package Producto;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaProducto {
	
	public void crearProducto(WebDriver driver, WebDriverWait wait, int cantItems, String fechaDesde, 
			String fechaHasta, String clase, String subclase, String servicio, String subtasa, String producto) throws InterruptedException{    
    
		/*             Alta de Producto         */
    
			//espera a que exista y cliquea sobre el boton para generar un nuevo Servicio
		    driver.findElement(By.id("addProducs")).click();
		    //Esperar a que se acceda correctamente a la pantalla nuevo Servicio
		    //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("spinnerLayerLoader")));
		    Thread.sleep(75000);
		    WebElement name = driver.findElement(By.id("name"));
		    name.sendKeys(producto);
		    Select tipoProd = new Select(driver.findElement(By.id("productType")));
		    tipoProd.selectByValue("6");
		    driver.findElement(By.id("vigenciaDesdeAltaProductos_input")).sendKeys(fechaDesde);
		    driver.findElement(By.id("vigenciaHastaAltaProductos_input")).sendKeys(fechaHasta + "/2020");
		    Thread.sleep(20000);
		    driver.findElement(By.id("isCampaign")).click();
		    driver.findElement(By.xpath("//*[@id=\"textArea\"]/textarea")).sendKeys("Producto Automatizado QA");
		    Select persona = new Select(driver.findElement(By.id("clientPersonType")));
		    persona.selectByValue("1");
		    persona.selectByValue("2");
		    driver.findElement(By.id("clientMiPymeNA")).click();
		    
		    
		    driver.findElement(By.id("tabGoodsAndServices")).click();
		    Thread.sleep(6000);
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("goodsAddGood")));
		    Select estado = new Select(driver.findElement(By.id("goodsState")));
		    estado.selectByValue("1");
		    estado.selectByValue("2");
		    estado.selectByValue("3");
		    Select destino = new Select(driver.findElement(By.id("goodsDestination")));
		    destino.selectByValue("1");
		    destino.selectByValue("2");
		    Select titular = new Select(driver.findElement(By.id("goodsHolder")));
		    //titular.selectByValue("1");
		    titular.selectByValue("2");
		    //titular.selectByValue("3");
		    Select origen = new Select(driver.findElement(By.id("goodsOrigin")));
		    origen.selectByValue("1");
		    origen.selectByValue("2");
		    
		    
		    //Agregar Bien
		    driver.findElement(By.id("goodsAddGood")).click();
		    Thread.sleep(6000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("searchGoodCancelConfirmation")));
		    driver.findElement(By.id("searchGoodDefineGrouper")).click();
		    Thread.sleep(2000);
		    Select claseAgrup = new Select(driver.findElement(By.id("searchGoodClass")));
		    claseAgrup.selectByVisibleText(clase);
		    Select subclaseAgrup = new Select(driver.findElement(By.id("searchGoodSubClass")));
		    subclaseAgrup.selectByVisibleText(subclase);
		    Thread.sleep(5000);
		    driver.findElement(By.id("searchGoodDefineGroupConfirmation")).click();
		    Thread.sleep(1000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(4000);
		    
		    //Agregar Servicio
		    driver.findElement(By.id("goodsAddService")).click();
		    Thread.sleep(6000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("acceptSearchService")));
		    driver.findElement(By.id("inputDefault")).sendKeys(servicio);
		    driver.findElement(By.id("searchService")).click();
		    Thread.sleep(10000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		    driver.findElement(By.id("checkall")).click();
		    driver.findElement(By.id("acceptSearchService")).click();
		    Thread.sleep(3000);	    
		    
		    
		    Select aseguradora = new Select(driver.findElement(By.id("insuranceCarrierssubClass0NodeInsurances0")));
		    aseguradora.selectByValue("7");
		    Thread.sleep(4000);
		    Select poliza = new Select(driver.findElement(By.id("insurancePolicessubClass0NodeInsurances0")));
		    poliza.selectByValue("19");
		    Thread.sleep(5000);
		    Select cobertura = new Select(driver.findElement(By.id("insuranceCoveragessubClass0NodeInsurances0")));
		    cobertura.selectByValue("1");
		    Thread.sleep(3000);
		    
		    
		    //Datos Financieros
		    
		    Actions move = new Actions(driver);
		    move.moveToElement(name).click().build().perform();
		    driver.findElement(By.id("tabFinanceData")).click();
		    Thread.sleep(4000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.id("financialDataContractMinTerm")));
		    Select dador = new Select(driver.findElement(By.id("financialDataLessor")));
		    //dador.selectByValue("1");
		    dador.selectByValue("2");
		    Thread.sleep(1000);
		    Select tipoContrato = new Select(driver.findElement(By.id("financialDataContractType")));
		    tipoContrato.selectByValue("2");
		    tipoContrato.selectByValue("3");
		    tipoContrato.selectByValue("4");
		    Thread.sleep(1000);
		    Select amortizacion = new Select(driver.findElement(By.id("financialDataAmortizationType")));
		    amortizacion.selectByValue("3");
		    Thread.sleep(1000);
		    driver.findElement(By.id("financialDataContractMinTerm")).sendKeys("12");
		    driver.findElement(By.id("financialDataContractMaxTerm")).sendKeys("36");
		    Select periodicidad = new Select(driver.findElement(By.id("financialDataFeePeriodicity")));
		    periodicidad.selectByValue("1");
		    Thread.sleep(1000);
		    driver.findElement(By.id("financialDataHasTermOptionsEnabledYes")).click();
		    driver.findElement(By.id("financialDataTermOptions")).sendKeys("12 24 36");
		    Thread.sleep(1000);
		    Select cartera = new Select(driver.findElement(By.id("financialDataPortfolioLine")));
		    cartera.selectByValue("0");
		    //driver.findElement(By.id("financialDataPortfolioLineEditable")).click();
		    Select monedaContrato = new Select(driver.findElement(By.id("financialDataContractCurrency")));
		    monedaContrato.selectByValue("1000");
		    //driver.findElement(By.id("financialDataContractCurrencyEditable")).click();
		    Select tipoTasa = new Select(driver.findElement(By.id("financialDataRateType")));
		    tipoTasa.selectByValue("1");
		    //driver.findElement(By.id("financialDataRateTypeEditable")).click();
		    Select subtasaProd = new Select(driver.findElement(By.id("rate_subtype")));
		    subtasaProd.selectByVisibleText(subtasa);
		    //driver.findElement(By.id("financialDataRateSubtypeEditable")).click();
		    Select canonInicial = new Select(driver.findElement(By.id("financialDataHasInitialCanonFirstFeeEnabled")));
		    canonInicial.selectByValue("1");
		    //driver.findElement(By.id("financialDataRateSubtypeEditable")).click();
		    Select canonExtra = new Select(driver.findElement(By.id("financialDataHasExtraCanonFirstFeeEnabled")));
		    canonExtra.selectByValue("2");
		    //driver.findElement(By.id("financialDataExtraCanonFirstFeeEditable")).click();
		    //Select tipoCEporcentaje = new Select(driver.findElement(By.id("financialDataInitialCanonCeValueType")));
		    //tipoCEporcentaje.selectByValue("2");
		    //driver.findElement(By.id("financialDataInitialCanonCE")).sendKeys("10");//valor CE
		    //driver.findElement(By.id("financialDataCeValueEditable")).click();
		    Select dadorFee = new Select(driver.findElement(By.id("financialDataAdmFeeLessor")));
		    dadorFee.selectByValue("2");
		    //driver.findElement(By.id("financialDataAdmFeeLessorEditable")).click();
		    driver.findElement(By.id("financialDataAdmFeeLessorPercentageValue")).sendKeys("2");
		    //driver.findElement(By.id("financialDataAdmFeeLessorPercentageValueEditable")).click();
		    Select dadorFeeImpo = new Select(driver.findElement(By.id("financialDataFeeLessor")));
		    dadorFeeImpo.selectByValue("2");
		    //driver.findElement(By.id("id="financialDataFeeLessorEditable"")).click();
		    driver.findElement(By.id("financialDataPercentualFeeToPayValue")).sendKeys("2");
		    //driver.findElement(By.id("id="financialDataPercentualFeeToPayValueEditable"")).click();
		    Select ivaAdelantado = new Select(driver.findElement(By.id("financialDataUpFrontIva")));
		    ivaAdelantado.selectByValue("1");
		    //driver.findElement(By.id("id="financialDataUpFrontIvaEditable"")).click();
		    driver.findElement(By.id("financialDataTnaPercentageValue")).sendKeys("70");
		    //driver.findElement(By.id("id="financialDataTnaPercentageValueEditable"")).click();
		    Select periodoGracia = new Select(driver.findElement(By.id("financialDataGracePeriod")));
		    periodoGracia.selectByValue("0");
		    //driver.findElement(By.id("id="financialDataGracePeriodEditable"")).click();
		    Select bonificacion = new Select(driver.findElement(By.id("financialDataFeeBonification")));
		    bonificacion.selectByValue("5");
		    //driver.findElement(By.id("id="financialDataFeeBonificationEditable"")).click();
		    		    	    
		    driver.findElement(By.id("send")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.id("focusElement")).click();
		    Thread.sleep(10000);
		
	}
}