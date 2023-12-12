package com.ubi.HolaSpring.servicio;

import java.util.List;

public interface EntidadService<T> {

	List<T> listarEntidades();

	void guardar(T entidad);

	void eliminar(T entidad);

	T encontrarEntidad(T entidad);

}
