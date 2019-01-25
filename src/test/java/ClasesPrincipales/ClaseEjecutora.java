package ClasesPrincipales;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import Utilidades.CreateDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import AcuerdoServicio.AccesoAcuerdoServicio;
import AcuerdoServicio.AltaAcuerdo;
import AcuerdoServicio.AprobarAcuerdo;
import AcuerdoServicio.BandejaAprobarAcuerdo;
import AcuerdoServicio.BusquedaAcuerdo;
import Bienes.Atributo.AccesoABMAtributo;
import Bienes.Atributo.AltaAtributo;
import Bienes.Atributo.BusquedaAtributos;
import Bienes.Bien.AccesoABMBien;
import Bienes.Bien.AltaBien;
import Bienes.Bien.BusquedaBien;
import Bienes.BienXActivos.AnalisisBienActivos;
import Bienes.BienXActivos.BandejaBienXActivos;
import Bienes.BienXSeguros.AnalisisBienSeguros;
import Bienes.BienXSeguros.BandejaBienXSeguros;
import Bienes.Clase.AccesoABMClase;
import Bienes.Clase.AltaClase;
import Bienes.Clase.BusquedaClases;
import Bienes.Marca.AccesoABMMarca;
import Bienes.Marca.AltaMarca;
import Bienes.Marca.BusquedaMarcas;
import Bienes.Modelo.AccesoABMModelo;
import Bienes.Modelo.AltaModelo;
import Bienes.Modelo.BusquedaModelo;
import Bienes.SubClase.AccesoABMSubClase;
import Bienes.SubClase.AltaSubClase;
import Bienes.SubClase.BusquedaSubClases;
import Bienes.ViabilidadBien.BandejaViabilidadBien;
import Bienes.ViabilidadBien.ViabilidadBien;
import Cotizador.AccesoCotizador;
import Cotizador.AprobarCotizacion;
import Cotizador.BuscarCotizacion;
import Cotizador.NewCotizacion;
import MetodosLogueo.Login;
import Producto.AccesoProducto;
import Producto.AltaProducto;
import Producto.AprobarProducto;
import Producto.BandejaAprobarProducto;
import Producto.BusquedaProducto;
import Proveedores.AccesoProveedores;
import Proveedores.AltaProveedor;
import Proveedores.BusquedaProveedor;
import Servicios.AccesoServicio;
import Servicios.AltaServicio;
import Servicios.AprobarServicio;
import Servicios.BandejaAprobarServicio;
import Servicios.BusquedaServicio;
import Tasas.ABMTasaTTR.AccesoABMTTR;
import Tasas.ABMTasaTTR.AltaTTR;
import Tasas.ABMTasaTTR.BusquedaTTR;
import Tasas.ABMTasas.AccesoABMTasas;
import Tasas.ABMTasas.AltaTasa;
import Tasas.ABMTasas.BusquedaTasa;

public class ClaseEjecutora 
{

	WebDriver driver; 
	String atributo = "Atributo QA26";
	String clase = "Clase QA26";
	String subclase = "SubClase QA26";
	String marca = "Marca QA26";
	String modelo = "Modelo QA26";
	String version = "Versión QA26";
	String subtasa = "Tasa Fija QA26";
	String nombreProveedor = "Proveedor QA26";
	String docProveedor = "30707016066";
	String fechaDesde;
	String fechaHasta;
	String acuerdo = "Acuerdo QA26";
	String precioAcuerdo = "1500";
	String markUpAcuerdo = "550";
	String servicio = "Servicio QA26";
	String producto = "Producto QA26";
	//String operacion = "220";
	
	
	
