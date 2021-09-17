package com.cgm.ProjectManager.model.ticket;


import com.cgm.ProjectManager.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findAllByProject(Project project);
}
