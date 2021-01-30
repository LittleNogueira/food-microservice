package br.com.food.order.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.food.order.enums.Status;

@Entity
@Table(name = "order_table")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Status status;
	
	private BigDecimal finalValue;
	
	public Order() {
		this.status = Status.CREATING;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public BigDecimal getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(BigDecimal finalValue) {
		this.finalValue = finalValue;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", finalValue=" + finalValue + "]";
	}

}
