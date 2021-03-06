package com.hfut.glxy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hfut.glxy.entity.Homework;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author chenliangliang
 * @date 2017/11/29
 */
@Mapper
public interface HomeworkMapper extends BaseMapper<Homework> {

    List<Map<String,Object>> findHomeworkInfo(@Param("cid") String cid);

}
