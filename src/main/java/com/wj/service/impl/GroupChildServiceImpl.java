package com.wj.service.impl;

import com.wj.bean.model.IndexGroupChild;
import com.wj.dao.GroupChildMapper;
import com.wj.service.GroupChildService;
import com.wj.utils.Constants;
import com.wj.utils.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by wj on 2018/12/26.
 */
@Service
@Transactional
public class GroupChildServiceImpl implements GroupChildService {

    private static final Log log = LogFactory.getLog(GroupChildServiceImpl.class);

    @Autowired
    private GroupChildMapper groupChildMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addChild(IndexGroupChild groupChild) {
        if (null != groupChild) {
            if (!StringUtil.isBlank(groupChild.getWebUrl())) {
                String icon = createIconUrl(groupChild.getWebUrl());
                groupChild.setWebIcon(icon);
            }
            groupChildMapper.insertSelective(groupChild);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateChildGroup(Integer webId, Integer groupId) {
        return groupChildMapper.updateChildGroup(webId, groupId);
    }

    @Override
    public List<IndexGroupChild> listChildByGroupId(Integer groupId) {
        List<IndexGroupChild> webBeans = groupChildMapper.listChildByGroupId(groupId);
        log.info("根据GroupId：" + groupId + ";查询Child列表：" + webBeans);
        return webBeans;
    }

    @Override
    public int deleteGroupChlid(Integer[] webIds, Integer groupId) {
        return groupChildMapper.deleteGroupChild(webIds, groupId);
    }

    /**
     * 得到web项图标的url
     * @param str
     * @return
     */
    private String createIconUrl(String str) {
        StringBuffer iconUrl = new StringBuffer();
        try {
            URL url = new URL(str);
            // 获取url的主机名
            String host = url.getHost();
            // 获取url的协议名
            String protocol = url.getProtocol();
            iconUrl.append(protocol);
            iconUrl.append("://");
            iconUrl.append(host);
            iconUrl.append("/");
            iconUrl.append(Constants.WEB_ICON);
            return iconUrl.toString();
        } catch (MalformedURLException e) {
            int i = str.indexOf("/");
            if (i == -1) {
                return jointString(str).toString();
            }
            String url = str.substring(0, i);
            return jointString(url).toString();
        }
    }

    /**
     * 拼接web项图标url
     * @param str
     * @return
     */
    private StringBuffer jointString(String str) {
        StringBuffer iconUrl = new StringBuffer();
        iconUrl.append(str);
        iconUrl.append("/");
        iconUrl.append(Constants.WEB_ICON);
        return iconUrl;
    }

    /*public static void main(String[] args) {
//        System.out.println(createIconUrl("https://blog.csdn.net/asd372506589/article/details/79642041?utm_source=blogxgwz8"));
//        System.out.println(createIconUrl("blog.csdn.net/asd372506589/article/details/79642041?utm_source=blogxgwz8"));
//        System.out.println(createIconUrl("https://blog.csdn.net/"));
//        System.out.println(createIconUrl("www.baidu.com"));
    }*/
}
