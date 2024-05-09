package com.prueba.capitole.infrastructure.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.capitole.application.service.PriceService;
import com.prueba.capitole.domain.model.DataPrice;

@RestController
@RequestMapping("/api/price")
public class PriceController {
	
	private PriceService priceService;
	
	public PriceController(PriceService priceService) {
		this.priceService=priceService;
	}

	@GetMapping("/{fechaApp}/{idProduct}/{brandId}")
	public ResponseEntity<DataPrice> getprice(@PathVariable String fechaApp, @PathVariable String idProduct, @PathVariable String brandId){				
		return priceService.getPrice(LocalDateTime.parse(fechaApp), idProduct, brandId).map(dataPrice -> new ResponseEntity<>(dataPrice, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}
