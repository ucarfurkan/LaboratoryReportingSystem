package com.ucarfurkan.LaboratoryReportingSystem.Repository;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {
}
