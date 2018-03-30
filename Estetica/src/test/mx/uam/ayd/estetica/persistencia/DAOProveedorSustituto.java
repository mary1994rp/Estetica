package test.mx.uam.ayd.estetica.persistencia;

import mx.uam.ayd.estetica.modelo.Proveedor;
import mx.uam.ayd.estetica.persistencia.DAOProveedorContrato;

public class DAOProveedorSustituto  implements  DAOProveedorContrato {

	@Override
	public boolean añadirProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean quitaProveedor(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Proveedor buscaProveedor(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor buscaProveedor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proveedor[] dameProveedor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean quitaProveedor(int id) {
		Proveedor proveedorPrueba = new Proveedor("mariana", "koleston", "col. del valle calle 56", "17098654");
		proveedorPrueba.cambiaId(56);
		if(id==56) {
			proveedorPrueba=null;
			return true;
		}
		//si el identificador no existe
		else
		return false;
	}

}
