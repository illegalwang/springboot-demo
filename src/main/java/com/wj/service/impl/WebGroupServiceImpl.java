package com.wj.service.impl;

import com.wj.bean.model.IndexWebGroup;
import com.wj.bean.model.IndexWebGroupExample;
import com.wj.bean.model.SysUser;
import com.wj.config.exception.SystemException;
import com.wj.dao.GroupChildMapper;
import com.wj.dao.WebGroupMapper;
import com.wj.service.WebGroupService;
import com.wj.utils.FileUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by wj on 2018/12/24.
 */
@Service
@Transactional
public class WebGroupServiceImpl implements WebGroupService {

    private static final Log log = LogFactory.getLog(WebGroupServiceImpl.class);

    @Autowired
    private WebGroupMapper webGroupMapper;

    @Autowired
    private GroupChildMapper groupChildMapper;

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

    @Override
    public List<IndexWebGroup> listGroup() {
        return webGroupMapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteGroup(Integer groupId) {
        IndexWebGroupExample example = new IndexWebGroupExample();
        example.createCriteria().andGroupIdEqualTo(groupId);
        int result = webGroupMapper.deleteByExample(example);
        log.info("删除分组-----groupId:" + groupId);
        if (result > 0) {
            log.info("删除分组，修改child放回垃圾箱-----result：" + result + "; groupId: " + groupId);
            groupChildMapper.logicDeleteGroupAllChild(groupId);
        }
        return result;
    }
}
