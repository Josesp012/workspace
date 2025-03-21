package com.jose.aerolinea.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jose.aerolinea.repository.AerolineaRepository;
import com.jose.commons.models.entities.Aerolinea;
import com.jose.commons.services.CommonServiceImpl;

@Service
public class AerolineaServiceImpl extends CommonServiceImpl<Aerolinea, AerolineaRepository> implements AerolineaService{
	@Override
	@Transactional
	public Aerolinea actualizar(Aerolinea aerolinea, Long id) {
		Optional<Aerolinea> optAerolinea = repository.findById(id);
		if(optAerolinea.isPresent()) {
			Aerolinea aerolineaDb=optAerolinea.get();
			aerolineaDb.setNombre(aerolinea.getNombre());
			aerolineaDb.setIata(aerolinea.getIata());
			aerolineaDb.setPais(aerolinea.getPais());
			aerolineaDb.setFechaFundacion(aerolinea.getFechaFundacion());
			aerolineaDb.setEstatus(aerolinea.getEstatus());
			repository.save(aerolineaDb);
			return aerolineaDb;
		}
		return null;
	}
}//AerolineaServiceImpl
