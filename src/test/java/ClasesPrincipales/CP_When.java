package ClasesPrincipales;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import AcuerdoServicio.AccesoAcuerdoServicio;
import AcuerdoServicio.AltaAcuerdo;
import AcuerdoServicio.AprobarAcuerdo;
import AcuerdoServicio.BandejaAprobarAcuerdo;
import AcuerdoServicio.BusquedaAcuerdo;
import Bienes.AprobarVrCoti.AprobarVRCoti;
import Bienes.AprobarVrCoti.BandejaAprobarVrCoti;
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
import Bienes.EvaluarNuevoBien.BandejaNuevoBien;
import Bienes.EvaluarNuevoBien.NuevoBienTentativo;
import Bienes.Marca.AccesoABMMarca;
import Bienes.Marca.AltaMarca;
import Bienes.Marca.BusquedaMarcas;
import Bienes.Modelo.AccesoABMModelo;
import Bienes.Modelo.AltaModelo;
import Bienes.Modelo.BusquedaModelo;
import Bienes.SubClase.AccesoABMSubClase;
import Bienes.SubClase.AltaSubClase;
import Bienes.SubClase.BusquedaSubClases;
import Bienes.ValidarVrCoti.BandejaValidarVrCoti;
import Bienes.ValidarVrCoti.ValidarVRCoti;
import Bienes.ViabilidadBien.BandejaViabilidadBien;
import Bienes.ViabilidadBien.ViabilidadBien;
import Cotizador.AccesoCotizador;
import Cotizador.BuscarCotizacion;
import Cotizador.NewCotizacion;
import Cotizador.RetomarCotiNewBien;
import Impuestos.AccesoImpuestos;
import Impuestos.AltaImpuestos;
import Impuestos.BusquedaImpuestos;
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
import Tasas.ABMTasaVariable.AccesoABMTasasVar;
import Tasas.ABMTasaVariable.AltaTasaVar;
import Tasas.ABMTasaVariable.BusquedaTasaVar;
import Tasas.ABMTasas.AccesoABMTasas;
import Tasas.ABMTasas.AltaTasa;
import Tasas.ABMTasas.BusquedaTasa;
import cucumber.api.java.es.Cuando;

public class CP_When {

	static String atributo;
	static String clase;
	static String marca;
	static String subclase;
	static String modelo;
	static int bienItems;
	static String version;
	CP_Given obtenerValor= new CP_Given();
	WebDriver driver = CP_Given.driver;
	static String fechaDesde = CP_Given.fechaDesde;
	static String fechaHasta = CP_Given.fechaHasta;
	WebDriverWait wait = CP_Given.wait;
	static String nombreProveedor;
	static String docProveedor;
	static int cantAcuerdo;
	static String acuerdo;
	static String servicio;
	static int cantServicio;
	static String subtasa;
	static String producto;
	static int cantProducto;
	static String operacion;
	static String versionTentativa;
	static String cotizacion;
	
	
	@Cuando("^se configura el impuesto para la provincia de \"([^\"]*)\" con (\\d+) de interes General$")
	public void se_configura_el_impuesto_para_la_provincia_de_con_de_interes_General(String provincia, String porcentajeImpoGral) throws InterruptedException{
  	//			Alta de Impuestos 

	System.out.println("Accediendo al ABM de Impuestos");
	//               ABM Impuestos              
	AccesoImpuestos impuestos = new AccesoImpuestos();
	impuestos.accesoImpuesto(driver, wait);
	System.out.println("Acceso exitoso a Configuración de Impuestos");
    
	System.out.println("Buscando Impuestos");
	//               Buscar Atributos              
	BusquedaImpuestos busquedaImpuesto = new BusquedaImpuestos();
	int impuestoItems = busquedaImpuesto.buscarImpuesto(driver, wait, provincia);
	System.out.println("Se encontraron " + impuestoItems + " configuraciones existentes");
	
	
	if (impuestoItems == 0) {
		System.out.println("Configurando impuesto");
		//               Buscar Atributos              
		AltaImpuestos altaImpuestos = new AltaImpuestos();
		altaImpuestos.configImpuesto(driver, wait, provincia, porcentajeImpoGral);
	}else {
		System.out.println("Ya se encontraba configurado el impuesto para la provincia de " + provincia);
	}	
	}

