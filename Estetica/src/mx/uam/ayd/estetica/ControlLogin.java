package mx.uam.ayd.estetica;

import javax.swing.JOptionPane;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import mx.uam.ayd.estetica.persistencia.DAOCuentas;

public class ControlLogin {
	
	private DAOCuentas daoCuenta;
	private ServicioCuenta servicioCuenta;

	public ControlLogin() {
		
		//inicializamos el DAOCuenta
		daoCuenta = new DAOCuentas();
		//inicializamos los Servicios
		servicioCuenta = new ServicioCuenta(daoCuenta);
		
	}
	
	//inicia la ventana login
	public void inicia() {
		new VentanaLogin(this);
	}
	
	//arranca el SISTEMA
	public static void main(String[] args) {
		ControlLogin ctrlLogin = new ControlLogin();
		ctrlLogin.inicia();	
	}

	public boolean validaCuentaAdmin(String usuario, String contraseña) {
		
		if( (usuario.equals("miriam")) && (contraseña.equals("123"))) {
			JOptionPane.showMessageDialog(null, "Iniciando como ADMINISTRADOR");
			return true;
		}
		
		return false;
	}

	public boolean validaCuentaUsuario(String usuario, String contraseña) {
		for(Cuenta c: servicioCuenta.dameCuentas()) {
			if((c.dameNombre().equals(usuario)) && (c.dameContraseña().equals(contraseña))){
				JOptionPane.showMessageDialog(null, "Iniciando como USUARIO");
				return true;
			}
		}
		return false;
	}
}