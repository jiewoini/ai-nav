package com.aipcyes.ainav.entity;

import lombok.Data;

@Data
public class AiTool {
    private Long id;
    private String name;
    private String url;
    private Long categoryId;
    private Integer sortOrder;
    private Boolean enabled;

    // Getters & Setters
}