	@Cuando("^se genera correctamente el atributo \"([^\"]*)\"$")
	public void se_genera_correctamente_el_atributo(String atributo) throws InterruptedException{

		CP_When.atributo = atributo;			
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


		if (atributoItems == 0) {
			System.out.println("Creando Atributo");
			//               Buscar Atributos              
			AltaAtributo altaAtributo = new AltaAtributo();
			altaAtributo.crearAtributo(driver, wait, atributo);
			System.out.println("Se finalizó correctamente el alta de atributos");
		}else {
			System.out.println("Ya existía el atributo " + atributo);
		}
	}



	@Cuando("^se genera correctamente la clase \"([^\"]*)\"$")
	public void se_genera_correctamente_la_clase(String clase) throws InterruptedException{

		CP_When.clase = clase;
		//      Alta de Clase                   	
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

		if (claseItems == 0) {
			System.out.println("Creando Clase");
			//               Crear Clase              
			AltaClase altaClase = new AltaClase();
			altaClase.crearClase(driver, wait, clase);
			System.out.println("Se finalizó correctamente el alta de clases");
		}else {
			System.out.println("Ya existía la clase " + clase);
		}
	}




	@Cuando("^se genera correctamente la subclase \"([^\"]*)\"$")
	public void se_genera_correctamente_la_subclase(String subclase) throws InterruptedException {


		CP_When.subclase = subclase;
		//      Alta de SubClase                   


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


		if (subclaseItems == 0) {
			System.out.println("Creando SubClase");
			//               Crear SubClase              
			AltaSubClase altaSubClase = new AltaSubClase();
			altaSubClase.crearSubClase(driver, wait, atributo, clase, subclase);
			System.out.println("Se finalizó correctamente el alta de subclases");		
		}else {
			System.out.println("Ya existía la subclase " + subclase);
		}
	}



	@Cuando("^se genera correctamente la marca \"([^\"]*)\"$")
	public void se_genera_correctamente_la_marca(String marca) throws InterruptedException{


		CP_When.marca = marca;

		//      Alta de Marca                   


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

		if (marcaItems == 0) {
			System.out.println("Creando Asociación de Marca");
			//               Crear Marca              
			AltaMarca altaMarca = new AltaMarca();
			altaMarca.crearMarca(driver, wait, clase, subclase, marca);//"ClaNico16"	|	"SubClaNico16"   ---->>  clase, subclase
			System.out.println("Se finalizó correctamente la asociación de Marca");
		}else {
			System.out.println("Ya existía la asociación de marca " + subclase);
		}
	}



	@Cuando("^se genera correctamente el modelo \"([^\"]*)\"$")
	public void se_genera_correctamente_el_modelo(String modelo) throws InterruptedException{

		CP_When.modelo = modelo;
		//      Alta de Modelo                   
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

		if (modeloItems == 0) {
			System.out.println("Creando Modelo");
			//               Crear Modelo              
			AltaModelo altaModelo = new AltaModelo();
			altaModelo.crearModelo(driver, wait, clase, subclase, marca, modelo);//"ClaNico16"	|	"SubClaNico16"   ---->>  clase, subclase
			System.out.println("Se finalizó correctamente el alta de Modelo");
		}else {
			System.out.println("Ya existía el modelo " + modelo);
		}
	}



