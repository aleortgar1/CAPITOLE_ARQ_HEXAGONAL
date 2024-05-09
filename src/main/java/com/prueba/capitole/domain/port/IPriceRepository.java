package com.prueba.capitole.domain.port;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.prueba.capitole.domain.model.DataPrice;

public interface IPriceRepository {
	Optional<DataPrice> findPrice(LocalDateTime fechaApp, String idProduct, String brandId);
}
