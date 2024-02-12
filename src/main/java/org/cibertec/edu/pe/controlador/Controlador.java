package org.cibertec.edu.pe.controlador;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceServicio.IProductoServicio;
import org.cibertec.edu.pe.modelo.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class Controlador {
	
	@Autowired
	private IProductoServicio servicio;
	
	//Accion Listar
	@GetMapping("/listar")
	public String Listar(Model modelo) {
		List<Producto> productos= servicio.Listado();
		modelo.addAttribute("productos", productos);
		//Nombre del archivo html q va a recibir, No se pone la extension
		return "index";
	}
	
	//Accion Agregar
	@GetMapping("/new")
	public String agregar(Model modelo) {
		modelo.addAttribute("producto", new Producto());
		return "form";
	}
	
	//Accion guardar (save)
	@PostMapping("/save")
	public String save(@Validated Producto prod, Model modelo) {
		servicio.Insertar(prod);
		return "redirect:/listar";
	}
	
	//Accion Editar
	@GetMapping("/editar/{id}")
	public String editar (@PathVariable int id, Model modelo) {
		Optional<Producto> prod = servicio.Buscar(id);
		modelo.addAttribute("producto", prod);
			return "form";
	}
	
	//Model modelo ==> Sirve para pasar valores desde el controlador a la vista(Formulario)
	
	//Accion Eliminar
	@GetMapping("/eliminar/{id}")
	public String eliminar (@PathVariable int id, Model modelo ) {
		servicio.Suprimir(id);
		return"redirect:/listar";
	}

}

