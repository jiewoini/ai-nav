package com.aipcyes.ainav.util;

import com.aipcyes.ainav.entity.UserAgentInfo;
import com.aipcyes.ainav.entity.VisitLog;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

public class VisitLogBuilder {

    public static VisitLog buildFromRequest(HttpServletRequest request) {
        VisitLog log = new VisitLog();
        log.setVisitTime(LocalDateTime.now());
        log.setIp(getClientIp(request));
        log.setUserAgent(request.getHeader("User-Agent"));
        log.setReferer(request.getHeader("Referer"));

        // 解析 User-Agent 这里假设你已有解析工具 UserAgentUtil.parse()
        UserAgentInfo uaInfo = UserAgentUtils.parse(log.getUserAgent());
        log.setBrowser(uaInfo.getBrowser());
        log.setOs(uaInfo.getOs());
        log.setDeviceType(uaInfo.getDeviceType());
        log.setIsBot(uaInfo.isBot());
        log.setBotName(uaInfo.getBotName());

        // 解析 IP 地理信息
        IpGeoUtil.GeoInfo geo = IpGeoUtil.parseIp(log.getIp());
        log.setCountry(geo.getCountry());
        log.setProvince(geo.getProvince());
        log.setCity(geo.getCity());
        log.setIsp(geo.getIsp());
        return log;
    }

    // 你之前可能已有的获取客户端 IP 的方法
    private static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.contains(",")) {
            ip = ip.split(",")[0].trim();
        }
        return ip;
    }
}
