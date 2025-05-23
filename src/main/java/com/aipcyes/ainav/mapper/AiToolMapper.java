package com.aipcyes.ainav.mapper;

import com.aipcyes.ainav.entity.AiTool;
import com.aipcyes.ainav.entity.VisitLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AiToolMapper extends BaseMapper<VisitLog> {
    List<AiTool> findByCategoryId(Long categoryId);
}