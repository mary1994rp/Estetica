package mx.uam.ayd.estetica;

import mx.uam.ayd.estetica.negocio.ServicioCita;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProducto;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOCita;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;
import mx.uam.ayd.estetica.persistencia.DAOProducto;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;
import mx.uam.ayd.estetica.persistencia.DAOVentaProducto;
import mx.uam.ayd.estetica.presentacion.ControlAñadirCuenta;
import mx.uam.ayd.estetica.presentacion.ControlAñadirEmpleado;
import mx.uam.ayd.estetica.presentacion.ControlConsultaSueldo;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaCita;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaCuenta;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaEmpleado;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaInventario;
import mx.uam.ayd.estetica.presentacion.ControlModificaConsultaTrabajo;
import mx.uam.ayd.estetica.presentacion.VentanaPrincipal;

public class Aplicacion {
	//declaramos los DAOS
	//private DAOCuenta daoCuenta;
	private DAOEmpleado daoEmpleado;
	private DAOProducto daoProducto;
	private DAOTrabajo daoTrabajo;
	private DAOCita daoCita;
	private DAOVentaProducto daoVentaProducto;
	private DAOCuentas daoCuenta;

	//declaramos los servicios
	//private ServicioCuenta daoServicio;
	private ServicioEmpleado servicioEmpleado;
	private ServicioProducto servicioProducto;
	private ServicioTrabajo servicioTrabajo;
	private ServicioCita servicioCita;
	private ServicioCuenta servicioCuenta;

	public Aplicacion(/*DAOCuenta daoCuenta, ServicioCuenta servicioCuenta*/) {
		//inicializamos los DAOS
		//this.daoCuenta=daoCuenta;
		daoEmpleado = new DAOEmpleado();
		daoProducto = new DAOProducto();
		daoTrabajo = new DAOTrabajo();
		daoCita = new DAOCita();
		daoVentaProducto = new DAOVentaProducto();
		daoCuenta = new DAOCuentas();
		
		//inicializamos los Servicios
		//this.servicioCuenta=servicioCuenta;
		servicioEmpleado = new ServicioEmpleado(daoEmpleado);
		servicioProducto = new ServicioProducto(daoProducto,daoVentaProducto);
		servicioTrabajo = new ServicioTrabajo(daoTrabajo);
		servicioCita = new ServicioCita(daoCita);
		servicioCuenta = new ServicioCuenta(daoCuenta);

	}
		
	
	//inicia la ventana principal
	public void inicia() {
		VentanaPrincipal VP = new VentanaPrincipal(this);
		VP.setVisible(true);
		

	}
	
	/*********************   CU-CONSULTA CITA  ******************************/
	/*********************   CU-MODIFICA CITA  ******************************/
	public void modificaConsultaCita() {
		
		ControlModificaConsultaCita CMCC = new ControlModificaConsultaCita(servicioCita, servicioEmpleado);
		CMCC.inicia();
	}
	
	/*********************   CU-CONSULTA INVENTARIO  ******************************/
	/*********************   CU-MODIFICA INVENTARIO  ******************************/
	public void modificaConsultaInventario() {
		
			ControlModificaConsultaInventario CMCI = new ControlModificaConsultaInventario(servicioProducto);
			CMCI.inicia(); // solo muestra ventana

		
	}
	
	/*********************   CU-CONSULTA TRABAJO  ******************************/
	/*********************   CU-MODIFICA TRABAJO  ******************************/
	public void modificaConsultaTrabajo() {
				
		ControlModificaConsultaTrabajo CMCT = new ControlModificaConsultaTrabajo(servicioTrabajo,servicioEmpleado,servicioProducto);
		CMCT.inicia();//arranca el control para  Añadir Trabajo
		
	}	
	
	/*********************   CU-AñADIR EMPLEADO  ******************************/
	public void añadirEmpleado() {
				
		ControlAñadirEmpleado CAT = new ControlAñadirEmpleado(servicioEmpleado);
		CAT.inicia();//arranca el control para  Añadir Trabajo
		
	}
	
	/*********************   CU-CONSULTA EMPLEADO  ******************************/
	/*********************   CU-MODIFICA EMPLEADO  ******************************/
	public void modificaConsultaEmpleado() {
				
		ControlModificaConsultaEmpleado CMCE = new ControlModificaConsultaEmpleado(servicioEmpleado);
		CMCE.inicia();//arranca el control para  Añadir Trabajo
		
	}	
	
	public void consultaSalario() {
		ControlConsultaSueldo CCS = new ControlConsultaSueldo(servicioEmpleado, servicioTrabajo);
		CCS.inicia();
	}
		
	public void añadirCuenta() {
		ControlAñadirCuenta CAC = new ControlAñadirCuenta(servicioCuenta, servicioEmpleado);
		CAC.inicia();
	}
	
	public void eliminarCuenta() {
		ControlModificaConsultaCuenta CEC = new ControlModificaConsultaCuenta(servicioCuenta, servicioEmpleado);
		CEC.inicia();
	}
	
	
	
	
	
	
	
	
}