package org.cibertec.edu.pe.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalle_venta")
public class DetalleVenta {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int cantidad;

    private Date fecha_viaje;

    private Date fecha_retorno;

    private double sub_total;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_destino")
    private Ciudad ciudadDestino;

    @ManyToOne
    @JoinColumn(name = "codigo_postal_origen")
    private Ciudad ciudadOrigen;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;

	public DetalleVenta() {
	}

	public DetalleVenta(int id, int cantidad, Date fecha_viaje, Date fecha_retorno, double sub_total,
			Ciudad ciudadDestino, Ciudad ciudadOrigen, Venta venta) {
		this.id = id;
		this.cantidad = cantidad;
		this.fecha_viaje = fecha_viaje;
		this.fecha_retorno = fecha_retorno;
		this.sub_total = sub_total;
		this.ciudadDestino = ciudadDestino;
		this.ciudadOrigen = ciudadOrigen;
		this.venta = venta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha_viaje() {
		return fecha_viaje;
	}

	public void setFecha_viaje(Date fecha_viaje) {
		this.fecha_viaje = fecha_viaje;
	}

	public Date getFecha_retorno() {
		return fecha_retorno;
	}

	public void setFecha_retorno(Date fecha_retorno) {
		this.fecha_retorno = fecha_retorno;
	}

	public double getSub_total() {
		return sub_total;
	}

	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}

	public Ciudad getCiudadDestino() {
		return ciudadDestino;
	}

	public void setCiudadDestino(Ciudad ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public Ciudad getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(Ciudad ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
    
    
	
	
	

}
