package br.com.food.order.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.food.order.clients.RestaurantClient;
import br.com.food.order.dtos.ValidOrderDto;
import br.com.food.order.forms.OrderForm;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    @Autowired
    private RestaurantClient restaurantClient;
    
    @PostMapping
    public ResponseEntity<ValidOrderDto> order(@RequestBody @Valid OrderForm orderForm){
        return ResponseEntity.ok(restaurantClient.validOrder(orderForm));
    }

}
