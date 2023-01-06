package com.ucarfurkan.LaboratoryReportingSystem.Controller;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
