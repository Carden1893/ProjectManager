package com.cgm.ProjectManager.model.datatypes.enums;

public enum Status {

    IN_PROGRESS("In Progress"),
    NEW("New"),
    IN_TEST("In Test"),
    CODE_REVIEW("Code Review"),
    READY_FOR_TESTING("Ready for Testing"),
    READY_FOR_DEVELOPMENT("Ready for Development"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    NONE("None");

    public final String text;

    Status(String text) {
        this.text = text;
    }

    public static Status getStatusByText(String text){
        text = text.toLowerCase();
        switch (text) {
            case "in progress"              :   return IN_PROGRESS;

            case "new"                      :   return NEW;

            case "in test"                  :   return IN_TEST;

            case "code review"              :   return CODE_REVIEW;

            case "ready for testing"        :   return READY_FOR_TESTING;

            case "ready for development"    :   return READY_FOR_DEVELOPMENT;

            case "accepted"                 :   return ACCEPTED;

            case "rejected"                 :   return REJECTED;

            default                         :   return NONE;
        }
    }
}
