package com.example.tacocloud;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private  Long id;
    private Date createdAt = new Date();

    @NotNull
    @Size(min = 5, message="You must be at least  5 chaaracters long" )
    private String name;

    @NotNull
    @Size(min = 1, message="You must choose at least 1 ingredient" )
    private List<Ingredient> ingredients;
}
