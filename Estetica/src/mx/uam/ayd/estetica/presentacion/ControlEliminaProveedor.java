package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioProveedor;

public class ControlEliminaProveedor {

	private ServicioProveedor servicioProveedor;

	public ControlEliminaProveedor(ServicioProveedor servicioProveedor) {
		this.servicioProveedor= servicioProveedor;
			}
	
	public void inicia() {
	/******************** VENTANA ELIMINA PROVEEDOR INICIA **********************/
		VentanaEliminaProveedor VEP = new VentanaEliminaProveedor(this);
		VEP.setVisible(true);		
	}
	//dame citas
	public Proveedor[] dameProveedores() {
		return servicioProveedor.dameProveedor();
	}
	
	
	//quita cita que manda el id de la cita 
	public boolean quitaProveedor(int id) {
		return servicioProveedor.quitaProveedor(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
