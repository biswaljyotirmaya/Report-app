package com.jb.reportapp.service;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.repository.CitizenPlanRepository;
import com.jb.reportapp.request.SearchRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements IRepostService{

    @Autowired
    private CitizenPlanRepository citizenPlanRepository;

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
        if(null!=searchRequest.getPlanName() && !"".equals(searchRequest.getPlanName())){
            entity.setPlanName(searchRequest.getPlanName());
        }
        if(null!=searchRequest.getPlanStatus() && !"".equals(searchRequest.getPlanStatus())){
            entity.setPlanStatus(searchRequest.getPlanStatus());
        }
        if(null!=searchRequest.getGender() && !"".equals(searchRequest.getGender())){
            entity.setGender(searchRequest.getGender());
        }

        return citizenPlanRepository.findAll(Example.of(entity));
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
