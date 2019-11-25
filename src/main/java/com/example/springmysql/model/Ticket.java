package com.example.springmysql.model;
import lombok.*;

import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name ="ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private int amount;
    private String category;

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
