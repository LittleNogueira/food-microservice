package br.com.food.restaurant.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.food.restaurant.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    
    List<Food> findByRestaurantId(Long idRestaurant);

    List<Food> findByIdIn(Collection<Long> ids);

}