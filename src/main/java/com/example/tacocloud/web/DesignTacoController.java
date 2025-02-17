package com.example.tacocloud.web;

import java.util.List;
import java.util.stream.Collectors;

import com.example.tacocloud.*;
import com.example.tacocloud.data.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import com.example.tacocloud.Ingredient.Type;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
    private  final IngredientRepository ingredientRepo;

    @Autowired
    public  DesignTacoController(
            IngredientRepository ingredientRepo){
        this.ingredientRepo = ingredientRepo;
    }
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient>ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
        }
    }
        @ModelAttribute(name = "tacoOrder")
        public TacoOrder order() {
            return new TacoOrder();
        }

        @ModelAttribute(name = "taco")
        public Taco taco () {
            return new Taco();
        }

        @GetMapping
        public String showDesignForm () {
            return "design";
        }
        private Iterable<Ingredient> filterByType (
                List < Ingredient > ingredients, Type type){
            return ingredients
                    .stream()
                    .filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList());
        }
        @PostMapping
        public  String processTaco(
                @Valid Taco taco, Errors errors,
                @ModelAttribute TacoOrder tacoOrder){
        if (errors.hasErrors()){
            return "design";
        }
        tacoOrder.aadTaco(taco);
        log.info("Processing taco: {}", taco);

        return  "redirect:/orders/current";
        }
    }

