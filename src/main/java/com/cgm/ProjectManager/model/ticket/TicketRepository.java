package com.cgm.ProjectManager.model.ticket;


import com.cgm.ProjectManager.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {


    List<Ticket> findAllByProject(Project project);

    @Query("SELECT t FROM Ticket t WHERE t.issueKey = ?1")
    Ticket findByIssueKey(String issueKey);

    @Transactional
    @Modifying
    @Query("DELETE FROM Ticket t WHERE t.issueKey = ?1")
    void deleteTicketByIssueKey(String issueKey);
}
