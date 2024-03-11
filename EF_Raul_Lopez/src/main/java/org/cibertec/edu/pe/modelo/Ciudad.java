package org.cibertec.edu.pe.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_ciudad")
public class Ciudad {
	
		@Id	
		private String codigo_postal;
		
		private String nombre;
		

		public Ciudad() {
		}

		public Ciudad(String codigo_postal, String nombre) {
			this.codigo_postal = codigo_postal;
			this.nombre = nombre;
		}

		public String getCodigo_postal() {
			return codigo_postal;
		}

		public void setCodigo_postal(String codigo_postal) {
			this.codigo_postal = codigo_postal;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		
		

}
