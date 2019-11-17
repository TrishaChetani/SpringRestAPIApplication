package com.example.springmysql.controller;

import com.example.springmysql.dao.TicketDao;
import com.example.springmysql.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketDao dao;

    @PostMapping("/bookTickets")
    public String bookTicket(@RequestBody List<Ticket> ticket){
        dao.saveAll(ticket);
        return "ticket booked :" + ticket.size();
    }

    @GetMapping("/getTickets")
    public List <Ticket> getTickets(){
        return (List<Ticket>) dao.findAll();
    }
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/getTickets").allowedOrigins("http://localhost:9000");
            }
        };
    }
}

