package com.cgm.ProjectManager.model.vacation;


import com.cgm.ProjectManager.exceptions.exceptionHandling.CustomApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    private final VacationRepository vacationRepository;

    @Autowired
    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    public List<Vacation> getVacations() {
        return vacationRepository.findAll();
    }

    public Vacation getVacation(String vacationId) {
        return vacationRepository.getById(vacationId);
    }

    public void deleteVacationById(String vacationId) {
        if (vacationRepository.existsById(vacationId))
            vacationRepository.deleteById(vacationId);
        else
            throw new CustomApiException(String.format("No Vacation foung with Id: {id}", vacationId));
    }

    public void addVacation(Vacation vacation) {
        vacationRepository.save(vacation);
    }

    public void addVacations(List<Vacation> vacations) {
        vacationRepository.saveAll(vacations);
    }
}
