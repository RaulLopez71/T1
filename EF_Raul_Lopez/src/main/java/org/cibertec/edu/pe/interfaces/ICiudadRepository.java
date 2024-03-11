package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.modelo.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepository extends JpaRepository<Ciudad, String>{

}
