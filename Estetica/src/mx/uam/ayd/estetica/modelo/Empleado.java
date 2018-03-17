package mx.uam.ayd.estetica.modelo;

public class Empleado {
	
	/******Atributos*********/
	private int id;
	private String nombre;
	
	/*********************   Constructor  ******************************/
	
	public Empleado(String nombre) {
		this.nombre=nombre;
	}
	
	/*********************   SETs y GETs  ******************************/
	
	/******id*********/
	public void cambiaId(int id) {
		this.id=id;
	}
	
	public int dameId() {
		return id;
	}
	
	/******nombre*********/
	
	public String dameNombre() {
		return nombre;
	}
	
	public void cambiaNombre() {
		this.nombre = nombre;
	}
	
}
