package com.jb.reportapp.service;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.repository.CitizenPlanRepository;
import com.jb.reportapp.request.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IRepostService{

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

    @Override
    public List<String> getPlanNames() {
        return List.of();
    }

    @Override
    public List<String> getPlanStatuses() {
        return List.of();
    }

    @Override
    public List<CitizenPlan> search(SearchRequest searchRequest) {
        return List.of();
    }

    @Override
    public boolean exportExcel() {
        return false;
    }

    @Override
    public boolean exportPdf() {
        return false;
    }
}
