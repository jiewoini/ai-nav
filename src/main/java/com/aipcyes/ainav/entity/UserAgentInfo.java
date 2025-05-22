package com.aipcyes.ainav.entity;

import lombok.Data;

@Data
public class UserAgentInfo {
    private String browser;
    private String browserVersion;
    private String os;
    private String deviceType;
    private String botName;
    private boolean isBot;
}
