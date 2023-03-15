package com.ucarfurkan.LaboratoryReportingSystem.Controller;

import java.nio.file.Files;
import java.nio.file.Path;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.*;
import com.ucarfurkan.LaboratoryReportingSystem.Service.LabService;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping("/reports")
    public String addReport(@ModelAttribute("report") Report report,
                            @RequestParam("labTechnicianId") Long labTechnicianId,
                            @RequestParam("patientName") String patientName,
                            @RequestParam("patientIdentityNo") String patientIdentityNo,
                            @RequestParam("patientDiagnostic") String patientDiagnostic,
                            @RequestParam("detailOfDiagnostic") String detailOfDiagnostic,
                            @RequestParam("reportImage") MultipartFile image,
                            HttpSe"rvletRequest request,
                            Model model) throws IOException {
        Patient patient;
        if(labService.getPatientByIdNo(patientIdentityNo) == null){
            patient = new Patient(patientName,patientIdentityNo);
            labService.addNewPatient(patient);
        }
        else{
            patient = labService.getPatientByIdNo(patientIdentityNo);
        }

        Report report1 = new Report(null,patient,patientDiagnostic,detailOfDiagnostic);
        Optional<Person> labTechnician1 = labService.getLabTechnicianById(labTechnicianId);
        report1.setPatient(patient);
        report1.setLabTechnician((LabTechnician) labTechnician1.orElse(null));
        labService.addNewReport(report1);

        String fileExtension = FilenameUtils.getExtension(image.getOriginalFilename());
        String fileName = report1.getFileNumber() + "." + fileExtension;
        String uploadDirectory = request.getServletContext().getRealPath("/images/");

        try {
            Path uploadPath = Paths.get(uploadDirectory);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            byte[] bytes = image.getBytes();
            Path filePath = Paths.get(uploadDirectory + fileName);
            Files.write(filePath, bytes);
        } catch (IOException e) {
            throw e;
        }

        return "redirect:/reports";
    }


    @GetMapping("/reports/add")
    public String showAddReportForm(Model model) {
        List<Person> people = labService.getAllPeople();
        List<LabTechnician> technicians = new ArrayList<>();
        for (Person person : people) {
            if (person instanceof LabTechnician) {
                technicians.add((LabTechnician) person);
            }
        }
        model.addAttribute("labTechnicians", technicians);
        return "add-report";
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