	@Cuando("^se genera correctamente el Bien con los datos cargados e indicando la \"([^\"]*)\"$")
	public void se_genera_correctamente_el_Bien_con_los_datos_cargados_e_indicando_la(String version) throws InterruptedException{

		CP_When.version = version;
		//      Alta de Bien                   
		System.out.println("Accediendo al ABM de Bienes");
		//			ABM Bien		
		AccesoABMBien abmBien = new AccesoABMBien();
		abmBien.abmBien(driver, wait);
		System.out.println("Acceso exitoso al ABM Bienes");

		System.out.println("Buscando Bien");
		//               Buscar Bien              
		BusquedaBien busquedaBien = new BusquedaBien();
		CP_When.bienItems = busquedaBien.buscarBien(driver, wait, version);

		if (bienItems == 0) {

			System.out.println("Creando Bien");
			//               Crear Bien              
			AltaBien altaBien = new AltaBien();
			altaBien.crearBien(driver, wait, clase, subclase, marca, modelo, version, atributo);//"ClaNico16"	|	"SubClaNico16"   ---->>  clase, subclase, marca, modelo, version, atibuto
			System.out.println("Se finalizó correctamente el alta de Bien");

		}else {
			System.out.println("Se finaliza la búsqueda de bienes");
		}
	}


	@Cuando("^se realiza el análisis por activos correctamente del bien$")
	public void se_realiza_el_análisis_por_activos_correctamente_del_bien() throws InterruptedException{


		if (bienItems == 0) {
			//			Analisis Bien por Activos           
			System.out.println("Ingresando al Análisis de Bien por Activos");
			BandejaBienXActivos analisisActivos = new BandejaBienXActivos();
			analisisActivos.analisisBienActivos(driver, wait, version);

			AnalisisBienActivos analisisBienActivos = new AnalisisBienActivos();
			analisisBienActivos.analisisBienActivos(driver, wait, fechaHasta);
		}else {
			System.out.println("Ya existía el bien: " + clase + "-" + subclase + "-" + marca + "-" + modelo + "-" + version);
		}
	}



	@Cuando("^se realiza el análisis de seguro correctamente del bien$")
	public void se_realiza_el_análisis_de_seguro_correctamente_del_bien() throws InterruptedException{


		if (bienItems == 0) {	
			//			Analisis Bien por Seguros           
			System.out.println("Ingresando al Análisis de Bien por Seguros");
			BandejaBienXSeguros analisisSeguros = new BandejaBienXSeguros();
			analisisSeguros.analisisBienSeguros(driver, wait, version);

			AnalisisBienSeguros analisisBienSeguros = new AnalisisBienSeguros();
			analisisBienSeguros.analisisBienSeguros(driver, wait);
		}else {
			System.out.println("Ya existía el bien: " + clase + "-" + subclase + "-" + marca + "-" + modelo + "-" + version);
		}
	}

	@Cuando("^se habilita correctamente el bien$")
	public void se_habilita_correctamente_el_bien() throws InterruptedException{


		if (bienItems == 0) {	
			//			Viabilidad del Bien           
			System.out.println("Ingresando a la Viabilidad del Bien");
			BandejaViabilidadBien bandejaBien = new BandejaViabilidadBien();
			bandejaBien.bandejaViabilidadBien(driver, wait, version);

			ViabilidadBien viabilidadBien = new ViabilidadBien();
			viabilidadBien.viabilidadBien(driver, wait);
		}else {
			System.out.println("Ya existía el bien: " + clase + "-" + subclase + "-" + marca + "-" + modelo + "-" + version);
		}
	}



	@Cuando("^se genera correctamente el proveedor \"([^\"]*)\" con el CUIT (\\d+)$")
	public void se_genera_correctamente_el_proveedor_con_el_CUIT(String nombreProveedor, String docProveedor) throws InterruptedException{

		CP_When.nombreProveedor = nombreProveedor;
		CP_When.docProveedor = docProveedor;
		//		Alta de Proveedor			
		System.out.println("Accediendo al ABM de Proveedores");
		AccesoProveedores accesoProveedores = new AccesoProveedores();
		accesoProveedores.abmProveedores(driver, wait);

		System.out.println("Buscando el proveedor " + docProveedor);
		BusquedaProveedor busquedaProveedor = new BusquedaProveedor();
		int cantProv = busquedaProveedor.buscarProveedor(driver, docProveedor, wait);
		System.out.println("Se encontraron " + cantProv + "Proveedores con la descripcion ingresada");

		if (cantProv == 0) {
			System.out.println("Creando Proveedor");
			AltaProveedor altaProveedor = new AltaProveedor();
			altaProveedor.crearProveedor(driver, wait, nombreProveedor, docProveedor);
			System.out.println("Se finalizó correctamente el alta de Proveedor");
		}else {
			System.out.println("Ya existía el proveedor " + nombreProveedor);
		}
	}



