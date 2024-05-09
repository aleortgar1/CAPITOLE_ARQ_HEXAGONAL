package com.prueba.capitole.infrastructure.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.prueba.capitole.application.service.GetPriceUseCaseImpl;
import com.prueba.capitole.application.service.PriceService;
import com.prueba.capitole.domain.port.IPriceRepository;
import com.prueba.capitole.infrastructure.repositories.PriceRepositoryAdapter;


@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.prueba.capitole.application.service", "com.prueba.capitole.infrastructure.repositories"})
@EntityScan(basePackageClasses = {com.prueba.capitole.infrastructure.entity.PriceEntity.class})
//@EnableJpaRepositories(basePackageClasses = { com.prueba.capitole.infrastructure.repositories.JpaPriceRepository.class })
public class ApplicationConfig {
	
	@Bean
	public PriceService priceServ(IPriceRepository priceRepo) {
		return new PriceService(new GetPriceUseCaseImpl(priceRepo));
	}
	
	@Bean
	public IPriceRepository priceRepo(PriceRepositoryAdapter priceRepo) {
		return priceRepo;
	}
}
