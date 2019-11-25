package com.example.springmysql.controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import com.example.springmysql.SpringMysqlApplication;
import com.example.springmysql.dao.TicketRepository;
import com.example.springmysql.model.Ticket;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        given(ticketController.getAllTickets()).willReturn(allTickets);
        mvc.perform(get("/getTickets")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].category", is(ticket.getCategory())));


    }

  //  @Test
 /*   public void findTicketByCategoryTest() throws Exception {
        Ticket ticket = new Ticket();
        ticket.setCategory("test");
        given(ticketController.findTicketByCategory(ticket.getCategory())).willReturn(ticket);
        mvc.perform(get("/getTicketByCategory/test")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].category", is(ticket.getCategory())));


    }*/

/*    @Test
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
    }*/
}
