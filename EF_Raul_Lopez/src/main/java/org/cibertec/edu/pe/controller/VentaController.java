package org.cibertec.edu.pe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

import org.cibertec.edu.pe.interfaces.ICiudadRepository;
import org.cibertec.edu.pe.modelo.Ciudad;
import org.cibertec.edu.pe.modelo.DetalleVenta;

@Controller
@RequestMapping("/venta")
public class VentaController {

    @Autowired
    private ICiudadRepository ciudadRepository;

    @GetMapping("/formulario")
    public String mostrarCiudades(Model model) {
        List<Ciudad> ciudades = ciudadRepository.findAll();
        model.addAttribute("ciudades", ciudades);
        model.addAttribute("detalleVenta", new DetalleVenta()); 
        return "viajes"; // 
    }
    @PostMapping("/comprar")
    public String comprarBoletos(RedirectAttributes redirectAttributes) {
       
        redirectAttributes.addFlashAttribute("mensaje", "Compra realizada correctamente");
        return "redirect:/ventas/formulario";
    }
    
    @PostMapping("/agregar")
    public String agregarVenta(@ModelAttribute DetalleVenta detalleVenta, RedirectAttributes redirectAttributes) {
        try {
            
            redirectAttributes.addFlashAttribute("mensaje", "Detalle de venta agregado correctamente");
            return "redirect:/ventas/formulario";
        } catch (Exception e) {
            
            redirectAttributes.addFlashAttribute("error", "Error al agregar la venta: " + e.getMessage());
            return "redirect:/ventas/formulario";
        }
    }

    
    @PostMapping("/limpiar")
    public String limpiarFormulario(RedirectAttributes redirectAttributes) {      
        redirectAttributes.addFlashAttribute("mensaje", "Formulario limpiado correctamente");
        return "redirect:/ventas/formulario";
    }

    
}
