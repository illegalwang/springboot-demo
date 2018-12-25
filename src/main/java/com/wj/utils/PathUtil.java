package com.wj.utils;

import java.io.File;

/**
 * 获取路径工具类
 * Created by wj on 2018/12/24.
 */
public class PathUtil {

    /**
     * 获取到classes目录
     *
     * @return path
     */
    public static String getClassPath() {
        String systemName = System.getProperty("os.name");
        // 判断当前环境如果是windows，要截取路径的第一个“/”
        if (!StringUtil.isBlank(systemName) && systemName.indexOf("Windows") != -1)
            return PathUtil.class.getResource("/").getFile().toString().substring(1);
        else
            return PathUtil.class.getResource("/").getFile().toString();
    }

    /**
     * 获取当前对象的路径
     *
     * @param object
     * @return path
     */
    public static String getObjectPath(Object object) {
        return object.getClass().getResource(".").getFile().toString();
    }

    /**
     * 获取到项目的路径
     *
     * @return path
     */
    public static String getProjectPath() {
        return System.getProperty("user.dir");
    }

    /**
     * 获取一个目录下所有的文件
     *
     * @param path
     * @return File[]
     */
    public static File[] getFiles(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        return files;
    }

    /**
     * 获取ftl模板所在文件夹路径
     *
     * @return path
     */
    public static String getTemplatePath() {
        return getClassPath() + "templates";
    }

    /**
     * 文本换行
     *
     * @return nextLine
     */
    public static String nextLine() {
        String nextLine = System.getProperty("line.separator");
        return nextLine;
    }

    public static void main(String[] args) {
        System.out.println(getClassPath());
        System.out.println(getProjectPath());
        System.out.println(nextLine());
//        System.out.println(getClassPath().replace("classes/", ""));
        System.out.println(getTemplatePath());
    }
}
