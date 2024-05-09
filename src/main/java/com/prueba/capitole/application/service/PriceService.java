package com.prueba.capitole.application.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prueba.capitole.domain.model.DataPrice;
import com.prueba.capitole.domain.port.IGetPriceUseCase;

public class PriceService implements IGetPriceUseCase {
	
	private IGetPriceUseCase getPriceUseCase;
	
	public PriceService(IGetPriceUseCase getPriceUseCase) {
		this.getPriceUseCase=getPriceUseCase;
	}

	@Override
	public Optional<DataPrice> getPrice(LocalDateTime fechaApp, String idProduct, String brandId) {
		return getPriceUseCase.getPrice(fechaApp, idProduct, brandId);
	}
}
