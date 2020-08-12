package br.com.food.restaurant.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.food.restaurant.dtos.FoodDto;
import br.com.food.restaurant.entities.Food;

public class FoodMapper {
    
    public static List<FoodDto> map(List<Food> foods){
        return foods.stream().map(FoodDto::new).collect(Collectors.toList());
    }

}