	@Before
    public void Acceso_Cuore() throws Throwable {
		
		System.out.println("Accediendo a Cuore desde Chrome");
		/*               Login              */
		CreateDriver setCuore = new CreateDriver();
		driver = setCuore.initConfig();
		System.out.println("Acceso Exitoso");
		
	    LocalDate date = LocalDate.now();
	    DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/uuuu");
	    DateTimeFormatter formato2 = DateTimeFormatter.ofPattern("d/MM");
	    fechaDesde = date.format(formato);
	    fechaHasta = date.format(formato2);
	    
	    //             Loggin                   
	    
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		System.out.println("Inicio del Logeo en Cuore");
		//               Login              
		Login login = new Login();
		login.login(driver, wait);
		System.out.println("Logueo exitoso");
    }
	
	@Test
	public void ABMs_Modulos() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		
      	//			Alta de Atributo     

		System.out.println("Accediendo al ABM de Atributos");
		//               ABM Atributos              
		AccesoABMAtributo abmAtributo = new AccesoABMAtributo();
		abmAtributo.abmAtributo(driver, wait);
		System.out.println("Acceso exitoso al ABM Atributos");
	    
		System.out.println("Buscando Atributo");
		//               Buscar Atributos              
		BusquedaAtributos busquedaAtributo = new BusquedaAtributos();
		int atributoItems = busquedaAtributo.buscarAtributo(driver, wait, atributo);
		System.out.println("Se encontraron " + atributoItems + " ítems");
		
		System.out.println("Creando Atributo");
		//               Buscar Atributos              
		AltaAtributo altaAtributo = new AltaAtributo();
		altaAtributo.crearAtributo(driver, wait, atributoItems, atributo);
		System.out.println("Se finalizó correctamente el alta de atributos");
		
		
	    //             Alta de Clase                   
		
	
		System.out.println("Accediendo al ABM de Clase");
		//               ABM Clases              
		AccesoABMClase abmClase = new AccesoABMClase();
		abmClase.abmClase(driver, wait);
		System.out.println("Acceso exitoso al ABM Clase");
	    
		System.out.println("Buscando Clase");
		//               Buscar Clase              
		BusquedaClases busquedaClase = new BusquedaClases();
		int claseItems = busquedaClase.buscarClase(driver, wait, clase);
		System.out.println("Se encontraron " + claseItems + " ítems");
		
		System.out.println("Creando Clase");
		//               Crear Clase              
		AltaClase altaClase = new AltaClase();
		altaClase.crearClase(driver, wait, claseItems, clase);
		System.out.println("Se finalizó correctamente el alta de clases");
		
		
		
		//             Alta de SubClase                   
		
		
		System.out.println("Accediendo al ABM de SubClase");
		//               ABM SubClases              
		AccesoABMSubClase abmSubClase = new AccesoABMSubClase();
		abmSubClase.abmSubClase(driver, wait);
		System.out.println("Acceso exitoso al ABM SubClase");
	    
		System.out.println("Buscando SubClase");
		//               Buscar SubClase             
		BusquedaSubClases busquedaSubClase = new BusquedaSubClases();
		int subclaseItems = busquedaSubClase.buscarSubClase(driver, wait, subclase);
		System.out.println("Se encontraron " + subclaseItems + " ítems");
		
		System.out.println("Creando SubClase");
		//               Crear SubClase              
		AltaSubClase altaSubClase = new AltaSubClase();
		altaSubClase.crearSubClase(driver, wait, subclaseItems, atributo, clase, subclase);
		System.out.println("Se finalizó correctamente el alta de subclases");		
		
		
		
		//             Alta de Marca                   
		
		
		System.out.println("Accediendo al ABM de Marcas");
		//               ABM Marca              
		AccesoABMMarca abmMarca = new AccesoABMMarca();
		abmMarca.abmMarca(driver, wait);
		System.out.println("Acceso exitoso al ABM Marcas");
	    
		System.out.println("Buscando Marca");
		//               Buscar Marca              
		BusquedaMarcas busquedaMarca = new BusquedaMarcas();
		int marcaItems = busquedaMarca.buscarMarca(driver, wait, marca);
		System.out.println("Se encontraron " + marcaItems + " ítems");
		
