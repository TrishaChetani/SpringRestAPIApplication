package com.example.springmysql.dao;

import com.example.springmysql.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository <Ticket, Integer> {


}
