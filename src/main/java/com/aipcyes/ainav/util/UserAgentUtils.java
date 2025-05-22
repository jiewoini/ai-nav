package com.aipcyes.ainav.util;

import com.aipcyes.ainav.entity.UserAgentInfo;

public class UserAgentUtils {

    public static UserAgentInfo parse(String userAgent) {
        UserAgentInfo info = new UserAgentInfo();
        if (userAgent == null) return info;

        userAgent = userAgent.toLowerCase();

        // 简单判断浏览器
        if (userAgent.contains("chrome")) {
            info.setBrowser("Chrome");
        } else if (userAgent.contains("firefox")) {
            info.setBrowser("Firefox");
        } else if (userAgent.contains("safari")) {
            info.setBrowser("Safari");
        } else {
            info.setBrowser("Other");
        }

        // 简单判断操作系统
        if (userAgent.contains("windows")) {
            info.setOs("Windows");
        } else if (userAgent.contains("mac os x")) {
            info.setOs("Mac OS X");
        } else if (userAgent.contains("android")) {
            info.setOs("Android");
        } else if (userAgent.contains("iphone")) {
            info.setOs("iOS");
        } else {
            info.setOs("Other");
        }

        // 判断是否是爬虫
        boolean isBot = userAgent.contains("bot") || userAgent.contains("spider") || userAgent.contains("crawl");
        info.setBot(isBot);
        if (isBot) {
            info.setBotName(extractBotName(userAgent));
            info.setDeviceType("Bot");
        } else {
            info.setDeviceType("PC"); // 简化处理，也可以根据 userAgent 进一步识别
        }

        return info;
    }

    private static String extractBotName(String ua) {
        if (ua.contains("googlebot")) return "Googlebot";
        if (ua.contains("bingbot")) return "Bingbot";
        if (ua.contains("baiduspider")) return "Baiduspider";
        if (ua.contains("censysinspect")) return "CensysInspect";
        if (ua.contains("expanse")) return "Expanse Scanner";
        return "Unknown Bot";
    }
}

