package com.example.springmysql.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import com.example.springmysql.SpringMysqlApplication;
import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TicketController.class)

public class TicketControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TicketController ticketController;

    @Test
    public void getAllTicketsTest() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setAmount(12);
        ticket.setCategory("test");
        List<Ticket> allTickets = singletonList(ticket);
        given(ticketController.getAllTickets()).willReturn(allTickets);
        mvc.perform(get("/getTickets")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].category", is(ticket.getCategory())));


    }

    @Test
    public void findTicketByCategoryTest() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setAmount(12);
        ticket.setCategory("test");
        List<Ticket> allTickets = singletonList(ticket);
        given(ticketController.findTicketByCategory("test")).willReturn(allTickets);
        mvc.perform(get("/getTicketByCategory/{category}","test")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].category", is(ticket.getCategory())));


    }
    @Test
    public void removeTicketTest() throws Exception {

        Ticket ticket = new Ticket();
        ticket.setAmount(12);
        ticket.setCategory("test");
        List<Ticket> allTickets = singletonList(ticket);
        given(ticketController.findTicketByCategory("test")).willReturn(allTickets);
        mvc.perform(delete("/remove/{id}","1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());


    }
}
