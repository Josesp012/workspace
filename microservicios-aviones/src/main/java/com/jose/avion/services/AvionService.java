package com.jose.avion.services;

import com.jose.avion.dto.AvionDTO;
import com.jose.commons.models.entities.Avion;
import com.jose.commons.services.CommonService;

public interface AvionService extends CommonService<Avion>{
	
	Avion createAvionDTO(AvionDTO avionDTO);
	
	Avion update(AvionDTO avionDTO, Long id);

}
