package com.ucarfurkan.LaboratoryReportingSystem.Entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lab_technician_id")
    private LabTechnician labTechnician;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "file_number")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fileNumber;

    @Column(name = "diagnostic")
    private String diagnostic;

    @Column(name = "detail_of_diagnostic")
    private String detailOfDiagnostic;

    @Column(name = "date_of_report")
    private Date dateOfReport;

    public Report() {
    }

    public Report(LabTechnician labTechnician, Patient patient, String diagnostic, String detailOfDiagnostic) {
        this.labTechnician = labTechnician;
        this.patient = patient;
        this.diagnostic = diagnostic;
        this.detailOfDiagnostic = detailOfDiagnostic;
        Instant instant = Instant.now();
        long millis = instant.toEpochMilli();
        this.dateOfReport = new Date(millis);
    }

    public String getPatientName(){
        return patient.getName();
    }

    public String getPatientIdentityNo(){
        return patient.getIdentityNo();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LabTechnician getLabTechnician() {
        return labTechnician;
    }

    public void setLabTechnician(LabTechnician labTechnician) {
        this.labTechnician = labTechnician;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDetailOfDiagnostic() {
        return detailOfDiagnostic;
    }

    public void setDetailOfDiagnostic(String detailOfDiagnostic) {
        this.detailOfDiagnostic = detailOfDiagnostic;
    }

    public Date getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(Date dateOfReport) {
        this.dateOfReport = dateOfReport;
    }
}
