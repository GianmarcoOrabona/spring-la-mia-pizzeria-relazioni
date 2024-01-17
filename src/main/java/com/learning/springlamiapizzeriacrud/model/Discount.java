package com.learning.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

@Entity
@Table(name = "discounts")
public class Discount {
    // ATTRIBUTI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @PastOrPresent
    private LocalDate startDate;

    private LocalDate expireDate;

    @NotEmpty(message = "Title must not be blank")
    private String title;

    @ManyToOne
    private Pizza pizza;

    // GETTER E SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    // METODI CUSTOM

    public Boolean isExpireDateBeforeStartDate() {
        return expireDate.isBefore(startDate);
    }

    public Boolean isDiscountActive() {
        return (LocalDate.now().isBefore(expireDate) && LocalDate.now().isAfter(startDate)) || (LocalDate.now().isBefore(expireDate));
    }
}
