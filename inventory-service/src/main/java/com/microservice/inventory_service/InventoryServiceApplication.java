package com.microservice.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.microservice.inventory_service.model.Inventory;
import com.microservice.inventory_service.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return agrs -> {
			Inventory i1 = this.createData("iphone_15", 5);
			Inventory i2 = this.createData("iphone_16", 0);

			inventoryRepository.save(i1);
			inventoryRepository.save(i2);
		};
	}

	private Inventory createData(String skuCode, Integer quantity) {
		Inventory inventory = new Inventory();
		inventory.setSkuCode(skuCode);
		inventory.setQuantity(quantity);
		return inventory;
	}

}
