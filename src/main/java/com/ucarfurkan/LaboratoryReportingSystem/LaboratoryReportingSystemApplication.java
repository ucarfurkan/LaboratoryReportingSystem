package com.ucarfurkan.LaboratoryReportingSystem;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.LabTechnician;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Patient;
import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.PersonRepository;
import com.ucarfurkan.LaboratoryReportingSystem.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LaboratoryReportingSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoryReportingSystemApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ReportRepository reportRepository;

	@Override
	public void run(String... args) throws Exception {
		LabTechnician labTechnician1 = new LabTechnician("Didem Akıncılar","1111111");
		LabTechnician labTechnician2 = new LabTechnician("Furkan Uçar","1123412");
		personRepository.save(labTechnician1);
		personRepository.save(labTechnician2);
		Patient patient1 = new Patient("Kübra","231231232");
		personRepository.save(patient1);
		Patient patient2 = new Patient("Hasta2","332234232");
		personRepository.save(patient2);
		Report report = new Report(labTechnician1,patient1,"üşütme","üşütmüş hasta");
		reportRepository.save(report);
		patient1.getReports().add(report);
		Report report1 = new Report(labTechnician2,patient2,"covid19","solunum yolu enfeksiyonu");
		reportRepository.save(report1);
		patient2.getReports().add(report1);
		Report report2 = new Report(labTechnician2,patient2,"sırt ağrısı","skolyoz");
		reportRepository.save(report2);
		patient2.getReports().add(report2);
	}
}
