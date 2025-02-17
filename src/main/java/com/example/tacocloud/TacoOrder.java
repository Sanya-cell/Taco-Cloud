package com.example.tacocloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TacoOrder implements Serializable {
    private  static  final long serialVersionUID=1l;
    private  Long id;
    private Date placedAt;

    @NotBlank(message = "Delivery name is re")
    private String  deliveryName;
    @NotBlank(message = "Street")
    private String  deliveryStreet;
    @NotBlank(message = "City")
    private String  deliveryCity;
    @NotBlank(message = "State")
    private String  deliveryState;
    @NotBlank(message = "Zip")
    private String  deliveryZip;
    @CreditCardNumber(message = "CreditCardNumber you error")
    private String  ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message = "Must be formatted MM/YY")
    private String  ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String  ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void aadTaco(Taco taco){
        this.tacos.add(taco);
    }
}
