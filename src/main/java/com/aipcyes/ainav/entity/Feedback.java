package com.aipcyes.ainav.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Feedback {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String message;
    private String ip;
    private LocalDateTime createTime;

    // getter 和 setter 省略
}