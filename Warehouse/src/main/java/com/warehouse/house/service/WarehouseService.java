package com.warehouse.house.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.warehouse.house.constants.Constants;
import com.warehouse.house.dto.WarehouseDTO;
import com.warehouse.house.dto.WarehouseDTORequest;
import com.warehouse.house.entity.WarehouseEntity;
import com.warehouse.house.repository.WarehouseRepository;

@Service
public class WarehouseService {
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	
	public Integer createWarehouse(WarehouseDTO warehouseDTO) {
		
		if(!ObjectUtils.isEmpty(warehouseDTO)) {
			WarehouseEntity warehouseEntity = new WarehouseEntity();
			convertToEntity(warehouseDTO, warehouseEntity);
			warehouseRepository.save(warehouseEntity);
			return Constants.SUCCESS_CODE;
		}
		else {
			return Constants.FAILURE_CODE;
		}
	}
	
	public static void convertToEntity(WarehouseDTO warehouseDTO,WarehouseEntity warehouseEntity) {
	warehouseEntity.setName(warehouseDTO.getName()!=null?warehouseDTO.getName():null);
	warehouseEntity.setDescription(warehouseDTO.getDescription()!=null?warehouseDTO.getDescription():null);
	warehouseEntity.setVendor(warehouseDTO.getVendor()!=null?warehouseDTO.getVendor():null);
	warehouseEntity.setPrice(warehouseDTO.getPrice()!=null?warehouseDTO.getPrice():null);
	warehouseEntity.setStock(warehouseDTO.getStock()!=null?warehouseDTO.getStock():null);
	warehouseEntity.setCurrency(warehouseDTO.getCurrency()!=null?warehouseDTO.getCurrency():null);
	warehouseEntity.setImage_url(warehouseDTO.getImage_url()!=null?warehouseDTO.getImage_url():null);
	warehouseEntity.setSku(warehouseDTO.getSku()!=null?warehouseDTO.getSku():null);
		
	}
	

	public Integer updateWarehouse(int id,WarehouseDTORequest warehouseDTORequest) {
		Optional<WarehouseEntity> optionalEntity= warehouseRepository.findById(id);
		if(!optionalEntity.isEmpty()) {
			WarehouseEntity warehouseEntity = optionalEntity.get();
			warehouseEntity.setId(id);
			warehouseDTORequestconvertToEntity(warehouseDTORequest,warehouseEntity);
			warehouseRepository.save(warehouseEntity);
			if(!ObjectUtils.isEmpty(warehouseEntity)) {
				return Constants.SUCCESS_CODE;
			}
			else {
				return Constants.FAILURE_CODE;
			}
		}
		else {
			return Constants.FAILURE_CODE;
		}
		
	}
	public static void warehouseDTORequestconvertToEntity(WarehouseDTORequest warehouseDTORequest,WarehouseEntity warehouseEntity) {
		warehouseEntity.setStock(warehouseDTORequest.getStock()!=null?warehouseDTORequest.getStock():null);
		warehouseEntity.setPrice(warehouseDTORequest.getPrice()!=null?warehouseDTORequest.getPrice():null);
	}
	
	
	public List<WarehouseDTO> getAllProducts() {
		List<WarehouseEntity> warehouselist = warehouseRepository.findAll();
		List<WarehouseDTO> list = new ArrayList<>();
		for(WarehouseEntity warehouseEntity:warehouselist) {
			if(!ObjectUtils.isEmpty(warehouseEntity)) {
				WarehouseDTO warehouseDTO =  convertToDTO(warehouseEntity);
				list.add(warehouseDTO);
			}
			else {
				return null;
			}
		}
		return list;
	}
	
	
	
	public WarehouseDTO getByVendor(String vendor) {
		Optional<WarehouseEntity> optionalEntity = warehouseRepository.findByVendor(vendor);
		if(!optionalEntity.isEmpty()) {
			WarehouseEntity warehouseEntity= optionalEntity.get();
			WarehouseDTO warehouseDTO= convertToDTO(warehouseEntity);
			return warehouseDTO;
		}
		else {
			return null;
		}
		
		
		
		
	}
	
	public static WarehouseDTO convertToDTO(WarehouseEntity warehouseEntity) {
		 
		WarehouseDTO warehouseDTO = new WarehouseDTO();
		warehouseDTO.setName(warehouseEntity.getName()!=null?warehouseEntity.getName():null);
		warehouseDTO.setDescription(warehouseEntity.getDescription()!=null?warehouseEntity.getDescription():null);
		warehouseDTO.setVendor(warehouseEntity.getVendor()!=null?warehouseEntity.getVendor():null);
		warehouseDTO.setPrice(warehouseEntity.getPrice()!=null?warehouseEntity.getPrice():null);
		warehouseDTO.setStock(warehouseEntity.getStock()!=null?warehouseEntity.getStock():null);
		warehouseDTO.setCurrency(warehouseEntity.getCurrency()!=null?warehouseEntity.getCurrency():null);
		warehouseDTO.setImage_url(warehouseEntity.getImage_url()!=null?warehouseEntity.getImage_url():null);
		warehouseDTO.setSku(warehouseEntity.getSku()!=null?warehouseEntity.getSku():null);
		
		
		return warehouseDTO;
	}
	
	public Integer deleteById(int id) {
		Optional<WarehouseEntity> optionalEntity = warehouseRepository.findById(id);
		if(optionalEntity.isPresent()) {
			//optionalEntity.get();
			warehouseRepository.deleteById(id);
			return Constants.SUCCESS_CODE;
		}
		else {
			return Constants.FAILURE_CODE;
		}
		
	}
	

}