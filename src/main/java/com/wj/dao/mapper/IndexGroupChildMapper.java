package com.wj.dao.mapper;

import com.wj.bean.model.IndexGroupChild;
import com.wj.bean.model.IndexGroupChildExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexGroupChildMapper {
    long countByExample(IndexGroupChildExample example);

    int deleteByExample(IndexGroupChildExample example);

    int deleteByPrimaryKey(Integer webId);

    int insert(IndexGroupChild record);

    int insertSelective(IndexGroupChild record);

    List<IndexGroupChild> selectByExample(IndexGroupChildExample example);

    IndexGroupChild selectByPrimaryKey(Integer webId);

    int updateByExampleSelective(@Param("record") IndexGroupChild record, @Param("example") IndexGroupChildExample example);

    int updateByExample(@Param("record") IndexGroupChild record, @Param("example") IndexGroupChildExample example);

    int updateByPrimaryKeySelective(IndexGroupChild record);

    int updateByPrimaryKey(IndexGroupChild record);
}