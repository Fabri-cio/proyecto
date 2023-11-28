package com.ubi.HolaSpring.web;

import com.ubi.HolaSpring.domain.Persona;
import com.ubi.HolaSpring.domain.Producto;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.ubi.HolaSpring.servicio.EntidadService;

@Controller
@Slf4j // para el manejo de loggin acceso a la variable log
public class RestController {

	@Autowired
	private EntidadService<Persona> personaService;

	@Autowired
	private EntidadService<Producto> productoService;

	@GetMapping("/") // mapeamos la ruta donde se mostrara
	// @AuthenticationPrincipal User user lo utilizamos para ver quien entro en consola
	public String start(Model model, @AuthenticationPrincipal User user) {
		var personas = personaService.listarEntidades();
		log.info("ejecutando el controlador Spring: MVC");
		log.info("usuario que hizo login " + user);
		model.addAttribute("personas", personas);
		var saldoTotal = 0D;
		for (var p : personas) {
			saldoTotal += p.getSaldo();
		}
		model.addAttribute("saldoTotal", saldoTotal);
		model.addAttribute("totalClientes", personas.size());
		return "index";
	}

	@GetMapping("/agregar")
	public String agregar(Persona persona) {
		return "modificar";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Persona persona, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		personaService.guardar(persona);
		return "redirect:/";
	}

	@GetMapping("/editar/{idPersona}")
	public String editar(Persona persona, Model model) {
		persona = personaService.encontrarEntidad(persona);
		model.addAttribute("persona", persona);
		return "modificar";
	}

	// @GetMapping("/eliminar")
	// con query parameter
	@GetMapping("/eliminar")
	public String eliminar(Persona persona) {
		personaService.eliminar(persona);
		return "redirect:/";
	}

	@GetMapping("/layout/inventario")
	public String inventario(Model model) {
		var productos = productoService.listarEntidades();
		model.addAttribute("productos", productos);
		return "layout/inventario";
	}

	@GetMapping("/agregarProducto")
	public String agregarProducto(Producto producto) {
		return "modificarProducto";
	}

	@PostMapping("/guardar")
	public String guardar(@Valid Producto producto, Errors errores) {
		if (errores.hasErrors()) {
			return "modificar";
		}
		productoService.guardar(producto);
		return "layout/inventario";
	}

	@GetMapping("/editarProducto/{idProducto}")
	public String editarProducto(Producto producto, Model model) {
		producto = productoService.encontrarEntidad(producto);
		model.addAttribute("persona", producto);
		return "modificarProducto";
	}

	@GetMapping("/eliminarProducto/{idProducto}")
	public String eliminarProducto(Producto producto) {

		productoService.eliminar(producto);
		return "redirect:/layout/inventario";
	}

	@GetMapping("/layout/dashboard")
	public String dashboard() {
		return "layout/dashboard";
	}

	@GetMapping("/layout/punto_de_venta")
	public String puntoDeVenta() {
		return "layout/punto_de_venta";
	}

	@GetMapping("/layout/generacion_de_informes")
	public String GeneracionImformes() {
		return "layout/generacion_de_informes";
	}

	@GetMapping("/layout/notificaciones_alertas")
	public String NotificacionesAlertas() {
		return "layout/notificaciones_alertas";
	}

	@GetMapping("/layout/registro_de_ventas")
	public String RegistroVentas() {
		return "layout/registro_de_ventas";
	}

	@GetMapping("/layout/gestion_de_clientes")
	public String GestionClientes() {
		return "layout/gestion_de_clientes";
	}

}
