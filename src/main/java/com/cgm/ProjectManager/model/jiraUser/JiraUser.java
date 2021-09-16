package com.cgm.ProjectManager.model.jiraUser;

import com.cgm.ProjectManager.model.datatypes.constants.CGMJiraLink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jiraUser")
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JiraUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    private String password;


}
