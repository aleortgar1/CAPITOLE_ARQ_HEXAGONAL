package com.prueba.capitole.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prueba.capitole.domain.model.DataPrice;
import com.prueba.capitole.domain.port.IGetPriceUseCase;
import com.prueba.capitole.domain.port.IPriceRepository;

public class GetPriceUseCaseImpl implements IGetPriceUseCase {
	
	private IPriceRepository priceRepository;
	
	public GetPriceUseCaseImpl(IPriceRepository priceRepository) {
		this.priceRepository=priceRepository;
	}

	@Override
	public Optional<DataPrice> getPrice(LocalDateTime fechaApp, String idProduct, String brandId) {			
		return priceRepository.findPrice(fechaApp, idProduct, brandId);
	}
}
