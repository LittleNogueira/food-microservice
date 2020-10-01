package br.com.food.restaurant.forms;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ValidOrderForm {
    
    @NotNull
    private List<Long> foods;

    public List<Long> getFoods() {
        return this.foods;
    }

    public void setFoods(List<Long> foods) {
        this.foods = foods;
    }

    @Override
    public String toString() {
        return "{" +
            " foods='" + getFoods() + "'" +
            "}";
    }

}
