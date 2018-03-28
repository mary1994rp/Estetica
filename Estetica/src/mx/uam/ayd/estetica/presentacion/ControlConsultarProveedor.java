package mx.uam.ayd.estetica.presentacion;


import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProveedor;

public class ControlConsultarProveedor {

	private ServicioProveedor servicioProveedor;

	public ControlConsultarProveedor(ServicioProveedor servicioProveedor) {
		this.servicioProveedor= servicioProveedor; 
	}
	
	public void inicia() {
	/******* Inicia el caso de uso Consulta proveedor***********/
		VentanaConsultaProveedor VCP = new VentanaConsultaProveedor(this);
		VCP.setVisible(true);
	}
	
	//dame citas
	public Proveedor[] dameProveedor() {
		return servicioProveedor.dameProveedor();
	}
	
		
}
