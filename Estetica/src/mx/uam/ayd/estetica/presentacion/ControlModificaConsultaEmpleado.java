package mx.uam.ayd.estetica.presentacion;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.negocio.ServicioEmpleado;

public class ControlModificaConsultaEmpleado {
	private ServicioEmpleado servicioEmpleado;//******

	public ControlModificaConsultaEmpleado(ServicioEmpleado servicioEmpleado) {
		this.servicioEmpleado= servicioEmpleado;
	}
	
	public void inicia() {
		//inicia la ventana del caso de uso
		VentanaModificaConsultaEmpleado VMCE =  new VentanaModificaConsultaEmpleado(this);
		/*hace visible la ventana de Empleados*/
		VMCE.setVisible(true);		
	}
	

	
	public Empleado buscaEmpleado(String nombreEmpleado) {
		return servicioEmpleado.buscaEmpleado(nombreEmpleado);
	}

	public Empleado[] dameEmpleados() {
		return servicioEmpleado.dameEmpleados();
	}

	public boolean quitaEmpleado(int id) {
		return servicioEmpleado.quitaEmpleado(id);
	}
		
	public boolean actualizaEmpleado(Empleado empleado, int id) {
		return servicioEmpleado.actualizaEmpleado(empleado, id);
	}
}