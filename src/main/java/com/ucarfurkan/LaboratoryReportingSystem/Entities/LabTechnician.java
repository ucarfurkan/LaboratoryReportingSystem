package com.ucarfurkan.LaboratoryReportingSystem.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "lab_technicians")
public class LabTechnician extends Person{
    @Column(name = "hospital_id")
    private String hospitalId;

    @OneToMany(mappedBy = "labTechnician")
    private List<Report> reports;

    public LabTechnician() {
    }

    public LabTechnician(String name, String hospitalId) {
        super(name);
        if(hospitalId.length() == 7){
            this.hospitalId = hospitalId;
        }
        else{
            throw new IllegalArgumentException("Hospital ID must be 7 digit.");
        }
    }

    public String getHospitalId() {
        return hospitalId;
    }


    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
