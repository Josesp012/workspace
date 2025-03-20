package com.jose.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jose.demo.dto.ProductoDTO;
import com.jose.demo.models.entities.Producto;
import com.jose.demo.services.ProductoServicelmpl;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	@Autowired
	private ProductoServicelmpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Producto>>getAll(){
		return ResponseEntity.ok().body(serviceImpl.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getById(@PathVariable Long id){
		Optional<Producto> optProducto=serviceImpl.obtenerPorId(id);
		if(optProducto.isPresent()) {
			return ResponseEntity.ok(optProducto.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Producto>create(@RequestBody Producto producto){
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.crear(producto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Producto>update(@RequestBody Producto prodcuto,@PathVariable Long id){
		Producto productoDB = serviceImpl.editar(prodcuto, id);
		if(productoDB!=null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(productoDB);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Producto>delete(@PathVariable Long id){
		Producto productoDB = serviceImpl.eliminar(id);
		if(productoDB!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(productoDB);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/create-dto")
	public ResponseEntity<Producto> testController(@RequestBody ProductoDTO dto) {
		return ResponseEntity.ok(serviceImpl.crearDto(dto));
	}
	
}//ProductoController