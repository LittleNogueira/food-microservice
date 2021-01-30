package br.com.food.order.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.food.order.dtos.ValidOrderDto;
import br.com.food.order.entities.Order;


@Mapper
public interface OrderMapper {
	
	OrderMapper INSTANCE = Mappers.getMapper( OrderMapper.class );

    Order requestToEntity(ValidOrderDto validOrderDto);
	
}
