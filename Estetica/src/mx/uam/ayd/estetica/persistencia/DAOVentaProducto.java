package mx.uam.ayd.estetica.persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.modelo.Venta;


public class DAOVentaProducto {

	/**
	 * Permite Añadir un Producto a la inventario
	 * @return true si el Producto se agrego exitosamente, false sino
	 */
	public boolean añadirVentaProducto(Venta venta) {

		int llave;

		try {
			// Crea el statement
			Statement statement = ManejadorBD.dameConnection().createStatement();

			// Envia instruccion SQL, nota el DEFAULT es para insertar la llave autogenerada
			statement.execute("insert into VentaProducto values (DEFAULT,"+venta.dameProducto().dameId()+","+venta.damePzaVendida()+","+venta.dameTotal()+")",Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = statement.getGeneratedKeys(); // Recupera la llave
			if (rs != null && rs.next()) {
			    llave = rs.getInt(1);
			    venta.cambiaId(llave); // Asigna la llave al producto
			}
			return true;
		} catch (SQLException e) {

			// Cacha excepcion
			e.printStackTrace();
			return false;
		}
	}

}
