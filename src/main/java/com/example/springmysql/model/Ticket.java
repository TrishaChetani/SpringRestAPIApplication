package com.example.springmysql.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name ="Ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private int id;
    private int amount;
    private String category;
}
