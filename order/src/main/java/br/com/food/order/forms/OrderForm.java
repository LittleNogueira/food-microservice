package br.com.food.order.forms;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.food.order.enums.Payment;

public class OrderForm {
    
    @Valid
    @NotNull
    private AddressForm address;

    @NotEmpty
    private List<Long> foods;

    private Payment payment;


    public AddressForm getAddress() {
        return this.address;
    }

    public void setAddress(AddressForm address) {
        this.address = address;
    }

    public List<Long> getFoods() {
        return this.foods;  
    }

    public void setFoods(List<Long> foods) {
        this.foods = foods;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    @Override
    public String toString() {
        return "{" +
            " address='" + getAddress() + "'" +
            ", foods='" + getFoods() + "'" +
            ", payment='" + getPayment() + "'" +
            "}";
    }

}
