package com.jb.reportapp.repository;

import com.jb.reportapp.entity.CitizenPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {

    @Query("select distinct(planName) from CitizenPlan")
    public List<String>getPlansName();

    @Query("select distinct(planStatus) from CitizenPlan ")
    public List<String> getCitizenStatuses();

    
}
