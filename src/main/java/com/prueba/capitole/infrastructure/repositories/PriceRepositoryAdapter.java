package com.prueba.capitole.infrastructure.repositories;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prueba.capitole.domain.model.DataPrice;
import com.prueba.capitole.domain.port.IPriceRepository;
import com.prueba.capitole.infrastructure.entity.PriceEntity;

@Component
public class PriceRepositoryAdapter implements IPriceRepository {
	
	private final JpaPriceRepository priceRepository;
	
	public PriceRepositoryAdapter(JpaPriceRepository priceRepository) {
		this.priceRepository = priceRepository;
	}
	
	@Override
	public Optional<DataPrice> findPrice(LocalDateTime fechaApp, String idProduct, String brandId)  {
		return priceRepository.findPrice(brandId, idProduct, fechaApp).map(PriceEntity::mapperModel);
	}
}
