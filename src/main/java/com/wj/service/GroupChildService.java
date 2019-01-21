package com.wj.service;

import com.wj.bean.model.IndexGroupChild;

/**
 * Created by wj on 2018/12/26.
 */
public interface GroupChildService {
    /**
     * 添加web项
     * @param groupChild
     */
    void addChild(IndexGroupChild groupChild);

    /**
     * 修改web项的分组
     * @return
     */
    int updateChildGroup(Integer webId, Integer groupId);
}
