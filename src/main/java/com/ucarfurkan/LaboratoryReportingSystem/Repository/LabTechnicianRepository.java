package com.ucarfurkan.LaboratoryReportingSystem.Repository;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTechnicianRepository extends JpaRepository<Person, Long>{
}

