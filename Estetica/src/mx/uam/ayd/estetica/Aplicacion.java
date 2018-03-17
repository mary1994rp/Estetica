package mx.uam.ayd.estetica;

import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOCita;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOProducto;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;
import mx.uam.ayd.estetica.presentacion.ControlAñadirCita;
import mx.uam.ayd.estetica.presentacion.ControlAñadirInventario;
import mx.uam.ayd.estetica.presentacion.ControlAñadirTrabajo;
import mx.uam.ayd.estetica.presentacion.ControlIniciaSesion;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaCita;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaInventario;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaTrabajo;
import mx.uam.ayd.estetica.presentacion.VentanaPrincipal;

public class Aplicacion {
	//declaramos los DAOS
	private DAOEmpleado daoEmpleado;
	private DAOProducto daoProducto;
	private DAOTrabajo daoTrabajo;
	private DAOCita daoCita;

	//declaramos los servicios
	private ServicioEmpleado servicioEmpleado;
	private ServicioProducto servicioProducto;
	private ServicioTrabajo servicioTrabajo;
	private ServicioCita servicioCita;

	public Aplicacion() {
		//inicializamos los DAOS
		daoEmpleado = new DAOEmpleado();
		daoProducto = new DAOProducto();
		daoTrabajo = new DAOTrabajo();
		daoCita = new DAOCita();
		
		//inicializamos los Servicios
		servicioEmpleado = new ServicioEmpleado(daoEmpleado);
		servicioProducto = new ServicioProducto(daoProducto);
		servicioTrabajo = new ServicioTrabajo(daoTrabajo);
		servicioCita = new ServicioCita(daoCita);

	}
		
	//arranca el sistema
	public static void main(String[] args) {
		// Crea la instancia de la aplicacion
		Aplicacion app = new Aplicacion();
		app.inicia();
		
	}
	//inicia la ventana principal
	private void inicia() {
		VentanaPrincipal VP = new VentanaPrincipal(this);
		VP.setVisible(true);
		

	}
	/*********************   CU-AÑADIR INVENTARIO  ******************************/
	public void añadirInventario() {
		ControlAñadirInventario CAI = new ControlAñadirInventario(servicioProducto);
		CAI.inicia();
	}
	
	/*********************   CU-AÑADIR TRABAJO  ******************************/
	public void añadirTrabajo() {
		ControlAñadirTrabajo CAT = new ControlAñadirTrabajo(servicioTrabajo,servicioEmpleado,servicioProducto);
		CAT.inicia();//arranca el control para  Añadir Trabajo
	}	
	
	/*********************   CU-AÑADIR CITA  ******************************/
	public void añadirCita() {
		ControlAñadirCita CAC = new ControlAñadirCita(servicioCita, servicioEmpleado);
		CAC.inicia();
	}
	
	/*********************   CU-CONSULTA CITA  ******************************/
	/*********************   CU-MODIFICA CITA  ******************************/
	public void modificaConsultaCita() {
		/*metodo que da inicio al flujo de control de Consulta cita*/
		ControlModificaConsultaCita CMCC = new ControlModificaConsultaCita(servicioCita, servicioEmpleado);
		CMCC.inicia();
	}
	
	/*********************   CU-CONSULTA INVENTARIO  ******************************/
	/*********************   CU-MODIFICA INVENTARIO  ******************************/
	public void modificaConsultaInventario() {
		/*para arrancar caso de uso requerimos autentificacion como administrador*/
		
		if (iniciaSesion()) { //manda a  llamar al metodo inicia sesion, que inicia el login y regresa la validacion
			/*si se comprobo el acceso como administrador se inicia el caso de uso*/
			ControlModificaConsultaInventario CMCI = new ControlModificaConsultaInventario(servicioProducto);
			CMCI.inicia(); // solo muestra ventana

		} 
	}
	
	/*********************   CU-CONSULTA TRABAJO  ******************************/
	/*********************   CU-MODIFICA TRABAJO  ******************************/
	public void modificaConsultaTrabajo() {
		/*para arrancar caso de uso requerimos autentificacion como administrador*/
		if (iniciaSesion()) {		
		ControlModificaConsultaTrabajo CMCT = new ControlModificaConsultaTrabajo(servicioTrabajo,servicioEmpleado,servicioProducto);
		CMCT.inicia();//arranca el control para  Añadir Trabajo
		}
	}	
	
	/*********************   INICIO DE SESION  ******************************/
	public boolean iniciaSesion() {
		/*le habla al servicio Empleado porque él es el q valida el usuario administrador*/
		ControlIniciaSesion CIS = new ControlIniciaSesion(servicioEmpleado);
		CIS.inicia();
		return CIS.dameAutentificado(); //regresa el estado en el que se quedo la bandera de entrada
	}
	
	
	
}