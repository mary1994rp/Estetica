package test.mx.uam.ayd.estetica.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.negocio.ServicioProveedor;
import test.mx.uam.ayd.estetica.persistencia.DAOProveedorSustituto;

class ServicioProveedorTest {
	
	ServicioProveedor ServicioProveedor;
	DAOProveedorSustituto daoProveedor =new DAOProveedorSustituto();
			
	@BeforeEach
	void setUp() throws Exception {
		daoProveedor =new DAOProveedorSustituto();
		ServicioProveedor = new ServicioProveedor(daoProveedor);
	}
	
	@AfterEach
	void tearDown() throws Exception {	
	}

	@Test
	void testDameProveedor() {
		/*CASO POSITIVO
		 *Precondicion "SI" hay cuentas*/
		ArrayList<Proveedor> lista = new ArrayList<>();
		
		
		
		for(Proveedor c: ServicioProveedor.dameProveedor()) {
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
