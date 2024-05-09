package com.prueba.capitole.infrastructure.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.prueba.capitole.domain.model.DataPrice;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prices")
@Getter 
@Setter
public class PriceEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public PriceEntity(String idBrand, String idProduct, Integer priceList, LocalDateTime startDate, LocalDateTime endDate, String priority, String price, String curr) {
		this.idBrand = idBrand;
		this.idProduct = idProduct;
		this.priceList = priceList;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
	public DataPrice mapperModel() {
		return new DataPrice(idBrand, idProduct, priceList, startDate, endDate, price);
	}
	
	@Column(name = "idBrand")
	private String idBrand;
	
	@Column(name = "idproduct")
    private String idProduct;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pricelist")
    private Integer priceList;

	@Column(name = "startdate")
    private LocalDateTime startDate;
    
	@Column(name = "enddate")
    private LocalDateTime endDate;
    
	@Column(name = "priority")
    private String priority;

	@Column(name = "price")
    private String price;

	@Column(name = "curr")
    private String curr;

}
