package cn.edu.xmut.personnelmanage.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * jiangjx
 * 配置文件内容加载
 */
@ConfigurationProperties(prefix = "consumer")
@Component
@Data
public class CustomizeProperties {

    private String accessFilterPath;

    private String algorithmName;

    private Integer hashIterations;

}
