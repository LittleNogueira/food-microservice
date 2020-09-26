package br.com.food.restaurant.dtos;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodDto {
    
    public Long id;

    public String name;

    public BigDecimal value;

    public String description;

}