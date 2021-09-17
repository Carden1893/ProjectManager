package com.cgm.ProjectManager.model.ticket;


import com.cgm.ProjectManager.model.importer.ImporterService;
import com.cgm.ProjectManager.model.project.Project;
import com.cgm.ProjectManager.model.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "api/ticket")
public class TicketController {


    private final TicketService ticketService;

    private final ImporterService importerService;

    private final ProjectService projectService;

    @Autowired
    public TicketController(TicketRepository ticketRepository, TicketService ticketService, ImporterService importerService, ProjectService projectService) {
        this.ticketService = ticketService;
        this.importerService = importerService;
        this.projectService = projectService;
    }

    @GetMapping(path = "/tickets")
    public List<Ticket> getTickets() {
        return ticketService.getTickets();
    }

    @GetMapping(path = "/{ticketId}")
    public Ticket getTicketById(@PathVariable("ticketId") Long ticketId) {
        return ticketService.getTicket(ticketId);
    }

    @RequestMapping(method = RequestMethod.POST ,headers = "action=initialImport")
    public void initialTicketImport(@RequestParam("importPath") String importPath,
                                    @RequestParam("projectId") Long projectId) throws IOException {
        Project project = projectService.getProject(projectId);
        importerService.initialTicketImportForProject(importPath,project);
    }

}
