package com.ubi.HolaSpring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @NotEmpty
    private String nombreProducto;

    @NotNull
    private Double precio;

    @NotNull
    private int stock;

    @NotEmpty
    private String descripcion;

    @NotNull
    private Double precioUnitario;

    private Double descuento;
}
