package br.com.food.order.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.food.order.dtos.ValidOrderDto;
import br.com.food.order.entities.Order;
import br.com.food.order.forms.OrderForm;
import br.com.food.order.services.OrderService;

@RestController
public class OrderController {
	
    private static Logger Logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;
    
    @PostMapping
    public ResponseEntity<Order> order(@RequestBody @Valid OrderForm orderForm){
    	Logger.info("Chamada para validar pedido");
        return ResponseEntity.ok(orderService.createOrder(orderForm));
    }

}
