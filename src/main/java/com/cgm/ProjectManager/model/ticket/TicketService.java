package com.cgm.ProjectManager.model.ticket;

import com.cgm.ProjectManager.model.project.Project;
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

    public Ticket getTicket(Long ticketId) {
        return ticketRepository.getById(ticketId);
    }

    public void deleteTicketById(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void addTickets(List<Ticket> tickets) {
        ticketRepository.saveAll(tickets);
    }


    public void deleteTicketByIssueKey(String issueKey){
        ticketRepository.deleteTicketByIssueKey(issueKey);
    }

    public List<Ticket> getTicketsForProjectId(Project project) {
        return ticketRepository.findAllByProject(project);
    }

    public boolean ticketAlreadyImported(String issueKey) {
        if(ticketRepository.findByIssueKey(issueKey) != null) {
            return true;
        } else {
            return false;
        }
    }

}
