package com.wj.service.impl;

import com.wj.bean.WebBean;
import com.wj.bean.WebGroup;
import com.wj.bean.model.IndexGroupChild;
import com.wj.bean.model.SysUser;
import com.wj.bean.model.SysUserExample;
import com.wj.dao.GroupChildMapper;
import com.wj.dao.UserMapper;
import com.wj.dao.WebGroupMapper;
import com.wj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wj on 2018/12/20.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private WebGroupMapper webGroupMapper;
    @Autowired
    private GroupChildMapper groupChildMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public WebBean findWebByUsername(String username) {
        WebBean webBean = new WebBean();
        List<WebGroup> group = new LinkedList<>();
        List<IndexGroupChild> children = new LinkedList<>();
        if (null == username || username.isEmpty()) {
            // 默认访问administrator的主页
            username = "administrator";
        }
        group = webGroupMapper.listByUsername(username);
        children = groupChildMapper.listByUsername(username);
        for (WebGroup g : group) {
            List<IndexGroupChild> cs = new LinkedList<>();
            for (IndexGroupChild c : children) {
                if (c.getGroupId() == g.getGroupId()) {
                    cs.add(c);
                }
            }
            g.setChildren(cs);
        }
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        Integer theme = userMapper.selectByExample(example).get(0).getIndexTheme();
        webBean.setTheme(theme);
        webBean.setGroup(group);
        return webBean;
    }
}
