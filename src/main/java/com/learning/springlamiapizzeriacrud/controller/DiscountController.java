package com.learning.springlamiapizzeriacrud.controller;

import com.learning.springlamiapizzeriacrud.model.Discount;
import com.learning.springlamiapizzeriacrud.model.Pizza;
import com.learning.springlamiapizzeriacrud.repository.DiscountRepository;
import com.learning.springlamiapizzeriacrud.repository.PizzaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/discounts")
public class DiscountController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private DiscountRepository discountRepository;

    // Metodo per creare una nuova offerta
    @GetMapping("/create")
    public String create(@RequestParam(name = "pizzaId", required = true) Integer pizzaId, Model model) {

        // Verifico se la pizza esiste
        Optional<Pizza> result = pizzaRepository.findById(pizzaId);

        if (result.isPresent()) {
            // Prendo la Pizza dall'Optional
            Pizza pizzaToDiscount = result.get();

            // Passo al Model la Pizza come attributo
            model.addAttribute("pizza", pizzaToDiscount);

            // Preparo il discount
            Discount newDiscount = new Discount();

            // Precarico i campi del Discount
            newDiscount.setPizza(pizzaToDiscount);
            newDiscount.setStartDate(LocalDate.now());
            newDiscount.setExpireDate(LocalDate.now().plusDays(30));
            model.addAttribute("discount", newDiscount);

            // Restituisco il template
            return "discounts/create";
        } else {
            // Se l'Optional è vuoto sollevo un' eccezione 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza with id " + pizzaId + " not found");
        }
    }

    @PostMapping("/create")
    public String store(@Valid @ModelAttribute("discount") Discount formDiscount, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("pizza", formDiscount.getPizza());
            return "discounts/create";
        } else {
            Discount savedDiscount = discountRepository.save(formDiscount);
            return "redirect:/pizzas/show/" + savedDiscount.getPizza().getId();
        }
    }

    // Metodo per il form di modifica
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        // Recupero il Discount con quell'ID
        Optional<Discount> result = discountRepository.findById(id);

        // Se è presente precarico il font con il Discount
        if (result.isPresent()) {
            Discount updatedDiscount = result.get();
            model.addAttribute("discount", updatedDiscount);
            return "discounts/edit";
        } else {
            // Altrimenti sollevo un'eccezione HTTP 404
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Discount with id " + id + " not found");
        }
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable Integer id, @Valid @ModelAttribute("discount") Discount formDiscount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "discounts/edit";
        }
        Discount updateDiscount = discountRepository.save(formDiscount);
        return "redirect:/pizzas/show/" + updateDiscount.getPizza().getId();
    }
}

















