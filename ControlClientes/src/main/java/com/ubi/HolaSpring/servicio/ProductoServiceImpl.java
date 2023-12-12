package com.ubi.HolaSpring.servicio;

import com.ubi.HolaSpring.dao.ProductoDao;
import com.ubi.HolaSpring.domain.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements EntidadService<Producto> {

	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> listarEntidades() {
		return productoDao.findAll();
	}

	@Override
	@Transactional
	public void guardar(Producto producto) {
		productoDao.save(producto);
	}

	@Override
	@Transactional
	public void eliminar(Producto producto) {
		productoDao.delete(producto);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto encontrarEntidad(Producto producto) {
		return productoDao.findById(producto.getIdProducto()).orElse(null);

	}

}
