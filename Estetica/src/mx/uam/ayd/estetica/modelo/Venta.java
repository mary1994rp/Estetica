package mx.uam.ayd.estetica.modelo;

public class Venta {
	
	
	/******Atributos*********/
	private int id;
	private Producto producto;
	private int pzaVendida;
	
	/*********************   Constructor  ******************************/

	public Venta(Producto producto, int pzaVendida) {
		this.producto=producto;
		this.pzaVendida=pzaVendida;
	}
	
	/*********************   SETs y GETs  ******************************/
	
	/******id*********/
	
	public void cambiaId(int id) {
		this.id=id;
		
	}
	
	public int dameId() {
		return id;
		
	}
	
	/******Producto*********/
	
	
	public Producto dameProducto(){
		return producto;
	}
	
	public void cambiaProducto(Producto producto){
		this.producto=producto;
	}
	
	
	/******pzaVendida*********/

	public int damePzaVendida() {
		return pzaVendida;
	}


	public void cambiaPzaVendida(int pzaVendida) {
		this.pzaVendida = pzaVendida;
	}

	
	
}
