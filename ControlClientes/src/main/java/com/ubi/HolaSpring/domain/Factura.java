package com.ubi.HolaSpring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFactura;

	@NotEmpty
	private String nombre;

	@NotNull
	private Double precio;

	@NotNull
	private int stock;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	// @NotEmpty
	// private String descripcion;
	//
	// @NotNull
	// private Double precioUnitario;
	//
	// private Double descuento;

}
