package com.ubi.HolaSpring.dao;

import com.ubi.HolaSpring.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

	Usuario findByUsername(String username);

}
