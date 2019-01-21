package com.wj.service.impl;

import com.wj.bean.model.IndexWebGroup;
import com.wj.bean.model.SysUser;
import com.wj.config.exception.SystemException;
import com.wj.dao.WebGroupMapper;
import com.wj.service.WebGroupService;
import com.wj.utils.Constants;
import com.wj.utils.FileUtil;
import com.wj.utils.PathUtil;
import com.wj.utils.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.IOException;

/**
 * Created by wj on 2018/12/24.
 */
@Service
@Transactional
public class WebGroupServiceImpl implements WebGroupService {

    private static final Log log = LogFactory.getLog(WebGroupServiceImpl.class);

    @Autowired
    private WebGroupMapper webGroupMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addWebGroup(IndexWebGroup webGroup, MultipartFile imgFile) {
        try {
            // TODO userId暂用administrator的id，以后换成登录用户的id
            String userId = "9314552ded3a4052947012f41a211733";
            String imgName = FileUtil.saveFile(imgFile);
            imgName = imgName == "" ? "" : "/img/webgroup/user_img/" + imgName;
            if (null != webGroup) {
                webGroup.setUserId(userId);
                webGroup.setImage(imgName);
                webGroupMapper.insertSelective(webGroup);
            }
        } catch (Exception e) {
            log.error("----保存栏目失败！--------------------------------------------------------------");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateGroupTitle(String title, String littleTitle, Integer groupId) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (user == null) {
            // TODO 这里应该抛出未登录异常
            throw new SystemException();
        };
        // TODO 只能修改属于自己得网页，当前的用户id
        String userId = user.getUserId();
        log.info("修改分组标题-----title:" + title
                + ";littleTitle:" + littleTitle
                + ";groupId:" + groupId
                + ";userId:" + userId);
        return webGroupMapper.updateGroupTitle(title, littleTitle, groupId, userId);
    }
}
