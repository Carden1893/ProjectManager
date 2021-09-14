package com.cgm.ProjectManager.model.ticket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/ticket")
public class TicketController {


    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketRepository ticketRepository, TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping(path = "/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping(path = "/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") String ticketId) {
        return ticketService.getTicket(ticketId);
    }

}
