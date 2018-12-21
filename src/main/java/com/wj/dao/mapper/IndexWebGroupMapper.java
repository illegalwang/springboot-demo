package com.wj.dao.mapper;

import com.wj.bean.model.IndexWebGroup;
import com.wj.bean.model.IndexWebGroupExample;
import com.wj.bean.model.IndexWebGroupKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IndexWebGroupMapper {
    long countByExample(IndexWebGroupExample example);

    int deleteByExample(IndexWebGroupExample example);

    int deleteByPrimaryKey(IndexWebGroupKey key);

    int insert(IndexWebGroup record);

    int insertSelective(IndexWebGroup record);

    List<IndexWebGroup> selectByExample(IndexWebGroupExample example);

    IndexWebGroup selectByPrimaryKey(IndexWebGroupKey key);

    int updateByExampleSelective(@Param("record") IndexWebGroup record, @Param("example") IndexWebGroupExample example);

    int updateByExample(@Param("record") IndexWebGroup record, @Param("example") IndexWebGroupExample example);

    int updateByPrimaryKeySelective(IndexWebGroup record);

    int updateByPrimaryKey(IndexWebGroup record);
}