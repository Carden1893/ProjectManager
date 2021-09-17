package com.cgm.ProjectManager.model.datatypes.enums;


public enum IssueType {
    USER_STORY("User Story"),
    SUB_TASK("Sub-task"),
    BUG("Bug"),
    NONE("None");

    public final String text;

    IssueType(String text) {
        this.text = text;
    }

    public static IssueType getIssueTypeByText(String text){
        text = text.toLowerCase();
        switch (text) {
            case "sub-task"     :   return SUB_TASK;

            case "user story"   :   return USER_STORY;

            case "bug"          :   return BUG;

            default             :   return NONE;
        }
    }

}
