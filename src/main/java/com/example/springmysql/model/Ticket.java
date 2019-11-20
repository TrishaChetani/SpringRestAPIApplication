package com.example.springmysql.model;
import lombok.*;

import org.springframework.data.annotation.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Table(name ="ticket")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private int amount;
    private String category;

}
