package com.example.springmysql.service;

import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("service")
public class TicketService {
    @Autowired
    private TicketRepository repository;

    public Ticket addTicket(Ticket ticket){
        return repository.save(toEntity(ticket));

    }


    public List<Ticket> getTicket() {
       List <Ticket> ticket = repository.findAll();
       System.out.println("Getting data from DB : " + ticket);
       return (List<Ticket>) repository.findAll();
    }


    public List<Ticket> getTicketByCategory(String category) {
        return repository.findByCategory(category);
    }

    public void deleteTicket(Integer id) {
        repository.deleteById(id);
    }


    private Ticket toEntity(Ticket dto) {
        Ticket entity = new Ticket();
        entity.setAmount(dto.getAmount());
        entity.setCategory(dto.getCategory());
        return entity;
    }

}
