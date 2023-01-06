package com.ucarfurkan.LaboratoryReportingSystem.Service;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.PersonRepository;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.ReportRepository;

public class LabServiceImpl implements LabService {
    PersonRepository personRepository;
    ReportRepository reportRepository;

    public LabServiceImpl(PersonRepository personRepository, ReportRepository reportRepository){
        this.personRepository = personRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public void addNewPatient(Patient patient) {
        personRepository.save(patient);
    }

    @Override
    public void addNewReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void addNewLabTechnician(LabTechnician labTechnician) {
        personRepository.save(labTechnician);
    }
}
