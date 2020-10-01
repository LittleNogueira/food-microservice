package br.com.food.order.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddressForm {
    
    @NotNull
    @NotBlank
    private String number;

    @NotNull
    @NotBlank
    private String street;

    @NotNull
    @NotBlank
    private String neighborhood;

    @NotNull
    @NotBlank
    private String state;

    @NotNull
    @NotBlank
    private String city;


    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return this.neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "{" +
            " number='" + getNumber() + "'" +
            ", street='" + getStreet() + "'" +
            ", neighborhood='" + getNeighborhood() + "'" +
            ", state='" + getState() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }

}
