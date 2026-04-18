package com.jb.reportapp.service;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface IReportService {
    public List<String> getPlanNames();
    public List<String> getPlanStatuses();
    public List<CitizenPlan> search(SearchRequest searchRequest);
    public boolean exportExcel(HttpServletResponse response) throws Exception;
    public boolean exportPdf(HttpServletResponse response) throws Exception;
}
