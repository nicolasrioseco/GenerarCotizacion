# language: es
Característica: Automatización de la Regresión del Release 1 de Cuore
  Se validarán 5 casos de prueba con flujos diferentes
  Creando los Bienes, Tasas, Proveedores, Acuerdos de Servicios, Servicios y Productos, necesarios para cotizar
  Se avanza la cotización hacia Sidels, dejando todas las cotizaciones con la tarea Instrumentar Legajo creada

	Antecedentes:
   	Dado El usuario accede a la aplicación Cuore con la configuración adecuada
   	
   	
   	    Esquema del escenario: Primer caso de regresion. Cotización con bien tentativo
    Dado el usuario "cuore.admin.QA" se logea a cuore con el password "Calidad_01"
    
    Cuando se configura el impuesto para la provincia de <provincia> con <interesImpo> de interes General
    
    Cuando se genera correctamente el atributo <nombreAtributo>
    Y se genera correctamente la clase <nombreClase>
    Y se genera correctamente la subclase <nombreSubClase>
    Y se genera correctamente la marca <nombreMarca>
    Y se genera correctamente el modelo <nombreModelo>
    Y se genera correctamente el Bien con los datos cargados e indicando la <Versión>
    Y se realiza el análisis por activos correctamente del bien
    Y se realiza el análisis de seguro correctamente del bien
    Y se habilita correctamente el bien
    
    Cuando se genera correctamente el proveedor <nombreProveedor> con el CUIT <CUIT_PROV>
    Cuando se genera correctamente el acuerdo de servicio <nombreAcuerdo> indicandose el costo <Costo> y el mark-up <Mark-Up>
    Y se aprueba el Acuerdo de Servicio correctamente
     
    Cuando se genera correctamente el servicio <nombreServicio> para el Bien creado anteriormente
    Y se aprueba el Servicio correctamente
    
    Cuando se genera la subtasa <nombreSubtasa>
    Y se genera la Tasa TTR
    
    Cuando se genera el Producto <nombreProducto> utilizando los datos generados
    Y se aprueba el Producto correctamente
    
    Cuando se cotiza con los datos generados agregando el bien tentativo <versiónTentativa>
   	
   	Cuando se genera correctamente la marca <marcaTentativa>
    Y se genera correctamente el modelo <modeloTentativo>
    Y se genera correctamente el Bien con los datos cargados e indicando la <versiónTentativa>
    Y se realiza el análisis por activos correctamente del bien
    Y se realiza el análisis de seguro correctamente del bien
    Y se habilita correctamente el bien
    
    Cuando se accede a la tarea Evaluar Nuevo Bien de la cotización
    Y se reemplaza y normaliza el bien tentativo por el bien: marca <marcaTentativa>, modelo <modeloTentativo> y version <versiónTentativa>

		Cuando se retoma la cotización con el bien modificado y se solicitan nuevos VR para los bienes
		Y se validan los nuevos VR de la cotización
		Y se aprueban los VR de la cotización
		
		Entonces se retoma la cotización con los nuevos VR aprobados
		Y se aprueba la cotización generando un Contrato en Sidels
    
    
    Ejemplos:
    
    |	provincia	|	interesImpo	|	nombreAtributo|	nombreClase	|	nombreSubClase	|	nombreMarca	|	marcaTentativa		|	nombreModelo|	modeloTentativo				|	Versión			| versiónTentativa			|	nombreProveedor	|	CUIT_PROV		|	nombreAcuerdo	|	Costo	|	Mark-Up	|	nombreServicio|	nombreSubtasa		|	nombreProducto|
    |	"CHACO"		|	14					|	"AtriQA16"		|	"ClaQA16"		|	"SubQA16"				|	"MarQA16"		|	"MarcaTentQA16"		|	"ModQA16"		|	"ModeloTentQA16"			|	"VerQA16"		|	"VersionTentQA16"			|	"ProvQA16"			|	30711458707	|	"AcuerQA16"		|	1500	|	500			|	"ServQA16" 		|	"FijaQA16"			|	"ProdQA16"		|   
    
    
    
     Esquema del escenario: Cotización a Tasa Fija de un Bien con un Servicio, mediante configuración de un Producto
    Dado el usuario "cuore.admin.QA" se logea a cuore con el password "Calidad_01"
    Cuando se configura el impuesto para la provincia de <provincia> con <interesImpo> de interes General
    
    Cuando se genera correctamente el atributo <nombreAtributo>
    Y se genera correctamente la clase <nombreClase>
    Y se genera correctamente la subclase <nombreSubClase>
    Y se genera correctamente la marca <nombreMarca>
    Y se genera correctamente el modelo <nombreModelo>
    Y se genera correctamente el Bien con los datos cargados e indicando la <Versión>
    Y se realiza el análisis por activos correctamente del bien
    Y se realiza el análisis de seguro correctamente del bien
    Y se habilita correctamente el bien
    
    Cuando se genera correctamente el proveedor <nombreProveedor> con el CUIT <CUIT_PROV>
    Cuando se genera correctamente el acuerdo de servicio <nombreAcuerdo> indicandose el costo <Costo> y el mark-up <Mark-Up>
    Y se aprueba el Acuerdo de Servicio correctamente
     
    Cuando se genera correctamente el servicio <nombreServicio> para el Bien creado anteriormente
    Y se aprueba el Servicio correctamente
    
    Cuando se genera la subtasa <nombreSubtasa>
    Y se genera la Tasa TTR
    
    Cuando se genera el Producto <nombreProducto> utilizando los datos generados
    Y se aprueba el Producto correctamente
    
    Entonces se cotiza con los datos generados
    Y se aprueba la cotización generando un Contrato en Sidels

    
    
    Ejemplos:
    
    |	provincia	|	interesProv	|	nombreAtributo	|	nombreClase	|	nombreSubClase	|	nombreMarca	|	nombreModelo|	Versión			|	nombreProveedor	|	CUIT_PROV		|	nombreAcuerdo	|	Costo	|	Mark-Up	|	nombreServicio|	nombreSubtasa	|	nombreProducto|
    |	"CHACO"		|	14					|	"AtributoN17"		|	"ClaseN17"	|	"SubClaseN17"		|	"MarcaN17"	|	"ModeloN17"	|	"VersiónN17"|	"ProveedorN17"	|	30711346887	|	"AcuerdoN17"	|	1500	|	500			|	"ServicioN17" |	"FijaN17"			|	"ProductoN17"	|

    
    
    
    Esquema del escenario: Cotización a Tasa Variable de un Bien con un Servicio, mediante configuración de un Producto
    Dado el usuario "cuore.admin.QA" se logea a cuore con el password "Calidad_01"
    Cuando se configura el impuesto para la provincia de <provincia> con <interesImpo> de interes General
    
    Cuando se genera correctamente el atributo <nombreAtributo>
    Y se genera correctamente la clase <nombreClase>
    Y se genera correctamente la subclase <nombreSubClase>
    Y se genera correctamente la marca <nombreMarca>
    Y se genera correctamente el modelo <nombreModelo>
    Y se genera correctamente el Bien con los datos cargados e indicando la <Versión>
    Y se realiza el análisis por activos correctamente del bien
    Y se realiza el análisis de seguro correctamente del bien
    Y se habilita correctamente el bien
    
    Cuando se genera correctamente el proveedor <nombreProveedor> con el CUIT <CUIT_PROV>
    Cuando se genera correctamente el acuerdo de servicio <nombreAcuerdo> indicandose el costo <Costo> y el mark-up <Mark-Up>
    Y se aprueba el Acuerdo de Servicio correctamente
     
    Cuando se genera correctamente el servicio <nombreServicio> para el Bien creado anteriormente
    Y se aprueba el Servicio correctamente
    
    Cuando se genera la subtasa <nombreSubtasa>
    Y se configura su <interes>
    Y se genera la Tasa TTR
    
    Cuando se genera el Producto <nombreProducto> utilizando los datos generados
    Y se aprueba el Producto correctamente
    
    Entonces se cotiza con los datos generados
    Y se aprueba la cotización generando un Contrato en Sidels
    
    
    Ejemplos:
    
    |	provincia	|	interesProv	|	nombreAtributo	|	nombreClase	|	nombreSubClase	|	nombreMarca	|	nombreModelo|	Versión			|	nombreProveedor	|	CUIT_PROV		|	nombreAcuerdo	|	Costo	|	Mark-Up	|	nombreServicio|	nombreSubtasa	|	interes	|	nombreProducto|
    |	"CHACO"		|	14					|	"AtributoN14"		|	"ClaseN14"	|	"SubClaseN14"		|	"MarcaN14"	|	"ModeloN14"	|	"VersiónN14"|	"ProveedorN14"	|	30711247188	|	"AcuerdoN14"	|	1500	|	500			|	"ServicioN14" |	"FijaN14"			|	50			| "ProductoN14"	|
    