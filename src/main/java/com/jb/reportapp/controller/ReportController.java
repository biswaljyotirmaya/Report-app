package com.jb.reportapp.controller;

import com.jb.reportapp.request.SearchRequest;
import com.jb.reportapp.service.IRepostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController {

    @Autowired
    private IRepostService repostService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("search", new SearchRequest());
        loadDropdowns(model);
        return "index";
    }

    @PostMapping("/search")
    public String handleSearch(Model model, @ModelAttribute("search") SearchRequest searchRequest) {

        System.out.println(searchRequest);

        var results = repostService.search(searchRequest);

        model.addAttribute("results", results);
        model.addAttribute("search", searchRequest);

        loadDropdowns(model);

        return "index";
    }


    private void loadDropdowns(Model model) {
        model.addAttribute("names", repostService.getPlanNames());
        model.addAttribute("status", repostService.getPlanStatuses());
    }
}