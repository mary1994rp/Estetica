package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Proveedor;

public interface DAOProveedorContrato {
	
	public boolean añadirProveedor(Proveedor proveedor);
	public Proveedor buscaProveedor(String nombre);	
	public boolean quitaProveedor(Proveedor proveedor);
	public Proveedor buscaProveedor(int id);
	public Proveedor[] dameProveedor();
	public int cuantosEmpleados();
	public void actualizaSalario(double salario, int idEmpleado);
	public boolean quitaProveedor(int id);

}
