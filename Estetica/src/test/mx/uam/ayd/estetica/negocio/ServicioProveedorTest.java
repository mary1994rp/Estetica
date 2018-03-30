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
	void testValidaQuitaProveedor() {
		int id;
		id=56;
		boolean resultado = servicioProveedor.quitaProveedor(id);
		assertEquals("Valor esperado: TRUE, Sí existe el proveedor  con el id 56, y se pudo eliminar informacion",resultado,true);
		id=57;
		//Caso 2: Si el proveedor con el id 57 ,pasado como argumento, NO existe:
		resultado=servicioProveedor.quitaProveedor(id);
		assertEquals("Valor esperado: FALSE, NO existe el proveedor con el id 15,  no se logro actualizar su informacion",resultado,false);
		System.out.println("olaaa");
		
	}

}
