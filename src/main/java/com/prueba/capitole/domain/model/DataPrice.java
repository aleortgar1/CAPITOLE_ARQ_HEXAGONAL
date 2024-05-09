package com.prueba.capitole.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter	
public class DataPrice {
	
	private String brandId;
	
	private String idProduct;
	
	private Integer priceList;

	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private String price;
}
