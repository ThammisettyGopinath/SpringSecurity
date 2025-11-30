package com.warehouse.house.dto;

import lombok.Data;

@Data
public class WarehouseDTORequest {

	private Integer price;
	private Integer stock;
	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	

}
