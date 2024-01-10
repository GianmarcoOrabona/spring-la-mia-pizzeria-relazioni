package com.learning.springlamiapizzeriacrud.controller;

import com.learning.springlamiapizzeriacrud.model.Pizza;
import com.learning.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
        return "pizzas/list";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Optional<Pizza> result = pizzaRepository.findById(id);
        if (result.isPresent()) {
            Pizza pizza = result.get();
            model.addAttribute("pizza", pizza);
            return "pizzas/show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza " + id + " not found");
        }
    }

    // Metodo che mi restituisce la view /create
    @GetMapping("/create")
    public String create(Model model){
        Pizza pizza = new Pizza();
        model.addAttribute("pizza", pizza);
        return "pizzas/create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute("pizza") Pizza formPizza) {
        Pizza savedPizza = pizzaRepository.save(formPizza);
        return "redirect:/pizzas/show/" + savedPizza.getId();
    }
}
