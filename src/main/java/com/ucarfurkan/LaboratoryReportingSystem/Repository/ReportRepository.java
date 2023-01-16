package com.ucarfurkan.LaboratoryReportingSystem.Repository;

import com.ucarfurkan.LaboratoryReportingSystem.Entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long>{
    @Query(value = "select r.id as report_id, r.date_of_report, r.detail_of_diagnostic, r.diagnostic, r.file_number, lt.id as lab_technician_id, lt.name as lab_technician_name, p.id as patient_id, p.name as patient_name, p.identity_no from reports r join patients p on r.patient_id = p.id join lab_technicians lt on r.lab_technician_id = lt.id where p.name like concat('%', :patientName, '%') and lt.name like concat('%', :labTechnicianName, '%') and p.identity_no like concat('%', :patientIdentityNo, '%')", nativeQuery = true)
    List<Report> findBySearch(@Param("patientName") String patientName, @Param("labTechnicianName") String labTechnicianName, @Param("patientIdentityNo") String patientIdentityNo);
}
