package org.cibertec.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;

import org.cibertec.edu.pe.model.Detalle;
import org.cibertec.edu.pe.model.Producto;
import org.cibertec.edu.pe.model.Venta;
import org.cibertec.edu.pe.repository.IDetalleRepository;
import org.cibertec.edu.pe.repository.IProductoRepository;
import org.cibertec.edu.pe.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"carrito", "total"})

public class ProductoController {
	@Autowired
	private IProductoRepository productoRepository;
	@Autowired
	private IVentaRepository ventaRepository;
	@Autowired
	private IDetalleRepository detalleRepository;
	
	@GetMapping("/index")
	public String listado(Model model) {
		List<Producto> lista = new ArrayList<>();
		lista = productoRepository.findAll();
		model.addAttribute("productos", lista);
		return "index";
	}
	

	@GetMapping("/agregar/{idProducto}")
    public String agregar(Model model, @PathVariable(name = "idProducto", required = true) int idProducto) {
        // Codigo para agregar un producto
        Producto maquina = productoRepository.findById(idProducto).orElse(null);
        if (maquina != null) {
            Detalle detalle = new Detalle();
            detalle.setProducto(maquina);
            detalle.setCantidad(1);
            detalleRepository.save(detalle);

            List<Detalle> carrito = (List<Detalle>) model.getAttribute("carrito");
            if (carrito == null) {
                carrito = new ArrayList<Detalle>();
                model.addAttribute("carrito", carrito);
            }
            carrito.add(detalle);

            double total = (double) model.getAttribute("total");
            if (maquina != null) {
                total += maquina.getPrecio();
                model.addAttribute("total", total);
            }
        }
        return "redirect:/index";
    }
	@GetMapping("/carrito")
	public String carrito() {
		return "carrito";
	}
	
	@GetMapping("/pagar")
	public String pagar(Model model) {
	    // Codigo para pagar
	    return "pagar";
	}

	@PostMapping("/actualizarCarrito")
	public String actualizarCarrito(Model model) {
	    // Codigo para actualizar el carrito
	    return "carrito";
	}
	
	// Inicializacion de variable de la sesion
	@ModelAttribute("carrito")
	public List<Detalle> getCarrito() {
		return new ArrayList<Detalle>();
	}
	
	@ModelAttribute("total")
	public double getTotal() {
		return 0.0;
	}
}

