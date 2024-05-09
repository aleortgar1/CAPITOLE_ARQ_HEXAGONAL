package com.prueba.capitole.domain.port;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.prueba.capitole.domain.model.DataPrice;

public interface IGetPriceUseCase {

	Optional<DataPrice> getPrice(LocalDateTime fechaApp, String idProduct, String brandId);
	
}
