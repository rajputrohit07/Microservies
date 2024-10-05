package com.microservice.order_service.service;

import com.microservice.order_service.dto.OrderLineItemsDTO;
import com.microservice.order_service.dto.OrderRequest;
import com.microservice.order_service.model.Order;
import com.microservice.order_service.model.OrderLineItems;
import com.microservice.order_service.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {

	private final OrderRepository orderRepository;

	/**
	 *
	 * @param orderRequest
	 * @author Rohit Rajput
	 */
	public void placeOrder(OrderRequest orderRequest) {
		log.info("OrderService: Placing the Order!!!!!");
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID().toString());
		List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDTOList().stream().map(this::mapToDto)
				.toList();
		order.setOrderLineItemsList(orderLineItemsList);
		orderRepository.save(order);
		log.info("Order Details Saved!!!!");
	}

	/**
	 *
	 * @param orderLineItemsDTO
	 * @return
	 */
	private OrderLineItems mapToDto(OrderLineItemsDTO orderLineItemsDTO) {
		OrderLineItems orderLineItems = new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDTO.getPrice());
		orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
		orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
		return orderLineItems;
	}

}
