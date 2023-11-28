package com.ubi.HolaSpring.dao;

import com.ubi.HolaSpring.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaDao extends JpaRepository<Persona, Long> {

}
