package com.jose.demo.mappers;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jose.demo.dto.ProductoDTO;
import com.jose.demo.models.entities.Categoria;
import com.jose.demo.models.entities.CategoriaRepository;
import com.jose.demo.models.entities.Producto;


//Mapea una entidad a un DTO

@Component
public class ProductoMapper {
	
	public static ProductoDTO entityToDTO(Producto producto) {
		if(producto==null) {
			return null;
		}else {
			ProductoDTO productoDTO= new ProductoDTO();
			productoDTO.setId(producto.getId());
			productoDTO.setNombre(producto.getNombre());
			productoDTO.setDescripcion(producto.getDescripcion());
			productoDTO.setStock(producto.getStock());
			productoDTO.setIdCategoria(producto.getCategoria().getId());
			return productoDTO;
		}
	}
	public static Producto dtoToEntity(ProductoDTO productoDTO, CategoriaRepository repository) {
		if(productoDTO == null) {
			return null;
		}else {
			Producto producto = new Producto();
			producto.setId(productoDTO.getId());
			producto.setNombre(productoDTO.getNombre());
			producto.setDescripcion(productoDTO.getDescripcion());
			producto.setStock(productoDTO.getStock());
			Optional<Categoria> categoria = repository.findById(productoDTO.getIdCategoria());
			producto.setCategoria(categoria.orElse(null));
			return producto;
		}
	}
}
