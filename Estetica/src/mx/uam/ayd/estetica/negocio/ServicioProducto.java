package mx.uam.ayd.estetica.negocio;

import java.util.ArrayList;

import mx.uam.ayd.estetica.modelo.Producto;
import mx.uam.ayd.estetica.persistencia.DAOProducto;

public class ServicioProducto {
	private DAOProducto daoProducto;

	public ServicioProducto(DAOProducto daoProducto) {
		this.daoProducto = daoProducto;
	}

	public Producto buscaProducto(String nombre) {
		
		return daoProducto.buscaProducto(nombre);
	}
         // llama al dao y retorna true si se añadio el producto
	public boolean añadirProducto(Producto producto) {
		
		return daoProducto.añadirProducto(producto);
	}
	
	
	public Producto buscaProducto(String nombreProducto, String marcaProducto) {
		return daoProducto.buscaProducto(nombreProducto, marcaProducto);
	}
	
		
	public Producto[] dameProductos() {
		// Si hubiera lógica de negocio se aplicaría aquí
		return daoProducto.dameProductos();
	}
	
	public boolean actualizaProducto(Producto producto, int id) {
		return daoProducto.actualizaProducto(producto, id);
	}
	
	public boolean actualizaPiezasExistentes(int piezas, int id) {
		
		return daoProducto.actualizaPiezasExistentes(piezas,id);
	}
	

}
