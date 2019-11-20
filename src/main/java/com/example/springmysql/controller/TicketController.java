package com.example.springmysql.controller;

import java.util.List;

import com.example.springmysql.model.Ticket;
import com.example.springmysql.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping("/bookTickets")
    @CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD})
    public Ticket bookTicket(@RequestBody Ticket ticket){
        return service.addTicket(ticket);

    }

    @GetMapping("/getTickets")
    @CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD})
    public List <Ticket> getAllTickets(){
        return (List<Ticket>) service.getTicket();
    }

    @GetMapping("/getTicketByAddress/{address}")
    public List<Ticket> findTicketByAddress(@PathVariable String address) {
        return service.getTicketByAddress(address);
    }

    @DeleteMapping(value = "/remove")
    @CrossOrigin(origins = "*", maxAge = 3600, methods= {RequestMethod.GET, RequestMethod.POST,RequestMethod.OPTIONS,RequestMethod.HEAD})
    public Ticket removeTicket(@RequestBody Ticket ticket){
        service.deleteTicket(ticket);
        return ticket;
    }
}

