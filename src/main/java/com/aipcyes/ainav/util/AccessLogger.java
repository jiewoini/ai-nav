package com.aipcyes.ainav.util;

import jakarta.servlet.http.HttpServletRequest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccessLogger {

    private static final String LOG_FILE = "visit-log.txt"; // 可放在指定目录如 logs/visit-log.txt

    public static void logVisit(HttpServletRequest request) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String ip = getClientIp(request);
        String userAgent = request.getHeader("User-Agent");

        String log = String.format("[%s] IP: %s, User-Agent: %s%n", time, ip, userAgent);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace(); // 生产环境可以用日志框架记录错误
        }
    }

    private static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        } else {
            ip = ip.split(",")[0]; // 防止有多个IP时取第一个
        }
        return ip;
    }
}
