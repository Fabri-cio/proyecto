package com.ubi.HolaSpring.dao;

import com.ubi.HolaSpring.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

}
