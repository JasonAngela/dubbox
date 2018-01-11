package cn.bjd.platform.common.web.config;

import cn.bjd.platform.common.upload.DiskFileOperator;
import cn.bjd.platform.common.upload.FileOperator;
import cn.bjd.platform.common.upload.util.FileManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件上传配置
 *
 * @author huqilang
 */
@Configuration
public class UploadConfig {

    /**
     * Oss file operator oss file operator.
     *
     * @return the oss file operator
     */
    @Bean
    @ConfigurationProperties("upload")
    public DiskFileOperator diskFileOperator() {
        return new DiskFileOperator();
    }

    /**
     * File manager file manager.
     *
     * @param fileOperator the file operator
     * @return the file manager
     */
    @Bean
    public FileManager fileManager(FileOperator fileOperator) {
        FileManager fileManager = new FileManager();
        fileManager.setFileOperator(fileOperator);
        return fileManager;
    }

}