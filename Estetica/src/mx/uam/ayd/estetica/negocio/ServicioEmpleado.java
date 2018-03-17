package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;

public class ServicioEmpleado {
	private DAOEmpleado daoEmpleado;
	
	public ServicioEmpleado(DAOEmpleado daoEmpleado) {
		this.daoEmpleado=daoEmpleado;
	}

	//metodo que validará el login, si quisieramos pudiesemos ir a recuperar el nombre del DAO
	public boolean validaAdministrador(String usuario, String contraseña) {
		if(usuario.equals("miriam") && contraseña.equals("123")) {
			return true;
		}else {
			return false;
		}
	}	

	public Empleado[] dameEmpleados() {
		return daoEmpleado.dameEmpleados();
	}

	public Empleado buscaEmpleado(String nombreEmpleado) {
		return daoEmpleado.buscaEmpleado(nombreEmpleado);
	}
	
	public Empleado buscaEmpleado(int id) {
		return daoEmpleado.buscaEmpleado(id);
	}
}
