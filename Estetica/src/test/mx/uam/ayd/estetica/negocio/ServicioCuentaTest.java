package test.mx.uam.ayd.estetica.negocio;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

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
		
		/*CASO POSITIVO
		 *Precondicion "SI" hay cuentas*/
		ArrayList<Cuenta> lista = new ArrayList<>();
		
		for(Cuenta c: ser.dameCuentas()) {
			lista.add(c);
		}
		
		boolean resultado1 = lista.isEmpty();
		assertEquals("esperaba un false ya que la lista \"NO\" esta vacia",resultado1,false);
		
		/*CASO NEGATIVO
		 *Precondicion "NO" hay cuentas*/
		
		lista.clear();
		boolean resultado2 = lista.isEmpty();
		assertEquals("esperaba un true ya que la lista \"SI\" esta vacia",resultado2,true);
	}

}
