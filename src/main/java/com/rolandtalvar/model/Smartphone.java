package com.rolandtalvar.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

/**
 * Created by rolandtalvar on 28.03.16.
 */
@Entity
public class Smartphone {

    @Id
    private int id;

    @Size(min=2, max=50)
    private String name;

    @Min(1)
    @Digits(integer=6, fraction=0, message="The value must be less than five digits")
    private int price;

    @NotEmpty
    @Size(max = 500)
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
