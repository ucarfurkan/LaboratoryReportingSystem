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
    List<Report> getAllReports();
    List<Patient> getAllPatients();
    List<LabTechnician> getAllLabTechnician();
    Patient getPatientByIdNo(String id);
    void deleteReportById(Long id);
    Report getReportById(Long id);
    Optional<Person> getLabTechnicianById(Long id);
    void updateReport(Report report);
    List<Report> getBySearch(String patientName, String labTechnicianName, String patientIdentityNo);
    List<Report> sortReportsByDate(String sortBy);
}