		System.out.println("Creando Asociación de Marca");
		//               Crear Marca              
		AltaMarca altaMarca = new AltaMarca();
		altaMarca.crearMarca(driver, wait, marcaItems, clase, subclase, marca);
		System.out.println("Se finalizó correctamente la asociación de Marca");
		
		
		
		//             Alta de Modelo                   
		
		
		System.out.println("Accediendo al ABM de Modelos");
		//               ABM Modelo              
		AccesoABMModelo abmModelo = new AccesoABMModelo();
		abmModelo.abmModelo(driver, wait);
		System.out.println("Acceso exitoso al ABM Modelos");
	    
		System.out.println("Buscando Modelo");
		//               Buscar Modelo              
		BusquedaModelo busquedaModelo = new BusquedaModelo();
		int modeloItems = busquedaModelo.buscarModelo(driver, wait, modelo);
		System.out.println("Se encontraron " + modeloItems + " ítems");
		
		System.out.println("Creando Modelo");
		//               Crear Modelo              
		AltaModelo altaModelo = new AltaModelo();
		altaModelo.crearModelo(driver, wait, modeloItems, clase, subclase, marca, modelo);
		System.out.println("Se finalizó correctamente el alta de Modelo");
		
		
		
		//             Alta de Bien                   
		
		
		System.out.println("Accediendo al ABM de Bienes");
		//			ABM Bien		
		AccesoABMBien abmBien = new AccesoABMBien();
		abmBien.abmBien(driver, wait);
		System.out.println("Acceso exitoso al ABM Bienes");
    
		System.out.println("Buscando Bien");
		//               Buscar Bien              
		BusquedaBien busquedaBien = new BusquedaBien();
		int bienItems = busquedaBien.buscarBien(driver, wait, version);
		

		if (bienItems == 0) {
			
			System.out.println("Creando Bien");
			//               Crear Bien              
			AltaBien altaBien = new AltaBien();
			altaBien.crearBien(driver, wait, clase, subclase, marca, modelo, version, atributo);
			System.out.println("Se finalizó correctamente el alta de Bien");
			
			
			//			Analisis Bien por Activos           
			System.out.println("Ingresando al Análisis de Bien por Activos");
			BandejaBienXActivos analisisActivos = new BandejaBienXActivos();
			analisisActivos.analisisBienActivos(driver, wait, version);
			
			AnalisisBienActivos analisisBienActivos = new AnalisisBienActivos();
			analisisBienActivos.analisisBienActivos(driver, wait, fechaDesde, fechaHasta);
			

			//			Analisis Bien por Seguros           
			System.out.println("Ingresando al Análisis de Bien por Seguros");
			BandejaBienXSeguros analisisSeguros = new BandejaBienXSeguros();
			analisisSeguros.analisisBienSeguros(driver, wait, version);

			AnalisisBienSeguros analisisBienSeguros = new AnalisisBienSeguros();
			analisisBienSeguros.analisisBienSeguros(driver, wait);
			

			//			Viabilidad del Bien           
			System.out.println("Ingresando a la Viabilidad del Bien");
			BandejaViabilidadBien bandejaBien = new BandejaViabilidadBien();
			bandejaBien.bandejaViabilidadBien(driver, wait, version);
			
			ViabilidadBien viabilidadBien = new ViabilidadBien();
			viabilidadBien.viabilidadBien(driver, wait);
			
		}else {
			System.out.println("Ya existía el bien: " + clase + "-" + subclase + "-" + marca + "-" + modelo + "-" + version);
			String estado = driver.findElement(By.xpath("//*[@id=\"rowColumn\"]/td[6]")).getText();
			System.out.println("El estado del bien es: " + estado);
		}
		
		
		


		//			Alta de SubTasa			
		System.out.println("Accediendo al ABM de Tasas");
		AccesoABMTasas accesoABMTasas = new AccesoABMTasas();
		accesoABMTasas.abmTasas(driver, wait);
		
