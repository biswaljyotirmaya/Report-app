package com.jb.reportapp.controller;

import com.jb.reportapp.entity.CitizenPlan;
import com.jb.reportapp.request.SearchRequest;
import com.jb.reportapp.service.IReportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private IReportService reportService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("search", new SearchRequest());
        loadDropdowns(model);
        return "index";
    }

    @PostMapping("/search")
    public String handleSearch(Model model, @ModelAttribute("search") SearchRequest searchRequest) {

        System.out.println(searchRequest);

        List<CitizenPlan> plans= reportService.search(searchRequest);

        model.addAttribute("plans", plans);
        model.addAttribute("search", searchRequest);

        loadDropdowns(model);
        System.out.println(plans);

        return "index";
    }


    private void loadDropdowns(Model model) {
        model.addAttribute("names", reportService.getPlanNames());
        model.addAttribute("status", reportService.getPlanStatuses());
    }

    @GetMapping("/excel")
    public void excelExport(HttpServletResponse response) throws Exception{
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=report.xls");
        reportService.exportExcel(response);
    }
}