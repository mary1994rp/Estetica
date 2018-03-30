package test.mx.uam.ayd.estetica.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.negocio.ServicioProveedor;
import test.mx.uam.ayd.estetica.persistencia.DAOProveedorSustituto;

class ServicioProveedorTest {
	
	DAOProveedorSustituto daoProveedor ;
	ServicioProveedor servicioProveedor ;
	
	@BeforeEach
	void setUp() throws Exception {
		daoProveedor = new DAOProveedorSustituto();
		servicioProveedor = new ServicioProveedor(daoProveedor);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testquitaProveedor() {
		
		//Caso 1: Si el proveedor con el id 56, SI existe:
		boolean resultado = servicioProveedor.quitaProveedor(56);
		assertEquals("Valor esperado: TRUE, Sí existe el proveedor  con el id 56, y se pudo eliminar informacion",resultado,true);
		
		//Caso 2: Si el proveedor con el id 57, NO existe:
		resultado=servicioProveedor.quitaProveedor(57);
		assertEquals("Valor esperado: FALSE, NO existe el proveedor con el id 15,  no se logro actualizar su informacion",resultado,false);
		
	}

	@Test
	void testdameProveedor() {
		
	}
}
