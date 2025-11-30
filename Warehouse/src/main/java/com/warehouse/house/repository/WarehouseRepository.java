package com.warehouse.house.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warehouse.house.entity.WarehouseEntity;
@Repository
public interface WarehouseRepository extends JpaRepository<WarehouseEntity, Integer> {

	Optional<WarehouseEntity> findByVendor(String vendor);

}
