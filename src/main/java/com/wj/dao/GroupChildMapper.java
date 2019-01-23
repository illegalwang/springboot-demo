package com.wj.dao;

import com.wj.bean.WebBean;
import com.wj.bean.model.IndexGroupChild;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by wj on 2018/12/21.
 */
public interface GroupChildMapper extends Mapper<IndexGroupChild> {
    List<IndexGroupChild> listByUsername(String username);

    int updateChildGroup(@Param("webId") Integer webId, @Param("groupId") Integer groupId);

    List<IndexGroupChild> listChildByGroupId(Integer groupId);

    int deleteGroupChild(@Param("webIds") Integer[] webIds, @Param("groupId") Integer groupId);
}
