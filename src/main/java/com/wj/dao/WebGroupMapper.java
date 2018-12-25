package com.wj.dao;

import com.wj.bean.WebGroup;
import com.wj.bean.model.IndexWebGroup;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by wj on 2018/12/21.
 */
public interface WebGroupMapper extends Mapper<IndexWebGroup> {
    List<WebGroup> listByUsername(String username);
}
