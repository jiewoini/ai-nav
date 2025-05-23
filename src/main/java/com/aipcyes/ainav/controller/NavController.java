package com.aipcyes.ainav.controller;

import com.aipcyes.ainav.entity.*;
import com.aipcyes.ainav.mapper.VisitLogMapper;
import com.aipcyes.ainav.service.CategoryService;
import com.aipcyes.ainav.util.VisitLogBuilder;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class NavController {

    @Resource
    private VisitLogMapper visitLogMapper;

    @Resource
    private CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        VisitLog log = VisitLogBuilder.buildFromRequest(request);
        visitLogMapper.insertVisitLog(log);
        long visitCount = visitLogMapper.countVisitLogs();
        model.addAttribute("visitCount", visitCount);
        Map<Category, List<AiTool>> categoryToolMap = categoryService.getCategoryToolMap();
        model.addAttribute("categoryToolMap", categoryToolMap);
        return "index";
    }
}