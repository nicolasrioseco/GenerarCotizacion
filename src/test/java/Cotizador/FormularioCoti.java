package Cotizador;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormularioCoti {
	
	public void agregarCliente(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
    
        //espera a que exista y cliquea sobre el boton para Agregar Cliente
        Thread.sleep(40000);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-default.col-md-2.pull-right")));
        driver.findElement(By.cssSelector(".btn.btn-default.col-md-2.pull-right")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("searchClientDocumentNumber")).sendKeys("30500658912" + Keys.TAB + Keys.TAB + Keys.ENTER);
        Thread.sleep(5000);
        //seleccionar cliente
        wait.until(ExpectedConditions.elementToBeClickable(By.id("rowColumn")));
        WebElement row = driver.findElement(By.id("rowColumn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(row).click().sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();       
        
        //Aceptar pop-up confirmacion de cliente
        Thread.sleep(1000);
        driver.findElement(By.id("focusElement")).click();
	}
	
	public void datosCliente(WebDriver driver, WebDriverWait wait) throws InterruptedException{    
	    
        /*          Datos Cliente       */
        Thread.sleep(6000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("emailContact")));
        driver.findElement(By.xpath("//*[@id=\"collapseDatosCliente\"]/div/div[4]/div[1]/div/label")).findElement(By.xpath("//input[contains(@id, 'puesto')]")).sendKeys("Jose Atanor");
        driver.findElement(By.xpath("//*[@id=\"collapseDatosCliente\"]/div/div[4]/div[2]/div/label")).findElement(By.xpath("//input[contains(@id, 'puesto')]")).sendKeys("Groso");
        driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_phoneContact')]")).sendKeys("01145677821");
        driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_internalContact')]")).sendKeys("134");
        driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_cellPhoneContact')]")).sendKeys("0111544325896");
        driver.findElement(By.id("emailContact")).sendKeys("nicolas.rioseco@comafi.com.ar");
	}
	
	
	public void informador(WebDriver driver, WebDriverWait wait) throws InterruptedException{
		
	
    /*              Informador               */
    //Canal
    Select canales = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idChannel')]")));
    canales.selectByValue("7");
    //EDN
    Select edn = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idBusinessManager')]")));
    edn.selectByValue("2");
    //BackOffice
    Select back = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idBusinessManagerSupport')]")));
    back.selectByValue("2");
	}
	
	public void infoGral(WebDriver driver, WebDriverWait wait, String producto) throws InterruptedException{
   
	/*            Información General          */
    //Seleccionar Producto SIN ESPECIFICAR
    Select prod = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_idProduct')]")));
    prod.selectByVisibleText(producto);
    //Dador
    Thread.sleep(15000);
    Select dador = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_lessor')]")));
    dador.selectByValue("2");
    //Moneda
    //Select moneda = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_currency')]")));
    //moneda.selectByValue("1000");
    //Tipo de Contrato
    Select contrato = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_contractType')]")));
    contrato.selectByValue("1");
    //Tipo de Cartera
    //Select cartera = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_linePotfolio')]")));
    //cartera.selectByValue("0");
    //Plazo
    //driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_contractTermOption')]")).sendKeys("36");
    Select plazo = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_contractTermOption')]")));
    plazo.selectByValue("36");
    //Amortización
    Select amortizacion = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_amortization')]")));
    amortizacion.selectByValue("1");
	}
	
	public void bienesServicios(WebDriver driver, WebDriverWait wait, String version) throws InterruptedException{
    
    /*              Bienes y Servicios           */
    
    //Estado
    Select estado = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_goodsStatus')]")));
    estado.selectByValue("1");
    //Destino
    Select destino = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_goodsDestination')]")));
    destino.selectByValue("1");
    //Agregar Bienes
    driver.findElement(By.className("col-lg-12")).click();
    //Buscar Version
    Thread.sleep(6000);
    driver.findElement(By.xpath("//*[@id=\"collapseGoodNodeGroup\"]/div/div[1]/div[5]/div/input"))
    .sendKeys(version + Keys.TAB + Keys.TAB + Keys.ENTER);
    //Seleccionar bien - Tilde check y Aceptar
    driver.findElement(By.cssSelector(".checkthis")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/modal-container/div/div/app-quote-goods-selection-modal/div[3]/div/button[2]")).click();
    
    //Cantidad
    Thread.sleep(6000);
    driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_quantity')]")).sendKeys("1");
    //Precio Unitario
    driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_unitAmount')]")).sendKeys("600000");
    //Moneda
    Select monedaBien = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_currencyGood')]")));
    monedaBien.selectByValue("1000");
	}
	
	
	public void seguros(WebDriver driver, WebDriverWait wait) throws InterruptedException{
	
	Select aseguradora = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_carrier')]")));
	aseguradora.selectByValue("7");
	Select poliza = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_policy')]")));
    poliza.selectByValue("19");
    Select cobertura = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_coverage')]")));
    cobertura.selectByValue("1");
    Thread.sleep(10000);
	}
	
	    
	public void proveedor(WebDriver driver, WebDriverWait wait, String docProveedor) throws InterruptedException{
    
	/*         Proveedores         */
    //Click boton Agregar Proveedor
    driver.findElement(By.xpath("//*[@id=\"collapseProveedor_1\"]/div/div[2]/div/button")).click();
    //Buscar Proveedor por cuit
    Thread.sleep(5000);
    driver.findElement(By.id("supplierDocNumberSearch")).sendKeys(docProveedor);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[contains(@id, 'spplierSearch')]")).click();
    //Seleccionar todos los resultados de la búsqueda
    Thread.sleep(8000);
    driver.findElement(By.id("checkall")).click();
    //Aceptar para agregar el proveedor
    driver.findElement(By.id("supplierAccept")).click();
    //Cuotas de pago a proveedor
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[contains(@id, 'decimal_input_quotes')]")).sendKeys("1");
    driver.findElement(By.xpath("//*[@id=\"collapseProveedor_1\"]/div/div[1]/div/div/div/div/div[2]/div[3]/div[2]/button")).click();
    //Forma de Pago
    Thread.sleep(4000);
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
    provincia.selectByValue("80014");
    driver.findElement(By.id("domicilio")).sendKeys("San Martin 523");
	}
    
	public void datosFinancieros(WebDriver driver, WebDriverWait wait) throws InterruptedException{
    
    /*         Datos Financieros        */
    //Periodicidad
    Select periodicidad = new Select(driver.findElement(By.xpath("//*[contains(@id, 'select_picker_feePeriodicity')]")));
    periodicidad.selectByValue("1");
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
    Thread.sleep(10000);
    driver.findElement(By.xpath("//*[@id=\"router_container\"]/app-cotizacion/form/div[3]/div/div/div/div/button[3]")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//*[contains(@id, 'focusElement')]")).click();
     
    /*       Obtener Nro de Operación     */
    wait.until(ExpectedConditions.elementToBeClickable(By.id("addQuote")));
    String mensaje = new String (driver.findElement(By.xpath("//div[contains(text(),'Ha sido validada correctamente la Operación')]")).getText());
    System.out.println(mensaje);
    String[] corteMensaje = mensaje.split("Ha sido validada correctamente la Operación 200");
    String operacion = corteMensaje[1];

    return operacion;
	}
	
	
}