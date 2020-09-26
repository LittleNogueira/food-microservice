package br.com.food.restaurant.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.food.restaurant.dtos.FoodDto;
import br.com.food.restaurant.entities.Food;

@Mapper
public interface FoodMapper {
   
    FoodMapper INSTANCE = Mappers.getMapper( FoodMapper.class );

    List<FoodDto> entityToResponse(List<Food> food);

    @InheritInverseConfiguration
    FoodDto entityToResponse(Food food);

    Food requestToEntity(FoodDto dto);

}