package com.microservice.inventory_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.inventory_service.service.InventoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping(value = "/{skuCode}")
	public boolean isInStock(@PathVariable("skuCode") String skuCode) {
		log.info("Checking intentory!!!!");
		log.info("SkuCode: " + skuCode);
		return inventoryService.isInStock(skuCode);
	}

}
