package test.mx.uam.ayd.estetica.persistencia;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.modelo.Empleado;
import mx.uam.ayd.estetica.persistencia.DAOCuentaContrato;

public class DAOCuentasSustituto implements DAOCuentaContrato{

	@Override
	public boolean añadirCuenta(Cuenta cuenta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitaCuenta(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cuenta buscaCuenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cuantasCuentas() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Cuenta[] dameCuentas() {
		Cuenta c1 = new Cuenta("bambam", new Empleado("jean"), "123");
		System.out.println("ESTOY EN EL DAO SUSTITUTO");
		if(c1!=null) {
			Cuenta[] arreglo = {c1};
			return arreglo;
		}else {
			return null;
		}
		
	}

	@Override
	public boolean actualizaCuenta(Cuenta cuenta, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean buscaCuenta(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		return false;
	}

}
