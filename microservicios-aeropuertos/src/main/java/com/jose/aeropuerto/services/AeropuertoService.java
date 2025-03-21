package com.jose.aeropuerto.services;

import com.jose.commons.models.entities.Aeropuerto;
import com.jose.commons.services.CommonService;

public interface AeropuertoService extends CommonService<Aeropuerto>{
	Aeropuerto actualizar(Aeropuerto aeropuerto, Long id);
}
