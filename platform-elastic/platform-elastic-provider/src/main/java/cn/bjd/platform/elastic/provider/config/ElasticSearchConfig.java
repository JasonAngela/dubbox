package cn.bjd.platform.elastic.provider.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by admin on 2018/1/23 0023.
 */
@Configuration
public class ElasticSearchConfig {
    @Value("${spring.elasticsearch.host}")
    private String host;//elasticsearch的地址

    @Value("${spring.elasticsearch.port}")
    private Integer port;//elasticsearch的端口

    protected final org.slf4j.Logger LOG = LoggerFactory.getLogger(getClass());
    @Bean
    public TransportClient client(){
        TransportClient client = null;
        try {
            Settings settings = Settings.builder().put("cluster.name", "bigdata").build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), port));
        } catch (UnknownHostException e) {
            LOG.error("创建elasticsearch客户端失败");
            e.printStackTrace();
        }
        LOG.info("创建elasticsearch客户端成功");
        return client;
    }
}
