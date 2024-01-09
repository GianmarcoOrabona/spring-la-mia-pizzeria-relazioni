package com.learning.springlamiapizzeriacrud.controller;

import com.learning.springlamiapizzeriacrud.model.Pizza;
import com.learning.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
    // Aggiungo il repository come attributo e lo annoto come @Autowired
    @Autowired
    private PizzaRepository pizzaRepository;

    // Metodo che mi mostra tutte le pizze
    @GetMapping
    public String index(Model model) {
        List<Pizza> pizzaList = pizzaRepository.findAll();

        // Aggiungo la lista di pizze al model
        model.addAttribute("pizzaList", pizzaList);

        // Restituisco il template
        return "/pizzas/list";
    }


}