	@Cuando("^se genera correctamente el acuerdo de servicio \"([^\"]*)\" indicandose el costo (\\d+) y el mark-up (\\d+)$")
	public void se_genera_correctamente_el_acuerdo_de_servicio_indicandose_el_costo_y_el_mark_up(String acuerdo, String precioAcuerdo, String markUpAcuerdo) throws Exception{


		CP_When.acuerdo = acuerdo;
		//		Alta de Acuerdo			
		System.out.println("Accediendo al ABM de Acuerdo de Servicios");
		AccesoAcuerdoServicio accesoAcuerdoServicio = new AccesoAcuerdoServicio();
		accesoAcuerdoServicio.abmAcuerdoServicio(driver, wait);

		System.out.println("Buscando el acuerdo " + acuerdo);
		BusquedaAcuerdo busquedaAcuerdo = new BusquedaAcuerdo();
		CP_When.cantAcuerdo = busquedaAcuerdo.buscarAcuerdo(driver, acuerdo, wait);
		System.out.println("Se encontraron " + cantAcuerdo + " Acuerdos con la descripcion ingresada");

		if (cantAcuerdo == 0) {	

			System.out.println("Creando Acuerdo");
			AltaAcuerdo altaAcuerdo = new AltaAcuerdo();
			altaAcuerdo.crearAcuerdo(driver, wait, docProveedor, fechaDesde, fechaHasta, clase, subclase, acuerdo, precioAcuerdo, markUpAcuerdo);
			System.out.println("Se finalizó correctamente el alta de Acuerdo");

		}else {
			System.out.println("Ya existía el acuerdo " + acuerdo);
		}
	}



