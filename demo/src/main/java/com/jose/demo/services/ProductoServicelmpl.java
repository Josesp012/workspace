package com.jose.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.demo.dto.ProductoDTO;
import com.jose.demo.mappers.ProductoMapper;
import com.jose.demo.models.entities.CategoriaRepository;
import com.jose.demo.models.entities.Producto;
import com.jose.demo.models.repositories.ProductoRepository;

@Service
public class ProductoServicelmpl implements IService<Producto> {
	
	@Autowired
	private ProductoRepository repository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public List<Producto> listar() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Producto> listar(Pageable page) {
		return repository.findAll(page);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Producto> obtenerPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Producto crear(Producto producto) {
		return repository.save(producto);
	}

	@Override
	@Transactional
	public Producto editar(Producto producto, Long id) {
		Optional<Producto> optProducto= repository.findById(id);
		if(optProducto.isPresent()) {
			Producto productoDB = optProducto.get();
			productoDB.setNombre(producto.getNombre());
			productoDB.setDescripcion(producto.getDescripcion());
			productoDB.setStock(producto.getStock());
			return repository.save(productoDB);
		}else {
			return null;
		}
	}

	@Override
	@Transactional
	public Producto eliminar(Long id) {
		Optional<Producto> optProducto= repository.findById(id);
		 if(optProducto.isPresent()) {
			 repository.deleteById(id);
			 return optProducto.get();
		 }else {
			 return null;
		 }		 
	}
	@Transactional
	public Producto crearDto(ProductoDTO dto) {
		Producto producto= ProductoMapper.dtoToEntity(dto, categoriaRepository);
		return crear(producto);
	}
	
}//ProductoService
