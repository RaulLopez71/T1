package org.cibertec.edu.pe.interfaceServicio;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.modelo.Producto;


public interface IProductoServicio {
	//Metodos del CRUD
	public List<Producto> Listado();
	public Optional<Producto> Buscar(int id);
	public void Insertar (Producto prod);
	public void Modificar (Producto prod);
	public void Suprimir(int id);

}
