package com.ubi.HolaSpring.servicio;

import com.ubi.HolaSpring.dao.PersonaDao;
import com.ubi.HolaSpring.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceImpl implements EntidadService<Persona> {

    @Autowired
    private PersonaDao personaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarEntidades() {
        return personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarEntidad(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
