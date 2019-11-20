package com.example.springmysql.controller;

import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import com.example.springmysql.service.TicketService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest

public class TicketControllerTest {
    @Autowired
    private TicketService ticketService;
    @MockBean
    private TicketRepository repository;


    @Test
    public void bookTicketTest() {
        Ticket ticket = new Ticket(2, 33, "Pune");
        when(repository.save(ticket)).thenReturn(ticket);
        assertEquals(ticket, ticketService.addTicket(ticket));


    }

    @Test
    public void getAllTicketsTest() {
        when(repository.findAll())
                .thenReturn(Stream.of(
                        new Ticket(1,1,"test")).collect(Collectors.toList()));
        assertEquals(1, ticketService.getTicket().size());
    }

    @Test
    public void findTicketByAddressTest() {
        String address = "comments";
        when(repository.findByAddress(address))
        .thenReturn(Stream.of(new Ticket(1, 31, "test")).collect(Collectors.toList()));
        assertEquals(1, ticketService.getTicketByAddress(address).size());
    }

    @Test
    public void removeTicketTest() {
        Ticket ticket = new Ticket(1, 33, "Pune");
        ticketService.deleteTicket(ticket);
        verify(repository, times(1)).delete(ticket);
    }
}
