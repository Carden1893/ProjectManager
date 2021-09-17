package com.cgm.ProjectManager.model.importer;

import com.cgm.ProjectManager.model.datatypes.enums.IssueType;
import com.cgm.ProjectManager.model.datatypes.enums.Status;
import com.cgm.ProjectManager.model.project.Project;
import com.cgm.ProjectManager.model.ticket.Ticket;
import com.cgm.ProjectManager.model.ticket.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ImporterService {

    private final TicketService ticketService;

    @Autowired
    public ImporterService(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    public void initialTicketImportForProject(String csvFilePath, Project project) throws IOException {
        File getCsvFile = new File(csvFilePath);
        String line = "";
        int lineCount = 0;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<HashMap<String, String>> allHeadersAndValues = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(csvFilePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (Exception e) {
        }

        //Splitting all lines in an ArrayList
        while ((line = bufferedReader.readLine()) != null) {
            lineCount++;
            lines.add(line);
        }

        //Getting the Header Array
        String[] headers = lines.get(0).split(",");
        //Getting the values from each imported line and fill a Hashmap for each of them
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            HashMap<String, String> headersAndValues = new HashMap<>();
            for (int j = 0; j < headers.length; j++) {
                headersAndValues.put(headers[j].toLowerCase(), values[j].toLowerCase());
            }
            allHeadersAndValues.add(headersAndValues);
        }
        createAndSaveTickets(allHeadersAndValues, project);
    }


    public void createAndSaveTickets(ArrayList<HashMap<String, String>> headersAndValues, Project project){

        headersAndValues.forEach(ticketValuesToParse -> {
            String issueKeyString = ticketValuesToParse.get("issue key");
            String issueTypeString = ticketValuesToParse.get("issue type");
            Long originalEstimate = Long.parseLong(ticketValuesToParse.get("original estimate").isEmpty() ? "0" : ticketValuesToParse.get("original estimate"));
            Long remainingEstimate = Long.parseLong(ticketValuesToParse.get("remaining estimate").isEmpty() ? "0" : ticketValuesToParse.get("remaining estimate"));
            Long timeSpent = Long.parseLong(ticketValuesToParse.get("time spent").isEmpty() ? "0" : ticketValuesToParse.get("time spent"));
            String summary = ticketValuesToParse.get("summary").isEmpty() ? "0" : ticketValuesToParse.get("summary");
            String statusString = ticketValuesToParse.get("status");

            IssueType issueType = IssueType.getIssueTypeByText(issueTypeString);
            Status status = Status.getStatusByText(statusString);

            Ticket ticketToSave = new Ticket(   issueKeyString,
                                                issueType,
                                                originalEstimate,
                                                remainingEstimate,
                                                timeSpent,
                                                summary,
                                                status,
                                                project);
            /*ticketToSave.setIssueKey(issueKeyString);
            ticketToSave.setIssueType(issueType);
            ticketToSave.setOriginalEstimate(originalEstimate);
            ticketToSave.setRemainingEstimate(remainingEstimate);
            ticketToSave.setTimeSpent(timeSpent);
            ticketToSave.setSummary(summary);
*/
            ticketService.addTicket(ticketToSave);
        });
    }

    String abc = "";
}
