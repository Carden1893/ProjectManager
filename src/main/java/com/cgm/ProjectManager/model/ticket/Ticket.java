package com.cgm.ProjectManager.model.ticket;


import com.cgm.ProjectManager.model.datatypes.enums.IssueType;
import com.cgm.ProjectManager.model.datatypes.enums.Status;
import com.cgm.ProjectManager.model.project.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ticketId;

    private String issueKey;

    private IssueType issueType;

    private Status status;

    private Long originalEstimate;

    private String summary;

    private Long remainingEstimate;

    private Long timeSpent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;

    public Ticket(String issueKey, IssueType issueType, Long originalEstimate, Long remainingEstimate, Long timeSpent, String summary, Status status ,Project project) {
        this.issueKey = issueKey;
        this.issueType = issueType;
        this.originalEstimate = originalEstimate;
        this.remainingEstimate = remainingEstimate;
        this.timeSpent = timeSpent;
        this.summary = summary;
        this.status = status;
        this.project = project;
    }
}
