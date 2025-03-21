package com.jose.avion.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jose.avion.clients.AerolineaClient;
import com.jose.avion.dto.AvionDTO;
import com.jose.commons.models.entities.Aerolinea;
import com.jose.commons.models.entities.Avion;

@Component
public class AvionMapper {
	
	@Autowired
	private AerolineaClient aerolineaClient;
	
	//Convierte una entidad Avion a AvionDTO
	public AvionDTO entityToDto(Avion avion) {
		if (avion==null) {
			return null;
		}		
		AvionDTO avionDTO = new AvionDTO();
		avionDTO.setId(avion.getId());
		avionDTO.setNumeroRegistro(avion.getNumeroRegistro());
		avionDTO.setTipo(avion.getTipo());
		avionDTO.setCodigoModelo(avion.getCodigoModelo());
		avionDTO.setCapacidad(avion.getCapacidad());
		avionDTO.setFechaPrimerVuelo(avion.getFechaPrimerVuelo());
		avionDTO.setEstatus(avion.getEstatus());
		avionDTO.setIdAerolinea(avion.getIdAerolinea() != null ? avion.getIdAerolinea().getId(): null);
		
		return avionDTO;
	}
	
	//Convierte una entidad AvionDTO a Avion
	public Avion dtoToEntity(AvionDTO avionDTO) {
		if (avionDTO==null) {
			return null;
		}
		Avion avion = new Avion();
		avion.setId(avionDTO.getId());
		avion.setNumeroRegistro(avionDTO.getNumeroRegistro());
		avion.setTipo(avionDTO.getTipo());
		avion.setCodigoModelo(avionDTO.getCodigoModelo());
		avion.setCapacidad(avionDTO.getCapacidad());
		avion.setFechaPrimerVuelo(avionDTO.getFechaPrimerVuelo());
		avion.setEstatus(avionDTO.getEstatus());
		Optional<Aerolinea> aerolinea = aerolineaClient.getAerolineaById(avionDTO.getIdAerolinea());
		avion.setIdAerolinea(aerolinea.isPresent()? aerolinea.get(): null);
		return avion;
	}
	
}
