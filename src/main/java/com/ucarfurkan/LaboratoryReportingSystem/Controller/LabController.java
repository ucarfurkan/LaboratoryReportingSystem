package com.ucarfurkan.LaboratoryReportingSystem.Controller;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.SearchTags;
import com.ucarfurkan.LaboratoryReportingSystem.Service.LabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<Report> list = labService.getAllReports();
        model.addAttribute("reports",list);
        SearchTags searchTags = new SearchTags("","","");
        model.addAttribute("searchTags",searchTags);
        return "index";
    }

    @PostMapping("/search")
    public String searchReports(@ModelAttribute("searchTags") SearchTags searchTags, Model model){
        List<Report> searchedReports = labService.getBySearch(searchTags.getPatientName(),searchTags.getLabTechnicianName(),searchTags.getPatientIdentityNo());
        model.addAttribute("reports",searchedReports);
        return "index";
    }

    @GetMapping("/sortReports")
    public String sortReports(@RequestParam(value = "sortBy", defaultValue = "asc") String sortBy, Model model) {
        List<Report> sortedReports = labService.sortReportsByDate(sortBy);
        model.addAttribute("reports", sortedReports);
        SearchTags searchTags = new SearchTags("","","");
        model.addAttribute("searchTags",searchTags);
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
        updatedReport.setDetailOfDiagnostic(report.getDetailOfDiagnostic());
        labService.updateReport(updatedReport);
        return "redirect:/reports";
    }
}
