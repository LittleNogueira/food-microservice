package br.com.food.order.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.food.order.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
