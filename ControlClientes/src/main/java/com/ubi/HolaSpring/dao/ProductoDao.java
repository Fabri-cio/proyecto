package com.ubi.HolaSpring.dao;

import com.ubi.HolaSpring.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {

	List<Producto> findByNombreContaining(String nombre);

}
