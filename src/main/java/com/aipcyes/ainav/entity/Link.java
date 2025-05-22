package com.aipcyes.ainav.entity;

public class Link {

    private Long id;
    private String category; // 分类，如“生成式AI”
    private String name;     // 名称，如“ChatGPT”
    private String url;      // 链接，如“https://chat.openai.com”

    // 构造器、Getter和Setter
    public Link() {}
    public Link(String category, String name, String url) {
        this.category = category;
        this.name = name;
        this.url = url;
    }

    // Getter和Setter省略，可自动生成
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
}