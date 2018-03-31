package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;

public class ControlEmpleadoDelmes {

	private ServicioEmpleado servicioEmpleado;
	private ServicioTrabajo servicioTrabajo;
	
	public ControlEmpleadoDelmes(ServicioEmpleado servicioEmpleado, ServicioTrabajo servicioTrabajo) {
		this.servicioEmpleado = servicioEmpleado;
		this.servicioTrabajo = servicioTrabajo;
	}
	
	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}
	
	public Trabajo[] dameTrabajos() {

		return servicioTrabajo.dameTrabajos();
	}

}
