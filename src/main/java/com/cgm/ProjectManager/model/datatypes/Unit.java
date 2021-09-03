package com.cgm.ProjectManager.model.datatypes;

public enum Unit {
    BE("Backend"),
    FE("Frontend"),
    QA("Quality Assurance");


    public final String description;

    Unit(String description) {
        this.description = description;
    }
}
