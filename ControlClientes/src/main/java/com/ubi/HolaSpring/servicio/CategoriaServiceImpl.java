package com.ubi.HolaSpring.servicio;

import com.ubi.HolaSpring.dao.CategoriaDao;
import com.ubi.HolaSpring.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements EntidadService<Categoria> {

	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> listarEntidades() {
		return categoriaDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Categoria categoria) {
		categoriaDao.save(categoria);
	}

	@Override
	@Transactional
	public void eliminar(Categoria categoria) {
		categoriaDao.delete(categoria);
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria encontrarEntidad(Categoria categoria) {
		return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
	}

	@Override
	public List<Categoria> buscarProductos(String nombre) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}

}
