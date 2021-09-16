package com.cgm.ProjectManager.model.ticket;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findAllByProjectId(Long projectId);
}
