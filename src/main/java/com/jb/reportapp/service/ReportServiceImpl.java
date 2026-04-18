package com.jb.reportapp.service;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.repository.CitizenPlanRepository;
import com.jb.reportapp.request.SearchRequest;
import com.jb.reportapp.util.ExcelGenerator;
import com.jb.reportapp.util.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReportServiceImpl implements IReportService {

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

    @Autowired
    private PdfGenerator pdfGenerator;

    @Autowired
    private ExcelGenerator excelGenerator;

    @Override
    public List<String> getPlanNames() {
        return citizenPlanRepository.getPlansName();
    }

    @Override
    public List<String> getPlanStatuses() {
        return citizenPlanRepository.getCitizenStatuses();
    }

    @Override
    public List<CitizenPlan> search(SearchRequest searchRequest) {
        CitizenPlan entity = new CitizenPlan();
        if (null != searchRequest.getPlanName() && !"".equals(searchRequest.getPlanName())) {
            entity.setPlanName(searchRequest.getPlanName());
        }
        if (null != searchRequest.getPlanStatus() && !"".equals(searchRequest.getPlanStatus())) {
            entity.setPlanStatus(searchRequest.getPlanStatus());
        }
        if (null != searchRequest.getGender() && !"".equals(searchRequest.getGender())) {
            entity.setGender(searchRequest.getGender());
        }

        return citizenPlanRepository.findAll(Example.of(entity));
    }

    @Override
    public boolean exportExcel(HttpServletResponse response) throws Exception {
        List<CitizenPlan> allReports = citizenPlanRepository.findAll();
        excelGenerator.generateExcel(response, allReports);
        return true;
    }

    @Override
    public boolean exportPdf(HttpServletResponse response) throws Exception {
        List<CitizenPlan> allReports = citizenPlanRepository.findAll();
        pdfGenerator.generatePdf(response, allReports);
        return true;
    }
}
