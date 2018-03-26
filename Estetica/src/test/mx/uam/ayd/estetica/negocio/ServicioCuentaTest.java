package test.mx.uam.ayd.estetica.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.modelo.Cuenta;
import mx.uam.ayd.estetica.negocio.ServicioCuenta;
import test.mx.uam.ayd.estetica.persistencia.DAOCuentasSustituto;

class ServicioCuentaTest {
	
	ServicioCuenta ser;
	DAOCuentasSustituto dao = new DAOCuentasSustituto();
	

	@BeforeEach
	void setUp() throws Exception {
		ser= new ServicioCuenta(dao);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDameCuentas() {
		//caso negativo no hay nada en la base y me regresa null
		Cuenta[] obj= ser.dameCuentas();
		boolean resultado;
		
		if(obj==null) {
			resultado = true;
		}
		assertEquals(obj,true);
		
		
		//caso positivo hay cuentas en la base y me regresa el arreglo
				obj= ser.dameCuentas();
				if(obj!=null) {
					resultado = true;
				}
				assertEquals(obj,true);
	}

}
