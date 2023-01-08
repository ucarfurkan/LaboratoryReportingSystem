package com.ucarfurkan.LaboratoryReportingSystem.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "patients")
public class Patient extends Person{
    @Column(name = "identity_no")
    private String identityNo;

    @OneToMany(mappedBy = "patient")
    private List<Report> reports;

    public Patient() {
    }

    public Patient(String name, String identityNo) {
        super(name);
        this.identityNo = identityNo;
    }

    public List<Report> getReports() {
        if(this.reports == null){
            this.setReports(new ArrayList<>());
        }
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public String getIdentityNo() {
        return identityNo;
    }

    public void setIdentityNo(String identityNo) {
        this.identityNo = identityNo;
    }
}
