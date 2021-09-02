package com.cgm.ProjectManager.model.datatypes;

public enum EmployeeType {
    BE("Backend"),
    FE("Frontend"),
    QA("Quality Assurance");


    public final String description;

    EmployeeType(String description) {
        this.description = description;
    }
}