	@Cuando("^se aprueba el Acuerdo de Servicio correctamente$")
	public void se_aprueba_el_Acuerdo_de_Servicio_correctamente() throws InterruptedException{


		if (cantAcuerdo == 0) {	

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
	}



	@Cuando("^se genera correctamente el servicio \"([^\"]*)\" para el Bien creado anteriormente$")
	public void se_genera_correctamente_el_servicio_para_el_Bien_creado_anteriormente(String servicio) throws InterruptedException{


		CP_When.servicio = servicio;
		//		Alta de Servicio			
		System.out.println("Accediendo al ABM de Servicios");
		AccesoServicio accesoServicio = new AccesoServicio();
		accesoServicio.abmServicio(driver, wait);

		System.out.println("Buscando el servicio " + servicio);
		BusquedaServicio busquedaServicio = new BusquedaServicio();
		CP_When.cantServicio = busquedaServicio.buscarServicio(driver, servicio, wait);
		System.out.println("Se encontraron " + cantServicio + " Servicios con la descripcion ingresada");

		if (cantServicio == 0) {

			System.out.println("Creando Servicio");
			AltaServicio altaServicio = new AltaServicio();
			altaServicio.crearServicio(driver, wait, fechaHasta, clase, subclase, acuerdo, servicio);
			System.out.println("Se finalizó correctamente el alta de Servicio");

		}else {
			System.out.println("Ya existía el servicio " + servicio);
		}
	}


	@Cuando("^se aprueba el Servicio correctamente$")
	public void se_aprueba_el_Servicio_correctamente() throws InterruptedException{


		if (cantServicio == 0) {

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
	}

	@Cuando("^se genera la subtasa \"([^\"]*)\"$")
	public void se_genera_la_subtasa(String subtasa) throws InterruptedException{


		CP_When.subtasa = subtasa;
		//		Alta de SubTasa			
		System.out.println("Accediendo al ABM de Tasas");
		AccesoABMTasas accesoABMTasas = new AccesoABMTasas();
		accesoABMTasas.abmTasas(driver, wait);

		System.out.println("Buscando la subtasa " + subtasa);
		BusquedaTasa busquedaTasa = new BusquedaTasa();
		int cantTasa = busquedaTasa.buscarTasa(driver, subtasa, wait);
		System.out.println("Se encontraron " + cantTasa + " subtasas con la descripcion ingresada");

		if (cantTasa == 0) {
			System.out.println("Creando SubTasa");
			AltaTasa altaTasa = new AltaTasa();
			altaTasa.crearTasa(driver, wait, subtasa);
			System.out.println("Se finalizó correctamente el alta de SubTasa");
		}else {
			System.out.println("Ya existía la subtasa " + subtasa);
		}
	}



	@Cuando("^se configura su (\\d+)$")
	public void se_configura_su(String interes) throws InterruptedException{

		//		Alta de SubTasa			
		System.out.println("Accediendo al ABM de Tasas");
		AccesoABMTasasVar accesoABMTasasVar = new AccesoABMTasasVar();
		accesoABMTasasVar.abmTasasVar(driver, wait);

		System.out.println("Buscando la subtasa variable " + subtasa);
		BusquedaTasaVar busquedaTasaVar = new BusquedaTasaVar();
		int cantTasaVar = busquedaTasaVar.buscarTasaVar(driver, subtasa, wait);
		System.out.println("Se encontraron " + cantTasaVar + " subtasas variables con la descripcion ingresada");

		if (cantTasaVar == 0) {
			System.out.println("Creando SubTasa");
			AltaTasaVar altaTasaVar = new AltaTasaVar();
			altaTasaVar.crearTasaVar(driver, wait, subtasa, interes);
			System.out.println("Se configuró correctamente la Subtasa Variable");
		}else {
			System.out.println("Ya está configurada la subtasa variable " + subtasa);
		}
	}



	@Cuando("^se genera la Tasa TTR$")
	public void se_genera_la_Tasa_TTR() throws InterruptedException{


		//		Alta de Tasa TTR			
		System.out.println("Accediendo al ABM de Tasas TTR");
		AccesoABMTTR accesoABMTTR = new AccesoABMTTR();
		accesoABMTTR.abmTTR(driver, wait);

		System.out.println("Buscando la tasa TTR de la subtasa " + subtasa);
		BusquedaTTR busquedaTTR = new BusquedaTTR();
		int cantTTR = busquedaTTR.buscarTTR(driver, wait, subtasa);
		System.out.println("Se encontraron " + cantTTR + " tasas TTR con la descripcion ingresada");

		if (cantTTR == 0) {
			System.out.println("Creando Tasa TTR");
			AltaTTR altaTTR = new AltaTTR();
			altaTTR.crearTTR(driver, wait, subtasa);
			System.out.println("Se finalizó correctamente el alta de tasa TTR");
		}else {
			System.out.println("Ya existía la ttr para la subtasa " + subtasa);
		}
	}



	@Cuando("^se genera el Producto \"([^\"]*)\" utilizando los datos generados$")
	public void se_genera_el_Producto_utilizando_los_datos_generados(String producto) throws InterruptedException{

		CP_When.producto = producto;
		//		Alta de Producto			
		System.out.println("Accediendo al ABM de Producto");
		AccesoProducto accesoProducto = new AccesoProducto();
		accesoProducto.abmProducto(driver, wait);

		System.out.println("Buscando el producto " + producto);
		BusquedaProducto busquedaProducto = new BusquedaProducto();
		CP_When.cantProducto = busquedaProducto.buscarProducto(driver, producto, wait);
		System.out.println("Se encontraron " + cantProducto + " Productos con la descripcion ingresada");

		if (cantProducto == 0) {

			System.out.println("Creando Producto");
			AltaProducto altaProducto = new AltaProducto();
			altaProducto.crearProducto(driver, wait, cantProducto, fechaHasta, clase, subclase, servicio, subtasa, producto);
			System.out.println("Se finalizó correctamente el alta de Producto");
		}else {
			System.out.println("Ya existía el producto " + producto);
		}
	}
	

	@Cuando("^se aprueba el Producto correctamente$")
	public void se_aprueba_el_Producto_correctamente() throws InterruptedException{

		if (cantProducto == 0) {			
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
	}
	
	@Cuando("^se cotiza con los datos generados agregando el bien tentativo \"([^\"]*)\"$")
	public void se_cotiza_con_los_datos_generados_agregando_el_bien_tentativo(String versionTentativa) throws Throwable {
		/*            Cotizando		*/
        
		System.out.println("Accediendo al Cotizador");
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
        System.out.println("Acceso exitoso");
        
        System.out.println("Generando Cotización");
		/*         Generar Cotización        */
		NewCotizacion nuevaCoti = new NewCotizacion();
		CP_When.operacion = nuevaCoti.cotizacion(driver, wait, producto, version, servicio, nombreProveedor, acuerdo, docProveedor, versionTentativa, "Bien_Tentativo" );//(driver, wait, producto, version, servicio, nombreProveedor, acuerdo, docProveedor, versionTentativa, "Bien_Tentativo" );
	    System.out.println("Se generó la operación 200" + operacion + " maravillosamente.");
	}
	
	@Cuando("^se accede a la tarea Evaluar Nuevo Bien de la cotización$")
	public void se_accede_a_la_tarea_Evaluar_Nuevo_Bien_de_la_cotización() throws Throwable {
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
		BuscarCotizacion resultado = new BuscarCotizacion();
	    CP_When.cotizacion = resultado.buscarCotizacion(driver, wait, operacion);
		BandejaNuevoBien accesoTarea = new BandejaNuevoBien();
	    accesoTarea.tareaBienTentativo(driver, wait, cotizacion);
	}

	@Cuando("^se reemplaza y normaliza el bien tentativo por el bien: marca \"([^\"]*)\", modelo \"([^\"]*)\" y version \"([^\"]*)\"$")
	public void se_reemplaza_y_normaliza_el_bien_tentativo_por_el_bien_marca_modelo_y_version(String marcaTentativa, String modeloTentativa, String versionTentativa) throws Throwable {
	    CP_When.versionTentativa = versionTentativa;
		NuevoBienTentativo reemplazo = new NuevoBienTentativo();
	    reemplazo.nuevoBienTentativo(driver, wait, fechaDesde, fechaHasta, clase, subclase, marcaTentativa, modeloTentativa, versionTentativa);//"ClaNico16"	|	"SubClaNico16"   ---->>  clase, subclase
	}
	
	@Cuando("^se retoma la cotización con el bien modificado y se solicitan nuevos VR para los bienes$")
	public void se_retoma_la_cotización_con_el_bien_modificado_y_se_solicitan_nuevos_VR_para_los_bienes() throws Throwable {
		System.out.println("Accediendo al Cotizador");
		/*           Acceso Cotizador        */
		AccesoCotizador inCotizador = new AccesoCotizador();
		inCotizador.abmCotizador(driver, wait);
        System.out.println("Acceso exitoso");
        
        BuscarCotizacion resultado = new BuscarCotizacion();
        CP_Then.operacion = CP_When.operacion;
        resultado.buscarCotizacion(driver, wait, operacion);
	    
        RetomarCotiNewBien retomar = new RetomarCotiNewBien();
        retomar.aprobarCotiNewBien(driver, wait, versionTentativa, version);
	}
	
	
	@Cuando("^se validan los nuevos VR de la cotización$")
	public void se_validan_los_nuevos_VR_de_la_cotización() throws Throwable {
	    BandejaValidarVrCoti accesoTarea = new BandejaValidarVrCoti();
	    accesoTarea.tareaValidadVRCoti(driver, wait, cotizacion);
	    
	    ValidarVRCoti editarVR = new ValidarVRCoti();
	    editarVR.validarVRCoti(driver, wait);
	}
	
	@Cuando("^se aprueban los VR de la cotización$")
	public void se_aprueban_los_VR_de_la_cotización() throws Throwable {
	    BandejaAprobarVrCoti accesoTarea = new BandejaAprobarVrCoti();
	    accesoTarea.tareaAprobarVRCoti(driver, wait, cotizacion);
	    
	    AprobarVRCoti aprobarVR = new AprobarVRCoti();
	    aprobarVR.aprobarVRCoti(driver, wait);
	}
}
