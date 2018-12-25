package com.wj.service.impl;

import com.wj.bean.model.IndexWebGroup;
import com.wj.dao.WebGroupMapper;
import com.wj.service.WebGroupService;
import com.wj.utils.Constants;
import com.wj.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by wj on 2018/12/24.
 */
@Service
public class WebGroupServiceImpl implements WebGroupService {

    @Autowired
    private WebGroupMapper webGroupMapper;

    @Override
    public void addWebGroup(IndexWebGroup webGroup, MultipartFile imgFile) {
        String fileName = "";
        String image = "";
        if (null != imgFile || imgFile.isEmpty()) {
            fileName = imgFile.getOriginalFilename();
            String filePath = Constants.USER_IMAGE_FOLDER + fileName;
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                // 把用户的图片复制到希望的位置
                imgFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != webGroup)
            webGroupMapper.insertSelective(webGroup);
    }
}
