package com.ucarfurkan.LaboratoryReportingSystem.Entities;

public class SearchTags {
    private String patientName;
    private String patientIdentityNo;
    private String labTechnicianName;



    public SearchTags(String patientName, String patientIdentityNo, String labTechnicianName) {
        this.patientName = patientName;
        this.patientIdentityNo = patientIdentityNo;
        this.labTechnicianName = labTechnicianName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdentityNo() {
        return patientIdentityNo;
    }

    public void setPatientIdentityNo(String patientIdentityNo) {
        this.patientIdentityNo = patientIdentityNo;
    }

    public String getLabTechnicianName() {
        return labTechnicianName;
    }

    public void setLabTechnicianName(String labTechnicianName) {
        this.labTechnicianName = labTechnicianName;
    }
}
