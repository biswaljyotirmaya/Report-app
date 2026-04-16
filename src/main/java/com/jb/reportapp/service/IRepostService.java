package com.jb.reportapp.service;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.request.SearchRequest;

import java.util.List;

public interface IRepostService {
    public List<String> getPlanNames();
    public List<String> getPlanStatuses();
    public List<CitizenPlan> search(SearchRequest searchRequest);
    public boolean exportExcel();
    public boolean exportPdf();
}
