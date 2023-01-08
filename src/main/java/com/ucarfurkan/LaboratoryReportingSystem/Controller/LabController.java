package com.ucarfurkan.LaboratoryReportingSystem.Controller;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Controller
public class LabController {
    LabService labService;

    @Autowired
    public LabController(LabService labService){
        this.labService = labService;
    }

    @GetMapping("/reports")
    public String getAllReports(Model model){
        List<Report> reports = labService.getAllReports();
        model.addAttribute("reports",reports);
        return "index";
    }

    @GetMapping("/reports/{id}")
    public String deleteReports(@PathVariable Long id){
        labService.deleteReportById(id);
        return "redirect:/reports";
    }

    @GetMapping("/reports/details/{id}")
    public String showDetails(@PathVariable Long id, Model model){
        Report report = labService.getReportById(id);
        model.addAttribute("report",report);
        return "details";
    }

    @GetMapping("/reports/update/{id}")
    public String updateReport(@PathVariable Long id, Model model){
        Report report = labService.getReportById(id);
        model.addAttribute("report",report);
        return "update";
    }

    @PostMapping("/reports/{id}")
    public String updatedReport(@PathVariable Long id, @ModelAttribute("report") Report report){
        Report updatedReport = labService.getReportById(id);
        updatedReport.setDiagnostic(report.getDiagnostic());
        updatedReport.setFileNumber(report.getFileNumber());
        updatedReport.setDetailOfDiagnostic(report.getDetailOfDiagnostic());
        Patient patient = report.getPatient();
        patient.setName(report.getPatient().getName());
        patient.setIdentityNo(report.getPatient().getIdentityNo());
        updatedReport.setPatient(patient);
        labService.updatePatient(patient);
        labService.updateReport(updatedReport);
        return "redirect:/reports";
    }
}
