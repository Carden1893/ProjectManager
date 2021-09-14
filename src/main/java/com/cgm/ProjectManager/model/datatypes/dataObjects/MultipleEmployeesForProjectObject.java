package com.cgm.ProjectManager.model.datatypes.dataObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class MultipleEmployeesForProjectObject {
    private Long projectId;
    private HashMap<Long,Double> employeesAndCapacities;
}
