package com.learning.springlamiapizzeriacrud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "pizzas")
public class Pizza {
    // ATTRIBUTI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Size(min = 5, max = 50)
    @NotEmpty(message = "Name must not be empty!")
    private String name;

    @Lob
    @Column(nullable = false)
    @Size(min = 10, max = 200
    )
    @NotEmpty(message = "Description must not be empty!")
    private String description;

    @Lob
    private String imgUrl;


    @Column(nullable = false)
    @DecimalMin(value = "1.00", message = "Price can't be lower than 1.00")
    @NotNull(message = "Price must not be empty")
    private BigDecimal price;

    // Attributo che rappresenta le offerte (Relazione Uno A Molti)
    @OneToMany(mappedBy = "pizza", orphanRemoval = true)
    private List<Discount> discounts;

    // Attributo che rappresenta gli ingredienti (Relazione Molti A Molti)
    @ManyToMany
    private List<Ingredient> ingredients;

    // METODI

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    // METODI CUSTOM

    public Boolean activeDiscounts() {
        int counter = 0;
        for (Discount discount : discounts) {
            if (discount.isDiscountActive()) {
                counter++;
            }
        }
        return counter > 0;
    }
}
