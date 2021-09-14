package com.cgm.ProjectManager.model.vacation;

import com.cgm.ProjectManager.model.vacation.Vacation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "/vacation")
public class VacationController {
    
    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping(path = "/vacations")
    public List<Vacation> getVacations() {
        return vacationService.getVacations();
    }

    @GetMapping(path = "/{vacationId}")
    public Vacation getVacationById(@PathVariable("vacationId") String vacationId) {
        return vacationService.getVacation(vacationId);
    }

    @DeleteMapping(path = "/delete/{vacationId}")
    public void deleteVacation(@PathVariable("vacationId") String vacationId){
        vacationService.deleteVacationById(vacationId);
    }

    @PutMapping(path = "/add/{vacation}")
    public void addVacation(@RequestBody Vacation vacation){
        vacationService.addVacation(vacation);
    }

    @PutMapping(path = "/add/{vacationList}")
    public void addVacations(@RequestBody List<Vacation> vacations){
        vacationService.addVacations(vacations);
    }






}
