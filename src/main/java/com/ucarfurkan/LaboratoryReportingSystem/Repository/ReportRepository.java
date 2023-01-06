package com.ucarfurkan.LaboratoryReportingSystem.Repository;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
