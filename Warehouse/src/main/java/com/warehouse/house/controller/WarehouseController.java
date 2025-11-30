package com.warehouse.house.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.warehouse.house.constants.Constants;
import com.warehouse.house.dto.WarehouseDTO;
import com.warehouse.house.dto.WarehouseDTORequest;
import com.warehouse.house.service.WarehouseService;

@Controller
public class WarehouseController {
	
	@Autowired
	private WarehouseService warehouseService;
	
	@PostMapping("/Product/add")
	public ResponseEntity<?> create(@RequestBody WarehouseDTO warehouseDTO){
		Integer value = warehouseService.createWarehouse(warehouseDTO);
		if(value.equals(Constants.SUCCESS_CODE)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(Constants.WAREHOUSE_CREATED_SUCCESSFULLY);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.WAREHOUSE_CREATED_FAILED);

		}
	}
	@PutMapping("/Product/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody WarehouseDTORequest warehouseDTORequest){
		Integer value = warehouseService.updateWarehouse(id,warehouseDTORequest);
		if(value.equals(Constants.SUCCESS_CODE)) {
			return ResponseEntity.status(HttpStatus.OK).body(Constants.WAREHOUSE_UPDATED_SUCCESSFULLY);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constants.WAREHOUSE_UPDATED_FAILED);
		}
		
		
	}
	
	@GetMapping("/Products/get")
	public ResponseEntity<?> getAllProducts(){
		
		List<WarehouseDTO> warehouseDTOList = warehouseService.getAllProducts();
		if(!ObjectUtils.isEmpty(warehouseDTOList)) {
			return new ResponseEntity<>(warehouseDTOList,HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empty Records");
		}	
	}
	
	@GetMapping("/Products/vendor")
	public ResponseEntity<?> getByVendor(@RequestParam String vendor){
		WarehouseDTO warehouseDTO =warehouseService.getByVendor(vendor);
		if(!ObjectUtils.isEmpty(warehouseDTO)) {
			return new ResponseEntity<>(warehouseDTO,HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendor Not Found");
		}
		
	}
	@DeleteMapping("/Products/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		Integer value = warehouseService.deleteById(id);
		if(value.equals(Constants.SUCCESS_CODE)) {
			return ResponseEntity.status(HttpStatus.OK).body(Constants.WAREHOUSE_DELETED_SUCCESSFULLY);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Constants.WAREHOUSE_DELETED_FAILED+" Id Not Found");
		}
	}
	

}
