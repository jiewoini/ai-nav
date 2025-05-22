package com.aipcyes.ainav.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitLog {
    private Long id;
    private LocalDateTime visitTime;
    private String ip;
    private String userAgent;
    private String referer;
    private String browser;
    private String os;
    private String deviceType;
    private Boolean isBot;
    private String botName;
    private String geoLocation;
    private String country;
    private String province;
    private String city;
    private String isp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
