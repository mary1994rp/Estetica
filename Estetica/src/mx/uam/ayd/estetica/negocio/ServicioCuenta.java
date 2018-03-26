package mx.uam.ayd.estetica.negocio;

import mx.uam.ayd.estetica.modelo.Cita;
import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOCuentaContrato;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;
import mx.uam.ayd.estetica.persistencia.DAOEmpleado;

public class ServicioCuenta {
	
	private DAOCuentaContrato daoCuentas;
	

	public ServicioCuenta(DAOCuentaContrato daoCuenta) {
		this.daoCuentas=daoCuenta;
	}

	public boolean añadirCuenta(String nombre, Empleado empleado, String contraseña) {
		return daoCuentas.añadirCuenta(new Cuenta(nombre, empleado, contraseña));
	}
	
	
	public int cuantasCuentas() {
		return daoCuentas.cuantasCuentas();
	}
	
	public Cuenta[] dameCuentas() {
		// Si hubiera logica de negocio se aplicara aqui
		return daoCuentas.dameCuentas();
	}

	public boolean actualizaCuenta(Cuenta cuenta, int id) {
		
		return daoCuentas.actualizaCuenta(cuenta, id);
	}
	
	//quita cita recibe el id de la cita a eliminar
	public boolean quitaCuenta(int id) {
		return daoCuentas.quitaCuenta(id);
	}

	public boolean buscaCuenta(String usuario, String contraseña) {
		return daoCuentas.buscaCuenta(usuario, contraseña);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
