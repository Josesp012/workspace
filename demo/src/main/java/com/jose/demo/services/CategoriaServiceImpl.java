package com.jose.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.jose.demo.models.entities.Categoria;
import com.jose.demo.models.entities.CategoriaRepository;
import com.jose.demo.models.entities.Producto;
import com.jose.demo.models.repositories.ProductoRepository;

public class CategoriaServiceImpl implements IService<Categoria> {
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired//Inyeccion de independencias
	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly= true)
	public List<Categoria> listar() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Categoria> listar(Pageable page) {
		return null;
	}

	@Override
	public Optional<Categoria> obtenerPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public Categoria crear(Categoria entity) {
		return repository.save(entity);
	}
	
	@Override
	public Categoria editar(Categoria entity, Long id) {
		Optional<Categoria> optCategoria = repository.findById(id);
		if (optCategoria.isPresent()) {
			Categoria categoriaDb = optCategoria.get();
			categoriaDb.setNombre(entity.getNombre());
			categoriaDb.setDescripcion(entity.getDescripcion());
			return repository.save(categoriaDb);
		} else {
			return null;
		}
	}

	@Override
	public Categoria eliminar(Long id) {
			Optional<Categoria> optCategoria = repository.findById(id);
			if(optCategoria.isPresent()) {
				repository.deleteById(id);
				return optCategoria.get();
			}else {
				return null;
			}	
	}
	
	@Transactional
	public Categoria addProducto(Long idCategoria, Long idProducto) {
		Categoria categoria = null;
		Optional<Categoria> optCategoria=repository.findById(idCategoria);
		if(optCategoria.isPresent()) {
			Optional<Producto> optProducto= productoRepository.findById(idProducto);
			if(optCategoria.isPresent()) {
				categoria=optCategoria.get();
				Producto producto = optProducto.get();
				categoria=repository.save(categoria);
				producto.setCategoria(categoria);
				producto = productoRepository.save(producto);
			}
		}
		return categoria;
	}
}
