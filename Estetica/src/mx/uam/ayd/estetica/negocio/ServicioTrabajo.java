package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.persistencia.DAOTrabajo;

public class ServicioTrabajo {
	
	/**
	 * Dao Trabajo
	 */
	private DAOTrabajo daoTrabajo;
	
	/**
	 * Constructor de la clase
	 */
	public ServicioTrabajo(DAOTrabajo daoTrabajo) {
		this.daoTrabajo=daoTrabajo;
	}
	
	/**
	 * Permite añadir un trabajo al Registro
	 * @return true si el trabajo se agrego exitosamente, false si no
	 */
	public boolean añadirTrabajo(String nombreservicio, Empleado empleado, String descripcion, double monto,
			String fecha, Producto producto, int pzs_usadas) {
		return daoTrabajo.añadirTrabajo(new Trabajo(nombreservicio,empleado,descripcion,monto,fecha,producto,pzs_usadas));
	}
	
	
	/**
	 * Regresa los trabajos del registro como un arreglo de trabajos
	 * @return el arreglo de trabajos
	 */
	public Trabajo[] dameTrabajos() {
		
		return daoTrabajo.dameTrabajos();
	}

	/**
	 * Permite actualizar un trabajo que se halla modificado
	 * @return true si el trabajo se actualizo correctamente
	 */
	public boolean actualizaTrabajo(int id, String servicio, Empleado empleado, String descripcion, double monto, String fecha,
			Producto producto, int pzaUsadas) {
		Trabajo trabajo = new Trabajo(servicio, empleado, descripcion, monto, fecha, producto, pzaUsadas);
		trabajo.cambiaId(id);
		return daoTrabajo.actualizaTrabajo(trabajo);
	}

}
