package com.jose.aerolineas.services;

import com.jose.commons.models.entities.Aerolinea;
import com.jose.commons.services.CommonService;

public interface AerolineaService extends CommonService<Aerolinea>{
	Aerolinea actualizar(Aerolinea aerolinea, Long id);
}
