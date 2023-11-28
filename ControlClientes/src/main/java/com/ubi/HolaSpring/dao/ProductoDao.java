package com.ubi.HolaSpring.dao;

import com.ubi.HolaSpring.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDao extends JpaRepository<Producto, Long> {

}
