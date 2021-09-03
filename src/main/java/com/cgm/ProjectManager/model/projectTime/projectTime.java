package com.cgm.ProjectManager.model.projectTime;

import com.cgm.ProjectManager.model.datatypes.Unit;
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
@Table(name = "projectTime")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class projectTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String remainingTimeId;

    private Unit unit;

    private int remainingTime;

    private int originalEstimatedTime;

    private int timeSpent;




}
