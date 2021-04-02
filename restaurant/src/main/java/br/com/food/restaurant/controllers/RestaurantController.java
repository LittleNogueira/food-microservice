package br.com.food.restaurant.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.food.restaurant.dtos.FoodDto;
import br.com.food.restaurant.dtos.ValidOrderDto;
import br.com.food.restaurant.entities.Restaurant;
import br.com.food.restaurant.forms.ValidOrderForm;
import br.com.food.restaurant.mappers.FoodMapper;
import br.com.food.restaurant.services.RestaurantService; 

@RestController
public class RestaurantController {
	
    private static Logger Logger = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restauranteService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll(){
    	Logger.info("Chamada para listar todos os restaurantes");
        return ResponseEntity.ok().body(restauranteService.getAll());
    }

    @GetMapping("/{idRestaurant}/foods")
    public ResponseEntity<List<FoodDto>> getFoodsByRestaurant(@PathVariable Long idRestaurant) {
    	Logger.info("Chamada para listar todos os pratos do restaurante de id {}", idRestaurant);
        return ResponseEntity.ok().body(FoodMapper.INSTANCE.entityToResponse(restauranteService.getFoods(idRestaurant)));
    }

    @PostMapping("/foods/valid-order")
    public ResponseEntity<ValidOrderDto> validOrder(@RequestBody @Valid ValidOrderForm form){
    	Logger.info("Chamada para validar o pedido {}", form);
        return ResponseEntity.ok(restauranteService.validOrder(form));
    }
    
}