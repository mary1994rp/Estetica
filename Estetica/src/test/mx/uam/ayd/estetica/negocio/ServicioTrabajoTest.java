package test.mx.uam.ayd.estetica.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mx.uam.ayd.estetica.modelo.Trabajo;
import mx.uam.ayd.estetica.negocio.ServicioTrabajo;
import test.mx.uam.ayd.estetica.persistencia.DAOTrabajoSustituto;

class ServicioTrabajoTest {

	ServicioTrabajo ST;
	DAOTrabajoSustituto DTS = new DAOTrabajoSustituto();
	
	@BeforeEach
	void setUp() throws Exception {
		ST = new ServicioTrabajo(DTS);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testdameTrabajosEmpleado() {
		//Provamos el metodo que recupera todos los trabajos de un empleado
		//mandamos un id de empleado cualquiera y los guardamos en una variable
		Trabajo[] trabajos=null;
		//Caso 1: el emplado con id dos si existe
		trabajos=ST.dameTrabajosEmpleado(2);
		//Como existen 2 trabajos deberia regresarm los dos
		assertEquals(2, trabajos.length,"el emplado no tenia trabajos");
		
		//Caso 2: el emplado con id tres no existe
		trabajos=ST.dameTrabajosEmpleado(3);
		//Deberia regresar un areglo de tamaño 0
		assertEquals(null, trabajos[0], "El empleado si tenia trabajos");
	}

}
