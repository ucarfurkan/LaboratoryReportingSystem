package com.ucarfurkan.LaboratoryReportingSystem.Service;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Person;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.PersonRepository;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabServiceImpl implements LabService {
    PersonRepository personRepository;
    ReportRepository reportRepository;

    @Autowired
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

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<Person> getAllPatients() {
        return personRepository.findAll().stream()
                .filter(p -> p instanceof Patient)
                .collect(Collectors.toList());
    }

    @Override
    public List<Person> getAllLabTechnician() {
        return personRepository.findAll().stream()
                .filter(p -> p instanceof LabTechnician)
                .collect(Collectors.toList());
    }
}
