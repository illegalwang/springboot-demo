package com.wj.dao;

import com.wj.bean.WebGroup;
import com.wj.bean.model.IndexWebGroup;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by wj on 2018/12/21.
 */
public interface WebGroupMapper extends Mapper<IndexWebGroup> {
    List<WebGroup> listByUsername(String username);

    int updateGroupTitle(@Param("title") String title,
                         @Param("littleTitle") String littleTitle,
                         @Param("groupId") Integer groupId,
                         @Param("userId") String userId);
}
