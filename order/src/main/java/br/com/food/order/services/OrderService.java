package br.com.food.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.food.order.clients.RestaurantClient;
import br.com.food.order.dtos.ValidOrderDto;
import br.com.food.order.entities.Order;
import br.com.food.order.enums.Status;
import br.com.food.order.forms.OrderForm;
import br.com.food.order.mappers.OrderMapper;
import br.com.food.order.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private RestaurantClient client;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@HystrixCommand(fallbackMethod = "createOrderFallback", 
			ignoreExceptions = {NotAcceptableStatusException.class}, 
			threadPoolKey = "createOrderThreadPoolKey")
	public Order createOrder(OrderForm orderForm) {
		ValidOrderDto validOrderDto = client.validOrder(orderForm);
		
		if(!validOrderDto.isValid()) {
			throw new NotAcceptableStatusException("O pedido está invalido");
		}
		
		Order order = OrderMapper.INSTANCE.requestToEntity(validOrderDto);
		order.setStatus(Status.CREATED);
		
		return orderRepository.save(order);
	}
	
	public Order createOrderFallback(OrderForm orderForm){
		return orderRepository.save(new Order());
	}
	
	
}
