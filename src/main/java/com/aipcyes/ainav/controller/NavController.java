package com.aipcyes.ainav.controller;

import com.aipcyes.ainav.entity.Link;
import com.aipcyes.ainav.entity.VisitLog;
import com.aipcyes.ainav.mapper.VisitLogMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
public class NavController {

    @Resource
    private VisitLogMapper visitLogMapper;


    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {
        VisitLog log = new VisitLog();
        log.setVisitTime(LocalDateTime.now());
        log.setIp(getClientIp(request));
        log.setUserAgent(request.getHeader("User-Agent"));
        visitLogMapper.insertVisitLog(log);

        long visitCount = visitLogMapper.countVisitLogs();
        model.addAttribute("visitCount", visitCount);

        List<Link> list = Arrays.asList(
                new Link("AI对话", "讯飞星火AI", "https://xinghuo.xfyun.cn/"),
                new Link("AI对话", "豆包AI", "https://doubao.paluai.com/"),
                new Link("AI对话", "智谱清言", "https://chatglm.cn/"),
                new Link("AI对话", "DeepSeek Chat", "https://chat.deepseek.com/"),
                new Link("AI对话", "文心一言", "https://yiyan.baidu.com/"),
                new Link("AI对话", "通义千问", "https://tongyi.aliyun.com/"),
                new Link("AI对话", "Kimi", "https://kimi.moonshot.cn/"),
                new Link("AI对话", "腾讯元宝", "https://yuanbao.tencent.com/"),
                new Link("AI对话", "秘塔AI搜索", "https://metaso.cn/"),

                // AI写作
                new Link("AI写作", "讯飞绘文", "https://huixie.iflyrec.com/"),
                new Link("AI写作", "笔灵AI写作", "https://ibiling.cn/"),
                new Link("AI写作", "Effidit（腾讯）", "https://effidit.qq.com/"),
                new Link("AI写作", "秘塔写作猫", "https://xiezuocat.com/"),
                new Link("AI写作", "深言达意", "https://shenyandayi.com/"),

                // AI绘画
                new Link("AI绘画", "文心一格", "https://yige.baidu.com/"),
                new Link("AI绘画", "通义万相", "https://tongyi.aliyun.com/wanxiang/"),
                new Link("AI绘画", "触手AI", "https://www.acgnai.art/"),
                new Link("AI绘画", "哩布哩布AI", "https://liblib.art/"),
                new Link("AI绘画", "稿定AI设计", "https://www.gaoding.com/"),

                // AI编程
                new Link("AI编程", "CodeGeeX", "https://codegeex.cn/"),
                new Link("AI编程", "通义灵码", "https://lingma.aliyun.com/"),
                new Link("AI编程", "DeepSeek Coder", "https://deepseek.com/"),
                new Link("AI编程", "豆包MarsCode", "https://mars.doubao.com/"),
                new Link("AI编程", "C知道（CSDN）", "https://so.csdn.net/chat"),

                // AI视频
                new Link("AI视频", "剪映AI", "https://lv.ulikecam.com/"),
                new Link("AI视频", "可灵AI（快手）", "https://kling.kuaishou.com/"),
                new Link("AI视频", "腾讯智影", "https://zenvideo.qq.com/"),
                new Link("AI视频", "蝉镜AI", "https://chanjing.ai/"),
                new Link("AI视频", "即梦AI视频", "https://jimeng.ai/")
        );
        model.addAttribute("links", list);
        return "index"; // 返回Thymeleaf模板
    }
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        return (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) ?
                request.getRemoteAddr() : ip.split(",")[0];
    }
}