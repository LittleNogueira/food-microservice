package br.com.food.restaurant.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.restaurant.controllers.RestaurantController;
import br.com.food.restaurant.dtos.ValidOrderDto;
import br.com.food.restaurant.entities.Food;
import br.com.food.restaurant.entities.Restaurant;
import br.com.food.restaurant.forms.ValidOrderForm;
import br.com.food.restaurant.repositories.FoodRepository;
import br.com.food.restaurant.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
    private static Logger Logger = LoggerFactory.getLogger(RestaurantService.class);
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodRepository foodRepository;

    public List<Restaurant> getAll(){
    	Logger.info("Chamada de serviço para listar todos os restaurantes");
        return restaurantRepository.findAll();
    }

    public List<Food> getFoods(Long idRestaurant){
    	Logger.info("Chamada de serviço para listar todos os pratos do restaurante de id {}", idRestaurant);
        return foodRepository.findByRestaurantId(idRestaurant);
    }

    public ValidOrderDto validOrder(ValidOrderForm validOrderForm){
    	Logger.info("Chamada de serviço para validar o pedido {}", validOrderForm);
        List<Food> foods = foodRepository.findByIdIn(validOrderForm.getFoods());
        return validOrder(foods);
    }

    private ValidOrderDto validOrder(List<Food> foods){
    	
//    	try { isto é para causa o circuit break no servico de pedidos
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
    	ValidOrderDto dto = new ValidOrderDto();

        if(foods.isEmpty()) {
            dto.setValid(Boolean.FALSE);
            
        	Logger.info("Chamada de serviço para validar realizado {}", dto);
            
            return dto;
        }
        
        Restaurant restaurant = foods.get(0).getRestaurant();
        
        dto.setValid(foods.stream().allMatch(food -> food.getRestaurant().getId().equals(restaurant.getId())));
        dto.setFinalValue(foods.stream().map(Food::getValue).reduce(BigDecimal.ZERO, (a, b) -> a.add(b)));

    	Logger.info("Chamada de serviço para validar realizado {}", dto);
        
        return dto;
    }
    
}