		System.out.println("Buscando la subtasa " + subtasa);
		BusquedaTasa busquedaTasa = new BusquedaTasa();
		int cantTasa = busquedaTasa.buscarTasa(driver, subtasa);
		System.out.println("Se encontraron " + cantTasa + " subtasas con la descripcion ingresada");
		
		System.out.println("Creando SubTasa");
		AltaTasa altaTasa = new AltaTasa();
		altaTasa.crearTasa(driver, wait, cantTasa, subtasa);
		System.out.println("Se finalizó correctamente el alta de SubTasa");
		
		
		
		//			Alta de Tasa TTR			
		System.out.println("Accediendo al ABM de Tasas TTR");
		AccesoABMTTR accesoABMTTR = new AccesoABMTTR();
		accesoABMTTR.abmTTR(driver, wait);
		
		System.out.println("Buscando la tasa TTR de la subtasa " + subtasa);
		BusquedaTTR busquedaTTR = new BusquedaTTR();
		int cantTTR = busquedaTTR.buscarTTR(driver, wait, subtasa);
		System.out.println("Se encontraron " + cantTTR + " tasas TTR con la descripcion ingresada");
		
		System.out.println("Creando Tasa TTR");
		AltaTTR altaTTR = new AltaTTR();
		altaTTR.crearTTR(driver, wait, cantTTR, subtasa);
		System.out.println("Se finalizó correctamente el alta de tasa TTR");
		
		
		
		//			Alta de Proveedor			
		System.out.println("Accediendo al ABM de Proveedores");
		AccesoProveedores accesoProveedores = new AccesoProveedores();
		accesoProveedores.abmProveedores(driver, wait);
		
		System.out.println("Buscando el proveedor " + docProveedor);
		BusquedaProveedor busquedaProveedor = new BusquedaProveedor();
		int cantProv = busquedaProveedor.buscarProveedor(driver, docProveedor);
		System.out.println("Se encontraron " + cantProv + "Proveedores con la descripcion ingresada");
		
		System.out.println("Creando Proveedor");
		AltaProveedor altaProveedor = new AltaProveedor();
		altaProveedor.crearProveedor(driver, wait, cantProv, nombreProveedor, docProveedor);
		System.out.println("Se finalizó correctamente el alta de Proveedor");
		
		
		
		//			Alta de Acuerdo			
		System.out.println("Accediendo al ABM de Acuerdo de Servicios");
		AccesoAcuerdoServicio accesoAcuerdoServicio = new AccesoAcuerdoServicio();
		accesoAcuerdoServicio.abmAcuerdoServicio(driver, wait);
		
		System.out.println("Buscando el acuerdo " + acuerdo);
		BusquedaAcuerdo busquedaAcuerdo = new BusquedaAcuerdo();
		int cantAcuerdo = busquedaAcuerdo.buscarAcuerdo(driver, acuerdo);
		System.out.println("Se encontraron " + cantAcuerdo + " Acuerdos con la descripcion ingresada");

		if (cantAcuerdo == 0) {	
		
			System.out.println("Creando Acuerdo");
			AltaAcuerdo altaAcuerdo = new AltaAcuerdo();
			altaAcuerdo.crearAcuerdo(driver, wait, docProveedor, fechaDesde, fechaHasta, version, acuerdo, precioAcuerdo, markUpAcuerdo);
			System.out.println("Se finalizó correctamente el alta de Acuerdo");

			System.out.println("Ingresando a la Aprobación de Acuerdo");
			BandejaAprobarAcuerdo bandejaAcuerdo = new BandejaAprobarAcuerdo();
			bandejaAcuerdo.aprobarAcuerdo(driver, wait, acuerdo);
		
			System.out.println("Aprobando Acuerdo");
			AprobarAcuerdo aprobarAcuerdo = new AprobarAcuerdo();
			aprobarAcuerdo.aprobarAcuerdo(driver, wait);
			System.out.println("Se aprobó correctamente el Acuerdo creado");
		
		}else {
			System.out.println("Ya existía el acuerdo " + acuerdo);
		}
		
		
		

