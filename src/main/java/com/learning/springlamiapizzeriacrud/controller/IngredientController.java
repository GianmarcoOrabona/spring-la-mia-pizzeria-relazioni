package com.learning.springlamiapizzeriacrud.controller;

import com.learning.springlamiapizzeriacrud.model.Ingredient;
import com.learning.springlamiapizzeriacrud.repository.IngredientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    // Metodo che mostra tutti gli ingredienti
    @GetMapping
    public String index(Model model) {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        model.addAttribute("ingredientList", ingredientList);
        return "ingredients/list";

    }

    // Metodo che mi restituisce la view create
    @GetMapping("/create")
    public String create(Model model) {
        Ingredient ingredient = new Ingredient();
        model.addAttribute("ingredient", ingredient);
        return "ingredients/create";
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "ingredients/create";
        }
        Ingredient savedIngredient = ingredientRepository.save(formIngredient);
        return "redirect:/ingredients";
    }

}
