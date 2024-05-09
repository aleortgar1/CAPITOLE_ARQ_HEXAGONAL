package com.prueba.capitole.test.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import com.prueba.capitole.application.service.PriceService;
import com.prueba.capitole.domain.model.DataPrice;
import com.prueba.capitole.infrastructure.controller.PriceController;
import com.prueba.capitole.infrastructure.repositories.PriceRepositoryAdapter;

@WebMvcTest(controllers = PriceController.class)
@Import(PriceController.class)
@AutoConfigureMockMvc(addFilters = true)
@ContextConfiguration(classes = { ConfiguradorSpring.class })
class PruebaCapitoleControllerUnitTest {

	DataPrice DataPrice;

	@Autowired
	private PriceService pruebaService;
	
	@Autowired
	private PriceRepositoryAdapter priceRepositoryAdapter;
	
	@Test
	void testing_getDataPrice1() {
		Optional<DataPrice> dataprice = priceRepositoryAdapter.findPrice(LocalDateTime.parse("2020-06-14T10.00.00"), "35455", "1");
		Assertions.assertThat(dataprice).isNotNull().isEqualTo(new DataPrice("1", "35455", 1, LocalDateTime.parse("2020-06-14T00.00.00"), LocalDateTime.parse("2020-12-31-23.59.59"), "35.50"));
		verify(pruebaService, times(1)).getPrice(LocalDateTime.parse("2020-06-14T10.00.00"), "35455", "1");
	}
	
	@Test
	void testing_getDataPrice2() {
		Optional<DataPrice> dataprice = priceRepositoryAdapter.findPrice(LocalDateTime.parse("2020-06-14T16.00.00"), "35455", "1");
		Assertions.assertThat(dataprice).isNotNull().isEqualTo(new DataPrice("1", "35455", 1, LocalDateTime.parse("2020-06-14T15.00.00"), LocalDateTime.parse("2020-06-14T18.30.00"), "25.45"));
		verify(pruebaService, times(1)).getPrice(LocalDateTime.parse("2020-06-14T16.00.00"), "35455", "1");
	}
	
	@Test
	void testing_getDataPrice3() {
		Optional<DataPrice> dataprice = priceRepositoryAdapter.findPrice(LocalDateTime.parse("2020-06-14T21.00.00"), "35455", "1");
		Assertions.assertThat(dataprice).isNotNull().isEqualTo(new DataPrice("1", "35455", 1, LocalDateTime.parse("2020-06-14T00.00.00"), LocalDateTime.parse("2020-12-31-23.59.59"), "35.50"));
		verify(pruebaService, times(1)).getPrice(LocalDateTime.parse("2020-06-14T21.00.00"), "35455", "1");
	}
	
	@Test
	void testing_getDataPrice4() {
		Optional<DataPrice> dataprice = priceRepositoryAdapter.findPrice(LocalDateTime.parse("2020-06-15T10.00.00"), "35455", "1");
		Assertions.assertThat(dataprice).isNotNull().isEqualTo(new DataPrice("1", "35455", 1, LocalDateTime.parse("2020-06-15T00.00.00"), LocalDateTime.parse("2020-06-15T11.00.00"), "35.50"));
		verify(pruebaService, times(1)).getPrice(LocalDateTime.parse("2020-06-15T10.00.00"), "35455", "1");
	}
	
	@Test
	void testing_getDataPrice5() {
		Optional<DataPrice> dataprice = priceRepositoryAdapter.findPrice(LocalDateTime.parse("2020-06-16T21.00.00"), "35455", "1");
		Assertions.assertThat(dataprice).isNotNull().isEqualTo(new DataPrice("1", "35455", 1, LocalDateTime.parse("2020-06-15-16.00.00"), LocalDateTime.parse("2020-12-31-23.59.59"), "35.50"));
		verify(pruebaService, times(1)).getPrice(LocalDateTime.parse("2020-06-16T21.00.00"), "35455", "1");
	}
}
