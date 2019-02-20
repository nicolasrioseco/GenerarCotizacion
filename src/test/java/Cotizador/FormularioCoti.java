package Cotizador;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilidades.waitCuore;

public class FormularioCoti {

	public void agregarCliente(WebDriver driver, WebDriverWait wait) throws Exception{    

		//espera a que exista y cliquea sobre el boton para Agregar Cliente
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.col-md-2.pull-right")));
		driver.findElement(By.cssSelector(".btn.btn-default.col-md-2.pull-right")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchClientDocumentNumber")));
		driver.findElement(By.id("searchClientDocumentNumber")).sendKeys("30500658912" + Keys.TAB + Keys.TAB + Keys.ENTER);
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		//seleccionar cliente
		wait.until(ExpectedConditions.elementToBeClickable(By.id("rowColumn")));
		WebElement row = driver.findElement(By.id("rowColumn"));
		Actions actions = new Actions(driver);
		actions.moveToElement(row).click().sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();       

		//Aceptar pop-up confirmacion de cliente
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("focusElement")));
		driver.findElement(By.id("focusElement")).click();
	}

	public void datosCliente(WebDriver driver, WebDriverWait wait) throws InterruptedException{    

		/*          Datos Cliente       */
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("emailContact")));
		driver.findElement(By.xpath("//*[@id=\"collapseDatosCliente\"]/div/div[4]/div[1]/div/label")).findElement(By.xpath("//input[contains(@id, 'puesto')]")).sendKeys("Jose Atanor");
		driver.findElement(By.xpath("//*[@id=\"collapseDatosCliente\"]/div/div[4]/div[2]/div/label")).findElement(By.xpath("//input[contains(@id, 'puesto')]")).sendKeys("Groso");
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_phoneContact')]")).sendKeys("11456778211");
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_internalContact')]")).sendKeys("134");
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_cellPhoneContact')]")).sendKeys("111544325891");
		driver.findElement(By.id("emailContact")).sendKeys("nicolas.rioseco@comafi.com.ar");
	}


	public void informador(WebDriver driver, WebDriverWait wait) throws InterruptedException{


		/*              Informador               */
		//Canal
		Select canales = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idChannel')]")));
		waitCuore.repitedCampos(driver, wait, "7", canales, "value");
		//EDN
		Select edn = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idBusinessManager')]")));
		waitCuore.repitedCampos(driver, wait, "2", edn, "value");
		//BackOffice
		Select back = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idBusinessManagerSupport')]")));
		waitCuore.repitedCampos(driver, wait, "2", back, "value");
	}

	public void infoGral(WebDriver driver, WebDriverWait wait, String producto) throws InterruptedException{

		/*            Información General          */
		//Seleccionar Producto SIN ESPECIFICAR
		Select prod = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idProduct')]")));
		waitCuore.repitedCampos(driver, wait, producto, prod, "text");
		//Dador
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Thread.sleep(7000);
		Select dador = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_lessor')]")));
		waitCuore.repitedCampos(driver, wait, "2", dador, "value");
		//Moneda
		//Select moneda = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_currency')]")));
		//moneda.selectByValue("1000");
		//Tipo de Contrato
		Select contrato = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_contractType')]")));
		waitCuore.repitedCampos(driver, wait, "3", contrato, "value");//financier 1, True 3, KPO 2, S&L 4
		//Tipo de Cartera
		//Select cartera = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_linePotfolio')]")));
		//cartera.selectByValue("0");
		//Plazo
		//driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_contractTermOption')]")).sendKeys("36");
		Select plazo = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_contractTermOption')]")));
		waitCuore.repitedCampos(driver, wait, "36", plazo, "value");
		//Amortización
		Select amortizacion = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_amortization')]")));
		waitCuore.repitedCampos(driver, wait, "1", amortizacion, "value");
	}

	public void bienes(WebDriver driver, WebDriverWait wait) throws InterruptedException{
		/*              Bienes y Servicios           */

		//Estado
		Select estado = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_goodsStatus')]")));
		waitCuore.repitedCampos(driver, wait, "1", estado, "value");
		//Destino
		Select destino = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_goodsDestination')]")));
		waitCuore.repitedCampos(driver, wait, "1", destino, "value");
	}

	public int buscarBienes(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException{
		int bienItems;
		//Agregar Bienes
		Actions move = new Actions(driver);
		WebElement posBien = driver.findElement(By.xpath("//*[@id=\"accordionBienes\"]/div/div[1]"));
		move.moveToElement(posBien).build().perform();
		driver.findElement(By.className("col-lg-12")).click();
		//Buscar Version
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[@id=\"collapseGoodNodeGroup\"]/div/div[1]/div[5]/div/input"))
		.sendKeys(version + Keys.TAB + Keys.TAB + Keys.ENTER);
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
		Thread.sleep(3000);
		String resultado = driver.findElement(By.xpath("//*[@id=\"accordionGoodNodeGroup\"]/div[2]/grid-view/div/div[1]/div[1]/p")).getText();
		System.out.println(resultado);
		String[] resultadoParcial = (resultado.split("\\| "))[1].split(" ítems");
		if (resultadoParcial[0].equals("0")) {
	    	bienItems = Integer.parseInt(resultadoParcial[0]);
			System.out.println("No se encontraron resultados para la búsqueda realizada");
		}else{
			bienItems = Integer.parseInt((resultadoParcial[0].split("de "))[1]);
			System.out.println("Se encontró " + bienItems + " ítems con la misma descripción buscada");
		}
		return bienItems;
	}


	public void agregarBienTentativo(WebDriver driver, WebDriverWait wait, String versionTentativa) throws InterruptedException{
		driver.findElement(By.id("searchQuoteGoodService")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//input[contains(@name, 'name')]")).sendKeys(versionTentativa);
		driver.findElement(By.xpath("//input[contains(@formcontrolname, 'observations')]")).sendKeys("Nuevo Bien Tentativo Automatizado - " + versionTentativa);
		driver.findElement(By.xpath("/html/body/modal-container[2]/div/div/tentative-good/div[2]/div/div/div[2]/button[2]")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("focusElement")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);

		//Cantidad
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	    driver.findElement(By.xpath("//*[@id=\"good1\"]//input[contains(@id, 'decimal_input_quantity')]")).sendKeys("1");//"//*[@id=\"good1\"]/div/div/div[1]/div/field-validator/decimal-input/input[contains(@id, 'decimal_input_quantity')]"
	    driver.findElement(By.xpath("//*[@id=\"good1\"]//input[contains(@id, 'decimal_input_unitAmount')]")).sendKeys("600000");//"//*[@id=\"good1\"]/div/div/div[2]/div/field-validator/decimal-input/input[contains(@id, 'decimal_input_unitAmount')]"
	    Select monedaBien = new Select(driver.findElement(By.xpath("//*[@id=\"good1\"]//select[contains(@id, 'select_picker_currencyGood')]")));//"//*[@id=\"good1\"]/div/div/div[3]/field-validator/select-picker/div/select[contains(@id, 'select_picker_currencyGood')]"
	    waitCuore.repitedCampos(driver, wait, "1000", monedaBien, "value");
		Thread.sleep(7000);
		Select iva = new Select(driver.findElement(By.xpath("//*[@id=\"good1\"]//select[contains(@id, 'select_picker_vat')]")));//"//*[@id=\"good1\"]/div/div/div[6]/select-picker/div/select[contains(@id, 'select_picker_vat')]"
		waitCuore.repitedCampos(driver, wait, "3", iva, "value");
		iva.selectByValue("3");
		Thread.sleep(1000);
	}
	

	public void agregarBien(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException{
		//Seleccionar bien - Tilde check y Aceptar
		driver.findElement(By.cssSelector(".checkthis")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/modal-container/div/div/app-quote-goods-selection-modal/div[3]/div/button[2]")).click();

		//Cantidad
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_quantity')]")).sendKeys("1");
		//Precio Unitario
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_unitAmount')]")).sendKeys("600000");
		//Moneda
		Select monedaBien = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_currencyGood')]")));
		waitCuore.repitedCampos(driver, wait, "1000", monedaBien, "value");
		Thread.sleep(1000);
	}

	//Servicio
	public void servicios(WebDriver driver, WebDriverWait wait, String servicio, String proveedor, String acuerdo) throws InterruptedException{

		driver.findElement(By.xpath("//*[@id=\"collapseBienes_1\"]/div/div[3]/div/div/div/div/div[3]/div/div/button")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("searchService")));
		driver.findElement(By.id("inputDefault")).sendKeys(servicio);
		driver.findElement(By.id("searchService")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkall")));
		driver.findElement(By.id("checkall")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("acceptSearchService")).click();
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);

		Select prov = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_serviceSupplier')]")));
		waitCuore.repitedCampos(driver, wait, proveedor, prov, "text");
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
		Select acuer = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_serviceAgreement')]")));
		waitCuore.repitedCampos(driver, wait, acuerdo, acuer, "text");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	}



	public void seguros(WebDriver driver, WebDriverWait wait) throws InterruptedException{

		Select aseguradora = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_carrier')]")));
		waitCuore.repitedCampos(driver, wait, "7", aseguradora, "value");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select poliza = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_policy')]")));
		waitCuore.repitedCampos(driver, wait, "19", poliza, "value");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		Select cobertura = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_coverage')]")));
		waitCuore.repitedCampos(driver, wait, "1", cobertura, "value");
		cobertura.selectByValue("1");
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
	}


	
	public void proveedor(WebDriver driver, WebDriverWait wait, String docProveedor) throws InterruptedException{

		/*         Proveedores         */
		//Click boton Agregar Proveedor
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.xpath("//*[@id=\"collapseProveedor_1\"]/div/div[2]/div/button")).click();
		//Buscar Proveedor por cuit
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("supplierDocNumberSearch")));
		driver.findElement(By.id("supplierDocNumberSearch")).sendKeys(docProveedor);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id, 'spplierSearch')]")).click();
		//Seleccionar todos los resultados de la búsqueda
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("checkall")).click();
		//Aceptar para agregar el proveedor
		driver.findElement(By.id("supplierAccept")).click();
		//Cuotas de pago a proveedor
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_quotes')]")).sendKeys("1");
		driver.findElement(By.xpath("//*[@id=\"collapseProveedor_1\"]/div/div[1]/div/div/div/div/div[2]/div[3]/div[2]/button")).click();
		//Forma de Pago
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.id("percentage0")).sendKeys("100");
		driver.findElement(By.id("month0")).sendKeys("0");
		driver.findElement(By.xpath("/html/body/modal-container/div/div/forma-pago/form/div/div[3]/button[2]")).click();
		//Seleccionar el bien al que aplica el proveedor
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"collapseProveedor_1\"]/div/div[1]/div/div/div/div/div[3]/div[1]/field-validator/select-picker/div/button")).click();
		driver.findElement(By.cssSelector(".actions-btn.btn-link.bs-select-all")).click();
	}

	
	
	public void lugarUtilizacion(WebDriver driver, WebDriverWait wait) throws InterruptedException{

		/*       Lugar de Utilización Económica          */
		Select provincia = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_province')]")));
		waitCuore.repitedCampos(driver, wait, "80014", provincia, "value");
		driver.findElement(By.id("domicilio")).sendKeys("San Martin 523");
	}

	
	
	public void datosFinancieros(WebDriver driver, WebDriverWait wait) throws InterruptedException{

		/*         Datos Financieros        */
		//Periodicidad
		Select periodicidad = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_feePeriodicity')]")));
		waitCuore.repitedCampos(driver, wait, "1", periodicidad, "value");
		//Dador Fee
		//Select dadorFee = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_feeLessor')]")));
		//dadorFee.selectByValue("2");
		//Valor FeeAdm
		//driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_administrativeFee')]")).sendKeys(Keys.BACK_SPACE + "4");
		//Bonificación
		//Select bonificacion = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_feeBonification')]")));
		//bonificacion.selectByValue("5");
		//Tipo de Tasa
		//Select tipoTasa = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_rateType')]")));
		//tipoTasa.selectByValue("1");
		//SubTasa
		//Thread.sleep(3000);
		//Select subTasa = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_rateSubType')]")));
		//subTasa.selectByVisibleText("Fija PESOS 9");
		//TNA
		//driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_tnaTotal')]")).sendKeys("70");
	}

	public void calcular(WebDriver driver, WebDriverWait wait) throws InterruptedException{

		/*         Calcular         */
		driver.findElement(By.xpath("//*[@id=\"collapseDatosFinancieros_1\"]/div/div[8]/div/div/div/div/div/div[5]/div/button")).click();
	}

	public String validar(WebDriver driver, WebDriverWait wait) throws InterruptedException{

		/*         Validar          */
		Thread.sleep(1000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-cotizacion/form/div[3]/div/div/div/div/button[3]")).click();
		Thread.sleep(2000);
		waitCuore.repited(driver, wait);
		driver.findElement(By.xpath("//*[contains(@id, 'focusElement')]")).click();

		/*       Obtener Nro de Operación     */
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Ha sido validada correctamente la Operación')]")));
		String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'Ha sido validada correctamente la Operación')]")).getText());
		waitCuore.repited(driver, wait);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("addQuote")));
		System.out.println(mensaje);
		String[] corteMensaje = mensaje.split("Ha sido validada correctamente la Operación 200");
		String operacion = corteMensaje[1];
		
		return operacion;
	}


}