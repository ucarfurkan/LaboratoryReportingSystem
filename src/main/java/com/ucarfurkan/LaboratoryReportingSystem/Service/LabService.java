package com.ucarfurkan.LaboratoryReportingSystem.Service;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Person;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;

import java.util.List;

public interface LabService {
    void addNewPatient(Patient patient);
    void addNewReport(Report report);
    void addNewLabTechnician(LabTechnician labTechnician);
    List<Report> getAllReports();
    List<Person> getAllPatients();
    List<Person> getAllLabTechnician();
    void deleteReportById(Long id);
    Report getReportById(Long id);
    void updateReport(Report report);
    void updatePatient(Patient patient);
    Patient getPatientById(Long id);
    List<Report> getBySearch(String patientName, String labTechnicianName, String patientIdentityNo);
    List<Report> sortReportsByDate(String sortBy);
}
