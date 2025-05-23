package com.aipcyes.ainav.service.impl;

import com.aipcyes.ainav.entity.AiTool;
import com.aipcyes.ainav.entity.Category;
import com.aipcyes.ainav.mapper.AiToolMapper;
import com.aipcyes.ainav.mapper.CategoryMapper;
import com.aipcyes.ainav.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private AiToolMapper aiToolMapper;
    @Override
    public Map<Category, List<AiTool>> getCategoryToolMap() {
        List<Category> categories = categoryMapper.findAllOrdered();
        Map<Category, List<AiTool>> result = new LinkedHashMap<>();
        for (Category category : categories) {
            List<AiTool> tools = aiToolMapper.findByCategoryId(category.getId());
            result.put(category, tools);
        }
        return result;
    }
}
