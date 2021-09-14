package com.cgm.ProjectManager.model.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }


    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(String ticketId) {
        return ticketRepository.getById(ticketId);
    }

    public void deleteTicketById(String ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void addTickets(List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }

}
