package br.com.food.restaurant.dtos;

import java.math.BigDecimal;

public class ValidOrderDto {
    
    private Boolean valid;
    
    private BigDecimal finalValue;


    public Boolean isValid() {
        return this.valid;
    }

    public Boolean getValid() {
        return this.valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public BigDecimal getFinalValue() {
        return this.finalValue;
    }

    public void setFinalValue(BigDecimal finalValue) {
        this.finalValue = finalValue;
    }

    @Override
    public String toString() {
        return "{" +
            " valid='" + valid + "'" +
            ", finalValue='" + finalValue + "'" +
            "}";
    }

}
