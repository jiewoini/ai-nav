package com.aipcyes.ainav.mapper;

import com.aipcyes.ainav.entity.VisitLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitLogMapper extends BaseMapper<VisitLog> {
    void insertVisitLog(VisitLog log);
    Integer countVisitLogs();
}
