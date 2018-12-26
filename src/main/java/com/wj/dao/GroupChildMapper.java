package com.wj.dao;

import com.wj.bean.model.IndexGroupChild;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by wj on 2018/12/21.
 */
public interface GroupChildMapper extends Mapper<IndexGroupChild> {
    List<IndexGroupChild> listByUsername(String username);
}
