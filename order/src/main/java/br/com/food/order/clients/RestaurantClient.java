package br.com.food.order.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.food.order.dtos.ValidOrderDto;
import br.com.food.order.forms.OrderForm;

@FeignClient(name = "restaurant", path = "/restaurants")
public interface RestaurantClient {
    
    @PostMapping("/foods/valid-order")
    ValidOrderDto validOrder(OrderForm form);

}
