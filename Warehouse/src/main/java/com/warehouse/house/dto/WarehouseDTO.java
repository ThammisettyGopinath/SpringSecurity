package com.warehouse.house.dto;

import lombok.Data;

@Data
public class WarehouseDTO {
	
	private String name;
	private String description;
	private String vendor;
	private Integer price;
	private Integer stock;
	private String currency;
	private String image_url;
	private String sku;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
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
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	@Override
	public String toString() {
		return "WarehouseDTO [name=" + name + ", description=" + description + ", vendor=" + vendor + ", price=" + price
				+ ", stock=" + stock + ", currency=" + currency + ", image_url=" + image_url + ", sku=" + sku + "]";
	}

	

}
