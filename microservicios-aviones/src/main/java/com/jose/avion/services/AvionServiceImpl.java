package com.jose.avion.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.avion.dto.AvionDTO;
import com.jose.avion.mappers.AvionMapper;
import com.jose.avion.repository.AvionRepository;
import com.jose.commons.models.entities.Avion;
import com.jose.commons.services.CommonServiceImpl;

@Service
public class AvionServiceImpl extends CommonServiceImpl<Avion, AvionRepository>
implements AvionService{
	
	private final AvionMapper mapper;
	
	public AvionServiceImpl(AvionMapper mapper) {
		this.mapper = mapper;
	}
	
	@Override
	@Transactional
	public Avion createAvionDTO(AvionDTO avionDTO) {
		Avion avion = mapper.dtoToEntity(avionDTO);
		return repository.save(avion);
	}
	
	@Override
	@Transactional
	public Avion update(AvionDTO avionDTO, Long id) {
		Optional<Avion> opt = repository.findById(id);
		if(opt.isPresent()) {
			Avion avionDb= mapper.dtoToEntity(avionDTO);
			avionDb.setId(id);
			return repository.save(avionDb);
		}
		return null;
	}
}//AvionServiceImpl
