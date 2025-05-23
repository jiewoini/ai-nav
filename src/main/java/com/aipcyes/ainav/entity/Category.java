package com.aipcyes.ainav.entity;

import lombok.Data;

@Data
public class Category {
    private Long id;
    private String name;
    private String icon;
    private Integer sortOrder;

    // Getters & Setters
}
