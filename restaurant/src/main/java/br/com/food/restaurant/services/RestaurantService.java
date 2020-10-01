package br.com.food.restaurant.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.restaurant.dtos.ValidOrderDto;
import br.com.food.restaurant.entities.Food;
import br.com.food.restaurant.entities.Restaurant;
import br.com.food.restaurant.forms.ValidOrderForm;
import br.com.food.restaurant.repositories.FoodRepository;
import br.com.food.restaurant.repositories.RestaurantRepository;

@Service
public class RestaurantService {
    
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FoodRepository foodRepository;

    public List<Restaurant> getAll(){
        return restaurantRepository.findAll();
    }

    public List<Food> getFoods(Long idRestaurant){
        return foodRepository.findByRestaurantId(idRestaurant);
    }

    public ValidOrderDto validOrder(ValidOrderForm validOrderForm){
        List<Food> foods = foodRepository.findByIdIn(validOrderForm.getFoods());
        return validOrder(foods);
    }

    private ValidOrderDto validOrder(List<Food> foods){
        ValidOrderDto dto = new ValidOrderDto();

//        if(foods.isEmpty())
//            dto.setValid(Boolean.FALSE);
//            return dto;
//        }

        Restaurant restaurant = foods.get(0).getRestaurant();
        dto.setValid(foods.stream().allMatch(food -> food.getRestaurant().getId().equals(restaurant.getId())));
        dto.setFinalValue(foods.stream().map(Food::getValue).reduce(BigDecimal.ZERO, (a, b) -> a.add(b)));

        return dto;
    }
    
}