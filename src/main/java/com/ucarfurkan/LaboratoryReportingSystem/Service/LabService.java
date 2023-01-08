package com.ucarfurkan.LaboratoryReportingSystem.Service;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Person;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;

import java.util.List;
import java.util.Optional;

public interface LabService {
    void addNewPatient(Patient patient);
    void addNewReport(Report report);
    void addNewLabTechnician(LabTechnician labTechnician);
    List<Report> getAllReports();
    List<Person> getAllPatients();
    List<Person> getAllLabTechnician();
    void deleteReportById(Long id);
    Report getReportById(Long id);
}