		//			Alta de Servicio			
		System.out.println("Accediendo al ABM de Servicios");
		AccesoServicio accesoServicio = new AccesoServicio();
		accesoServicio.abmServicio(driver, wait);
		
		System.out.println("Buscando el servicio " + servicio);
		BusquedaServicio busquedaServicio = new BusquedaServicio();
		int cantServicio = busquedaServicio.buscarServicio(driver, servicio);
		System.out.println("Se encontraron " + cantServicio + " Servicios con la descripcion ingresada");
		
		if (cantServicio == 0) {

			System.out.println("Creando Servicio");
			AltaServicio altaServicio = new AltaServicio();
			altaServicio.crearServicio(driver, wait, fechaDesde, fechaHasta, version, acuerdo, servicio);
			System.out.println("Se finalizó correctamente el alta de Servicio");

			System.out.println("Ingresando a la Aprobación de Servicio");
			BandejaAprobarServicio bandejaServicio = new BandejaAprobarServicio();
			bandejaServicio.aprobarServicio(driver, wait, servicio);
			
			System.out.println("Aprobando Servicio");
			AprobarServicio aprobarServicio = new AprobarServicio();
			aprobarServicio.aprobarServicio(driver, wait);
			System.out.println("Se aprobó correctamente el Servicio creado");
			
		}else {
			System.out.println("Ya existía el servicio " + servicio);
		}
		
		
		
		//			Alta de Producto			
		System.out.println("Accediendo al ABM de Producto");
		AccesoProducto accesoProducto = new AccesoProducto();
		accesoProducto.abmProducto(driver, wait);
		
		System.out.println("Buscando el producto " + producto);
		BusquedaProducto busquedaProducto = new BusquedaProducto();
		int cantProducto = busquedaProducto.buscarProducto(driver, producto);
		System.out.println("Se encontraron " + cantProducto + " Productos con la descripcion ingresada");
	
		if (cantProducto == 0) {
			
			System.out.println("Creando Producto");
			AltaProducto altaProducto = new AltaProducto();
			altaProducto.crearProducto(driver, wait, cantProducto, fechaDesde, fechaHasta, clase, subclase, servicio, subtasa, producto);
			System.out.println("Se finalizó correctamente el alta de Producto");
			
			System.out.println("Ingresando a la Aprobación de Producto");
			BandejaAprobarProducto bandejaProducto = new BandejaAprobarProducto();
			bandejaProducto.aprobarProducto(driver, wait, producto);
			
			System.out.println("Aprobando Producto");
			AprobarProducto aprobarProducto = new AprobarProducto();
			aprobarProducto.aprobarProducto(driver, wait);
			System.out.println("Se aprobó correctamente el Producto creado");
		}else {
			System.out.println("Ya existía el producto " + producto);
		}					

		/*            Cotizando		*/
               
		System.out.println("Accediendo al Cotizador");
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
        System.out.println("Acceso exitoso");
        
        System.out.println("Generando Cotización");
		/*         Generar Cotización        */
		NewCotizacion nuevaCoti = new NewCotizacion();
		String operacion = nuevaCoti.cotizacion(driver, wait, producto, version, docProveedor);
	    System.out.println("Se generó la operación 200" + operacion + " maravillosamente.");
		
	    System.out.println("Accediendo a la operación");
	    /*       Buscar Operación y acceder         */
		BuscarCotizacion buscarCotizacion = new BuscarCotizacion();
		buscarCotizacion.buscarCotizacion(driver, wait, operacion);
		System.out.println("Se accedió correctamente a la operación");
		
		System.out.println("Aprobando Cotización");
	    /*      Aprobar Operación        */
		AprobarCotizacion aprobarCoti = new AprobarCotizacion();
		aprobarCoti.aprobarCotizacion(driver, wait);
		System.out.println("Cotización Aprobada Correctamente");
	}
	
}