package br.com.food.restaurant.dtos;

import br.com.food.restaurant.entities.Food;

public class FoodDto {
    
    public Long id;

    public String name;

    public String description;

    public FoodDto(Food food){
        this.id = food.getId();
        this.name = food.getName();
        this.description = food.getDescription();
    }
}