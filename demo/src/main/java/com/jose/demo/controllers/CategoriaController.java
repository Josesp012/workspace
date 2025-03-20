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

import com.jose.demo.models.entities.Categoria;
import com.jose.demo.services.CategoriaServiceImpl;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaServiceImpl serviceImpl;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(serviceImpl.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria>getById(@PathVariable Long id){
		Optional<Categoria> optCategoria = serviceImpl.obtenerPorId(id);
		if(optCategoria.isPresent()) {
			return ResponseEntity.ok(optCategoria.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceImpl.crear(categoria));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria>update(@RequestBody Categoria categoria,@PathVariable long id){
		return ResponseEntity.ok(serviceImpl.editar(categoria, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Categoria> delete(@PathVariable Long id) {
		Optional<Categoria> optCategoria = serviceImpl.obtenerPorId(id);
		if (optCategoria.isPresent()) {
			return ResponseEntity.ok(serviceImpl.eliminar(id));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{idCategoria}/{idProducto}")
	public ResponseEntity<Categoria> addProducto(@PathVariable Long idCategoria, @PathVariable Long idProducto){
		Categoria categoria = serviceImpl.addProducto(idCategoria, idProducto);
		if (categoria == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoria);
	}
	
}//CategoriaController
