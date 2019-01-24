package com.wj.service;

import com.wj.bean.model.IndexWebGroup;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by wj on 2018/12/24.
 */
public interface WebGroupService{
    /**
     * 添加栏目
     * @param webGroup
     * @param imgFile
     */
    void addWebGroup(IndexWebGroup webGroup, MultipartFile imgFile);

    /**
     * 修改分组标题
     * @param title
     * @param littleTitle
     * @param groupId
     * @return
     */
    int updateGroupTitle(String title, String littleTitle, Integer groupId);

    /**
     * 查询所有组
     * @return
     */
    List<IndexWebGroup> listGroup();
}
