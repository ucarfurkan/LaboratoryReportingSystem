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
		LabTechnician labTechnician3 = new LabTechnician("Hayat Uçar","9999999");
		personRepository.save(labTechnician1);
		personRepository.save(labTechnician2);
		personRepository.save(labTechnician3);
/*		Patient patient1 = new Patient("Eren Cumhur","231231232");
		personRepository.save(patient1);
		Patient patient2 = new Patient("Aygün Atilla","332234232");
		personRepository.save(patient2);
		Patient patient3 = new Patient("İzzet Yeter","422634932");
		personRepository.save(patient3);
		Patient patient4 = new Patient("Aysun Beren","222298278");
		personRepository.save(patient4);
		Patient patient5 = new Patient("Suzan Defne","876523459");
		personRepository.save(patient5);
		Report report1 = new Report(labTechnician1,patient1,"Adenit","Lenf düğümü ve lenf bezleri iltihabı, bakteriyal enfeksiyon.");
		reportRepository.save(report1);
		patient1.getReports().add(report1);
		Report report2 = new Report(labTechnician2,patient2,"Akciğer Kanseri","Kontrolsüz hücre çoğalması, kanlı balgam, yüksek ateş");
		reportRepository.save(report2);
		patient2.getReports().add(report2);
		Report report3 = new Report(labTechnician2,patient2,"Ülser","Midede doku kaybı, fazla salgılanan mide asidi, H.pylori bakterisi.");
		reportRepository.save(report3);
		patient2.getReports().add(report3);
		Report report4 = new Report(labTechnician3,patient3,"Gastrit","Mukozal dokuda iltihap. Akut.");
		reportRepository.save(report4);
		patient3.getReports().add(report4);
		Report report5 = new Report(labTechnician1,patient4,"Hemoroid","Kanama, kaşıntı, ağrı, hamilelik.");
		reportRepository.save(report5);
		patient4.getReports().add(report5);
		Report report6 = new Report(labTechnician1,patient5,"Siroz","Hepatit B, obezite, diyabet.");
		reportRepository.save(report6);
		patient5.getReports().add(report6);*/
	}
}
