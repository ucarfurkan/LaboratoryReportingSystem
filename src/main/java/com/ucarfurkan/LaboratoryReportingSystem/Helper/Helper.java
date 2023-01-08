package com.ucarfurkan.LaboratoryReportingSystem.Helper;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;

public class Helper{
    public static boolean isReportListEmpty(Patient patient){
        if(patient != null){
            if(patient.getReports().size() == 0){
                return true;
            }
        }
        return false;
    }
}


