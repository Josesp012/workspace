package com.jose.vuelo.mappers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jose.commons.models.entities.Avion;
import com.jose.vuelo.dto.VueloDTO;
import com.jose.vuelo.model.entity.Vuelo;


@Component
public class VueloMapper {
	@Autowired
	//private AeropuertoClient aeropuertoClient;
	//private AvionClient avionClient;
	
	public Vuelo dtoToEntity(VueloDTO vueloDTO) {
		if (vueloDTO==null) {
			return null;
		}
		Vuelo vuelo = new Vuelo();
		vuelo.setId(vueloDTO.getId());
		vuelo.setCodigoVuelo(vueloDTO.getCodigoVuelo());
		vuelo.setFechaSalida(vueloDTO.getFechaSalida());
		vuelo.setEstatus(vueloDTO.getEstatus());
		
		//Optional<Avion> avion= avionClient.getAvionesById(vueloDTO.getIdAvion());
		//vuelo.setIdOrigen(aeropuerto.isPresent())?;
		return vuelo;
	}
	public VueloDTO entityToDto(Vuelo vuelo) {
		if (vuelo==null) {
			return null;
		}
		VueloDTO vueloDTO = new VueloDTO();
		vuelo.setId(vuelo.getId());
		vuelo.setCodigoVuelo(vuelo.getCodigoVuelo());
		vuelo.setFechaSalida(vuelo.getFechaSalida());
		vuelo.setEstatus(vuelo.getEstatus());
		
		if()
	}
}
