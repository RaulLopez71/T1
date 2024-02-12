package org.cibertec.edu.pe.servicios;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceServicio.IProductoServicio;
import org.cibertec.edu.pe.interfaces.IProducto;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductoServicio implements IProductoServicio {
	
	@Autowired
	private IProducto data;

	@Override
	public List<Producto> Listado() {
		//findAll devuelve la lista
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> Buscar(int id) {
		//Optional<Producto> ObjP = data.findById(id);
		//return ObjP;
		return data.findById(id);
	}

	@Override
	public void Insertar(Producto prod) {
		//int index = data.save(prod);
		//return 0;
		data.save(prod);
	}

	@Override
	public void Modificar(Producto prod) {
		// En caso de que el registro NO exista, LO AGREGA
		//En caso de que el registra SI exista, LO MODIFICA
		data.save(prod);
	}

	@Override
	public void Suprimir(int id) {	
		data.deleteById(id);
	}

}

