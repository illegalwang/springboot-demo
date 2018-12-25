package com.wj.service;

import com.wj.bean.model.IndexWebGroup;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by wj on 2018/12/24.
 */
public interface WebGroupService {
    /**
     * 添加栏目
     * @param webGroup
     * @param imgFile
     */
    void addWebGroup(IndexWebGroup webGroup, MultipartFile imgFile);
}
