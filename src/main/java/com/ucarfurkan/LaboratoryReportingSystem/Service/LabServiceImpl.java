package com.ucarfurkan.LaboratoryReportingSystem.Service;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Person;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.PersonRepository;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Person> persons = personRepository.findAll();
        List<Patient> patients = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Patient) {
                patients.add((Patient) person);
            }
        }
        return patients;
    }

    @Override
    public List<LabTechnician> getAllLabTechnician() {
        List<Person> persons = personRepository.findAll();
        List<LabTechnician> technicians = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof LabTechnician) {
                technicians.add((LabTechnician) person);
            }
        }
        return technicians;
    }

    @Override
    public Patient getPatientByIdNo(String id) {
        List<Patient> people = this.getAllPatients();
        Patient foundPatient=null;
        for(Patient patient : people) {
            if (patient.getIdentityNo().equals(id)) {
                foundPatient = patient;
            }
        }
        return foundPatient;
    }


    @Override
    public void deleteReportById(Long id) {
        reportRepository.deleteById(id);
    }

    @Override
    public Report getReportById(Long id) {
        return reportRepository.getReferenceById(id);
    }

    @Override
    public Optional<Person> getLabTechnicianById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public void updateReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public List<Report> getBySearch(String patientName, String labTechnicianName, String patientIdentityNo) {
        return reportRepository.findBySearch(patientName,labTechnicianName,patientIdentityNo);
    }

    @Override
    public List<Report> sortReportsByDate(String sortBy) {
        List<Report> reports = reportRepository.findAll();

        if(sortBy.equals("asc")){
            return reportRepository.findAll(Sort.by(Sort.Direction.ASC, "dateOfReport"));
        }
        else if(sortBy.equals("desc")){
            return reportRepository.findAll(Sort.by(Sort.Direction.DESC, "dateOfReport"));
        }
        return reports;
    }

}
