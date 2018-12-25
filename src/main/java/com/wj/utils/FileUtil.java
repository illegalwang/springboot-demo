package com.wj.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 对文件的操作类，包括保存文件等
 * Created by wj on 2018/12/25.
 */
public class FileUtil {

    private static final Log log = LogFactory.getLog(FileUtil.class);

    /**
     * 保存文件，返回文件路径
     * @param webFile
     * @return filePath
     */
    public static String saveFile(MultipartFile webFile) throws IOException {
        String webFileName = "";
        if (null != webFile && !webFile.isEmpty()) {
            // 获取文件名
            String name = webFile.getOriginalFilename();
            // 文件名字由UUID生成，避免重复覆盖
            webFileName = name.split("\\.")[0] + UUIDUtil.getTimeUUID() + "." + name.split("\\.")[1];
            // 设置文件保存路径
            String filePath = Constants.USER_IMAGE_FOLDER + webFileName;

            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            // 把上传的文件复制到新文件上
            webFile.transferTo(file);
        }
        return webFileName;
    }
}
