package com.aipcyes.ainav.service;

import com.aipcyes.ainav.entity.AiTool;
import com.aipcyes.ainav.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    Map<Category, List<AiTool>> getCategoryToolMap();

}
