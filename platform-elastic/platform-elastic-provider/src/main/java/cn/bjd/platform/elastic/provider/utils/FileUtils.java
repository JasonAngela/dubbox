package cn.bjd.platform.elastic.provider.utils;

import java.io.File;

/**
 * Created by Administrator on 2017/6/27.
 */
public final class FileUtils extends org.apache.commons.io.FileUtils {

    /**
     * 判断是否文件
     *
     * @param path 文件
     */
    public static void createDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

}
