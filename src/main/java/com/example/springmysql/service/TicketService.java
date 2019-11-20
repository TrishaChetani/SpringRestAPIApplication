package com.example.springmysql.service;

import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public Ticket addTicket(Ticket ticket){
        return repository.save(ticket);
    }


    public List<Ticket> getTicket() {
       List <Ticket> ticket = repository.findAll();
        System.out.println("Getting data from DB : " + ticket);
        return ticket;
    }


    public List<Ticket> getTicketByAddress(String address) {
        return repository.findByAddress(address);
    }

    public void deleteTicket(Ticket ticket) {
        repository.delete(ticket);
    }

}
