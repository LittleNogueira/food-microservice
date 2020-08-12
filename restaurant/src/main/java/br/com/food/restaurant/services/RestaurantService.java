package br.com.food.restaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.food.restaurant.entities.Food;
import br.com.food.restaurant.entities.Restaurant;
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
        return foodRepository.findAllByRestaurantId(idRestaurant);
    }
    
}