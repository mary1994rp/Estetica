package mx.uam.ayd.estetica.negocio;


import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.persistencia.DAOProveedor;

public class ServicioProveedor {
	private DAOProveedor daoProveedor;
	
	public ServicioProveedor(DAOProveedor daoProveedor) {
		this.daoProveedor=daoProveedor;
	}
	public boolean añadirProveedor(String nombre, String descripcion, String domicilio, String telefono) {
		//Como parametro el metodo añadir empleado recibe un 
		
		return daoProveedor.añadirProveedor(new Proveedor(nombre, descripcion, domicilio, telefono));
	}

	public Proveedor[] dameProveedor() { 
		return daoProveedor.dameProveedor();
	}

	public Proveedor buscaProveedor(String nombreProveedor) {
		return daoProveedor.buscaProveedor(nombreProveedor);
	}
	
	public Proveedor buscaProveedor(int id) {
		return daoProveedor.buscaProveedor(id);
	}
	

	public boolean quitaProveedor(int id) {
		return daoProveedor.quitaProveedor(id);
	}
	
	
}
